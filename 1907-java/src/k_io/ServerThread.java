package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread{
	ServerFrame frame;
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String mId;
	
	public ServerThread(ServerFrame sf, Socket socket){
		this.frame=sf;
		this.socket=socket;
		
	}
	
	@Override
	public void run() {
		try {
			oos= new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				switch(cd.getCommand()) {
				case ChattData.LOGIN:
					this.mId = cd.getmId(); // �ڽŰ� ����� Ŭ���̾�Ʈ�� ���̵� �ʵ忡 ����
					html = "<font color = '#a35748'>" + cd.getmId()+"�� �����Ͽ����ϴ�. </font>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					//���� �ڽŰ� ����� oos���� ���� ������ ��� ����
					ChattData cd2 = new ChattData();
					List<String> users = new ArrayList<String>();
					for(int i=0; i<frame.model.size(); i++) {
						users.add(frame.model.get(i));
					}
					cd2.setCommand(ChattData.LOGIN);
					cd2.setUsers(users);
					oos.writeObject(cd2);
					oos.flush();
					//�ڽ��� ���̵� model�� �߰�
					frame.model.addElement(cd.getmId()); //�α����� ������ �� ���̵� ���� model�� ��� ǥ�����ش�
					//��� �����ڿ��� ���� �ڽ��� ���̵� ����
					cd2 = new ChattData();
					cd2.setCommand(ChattData.LOGIN);
					users = new ArrayList<String>();
					
					users.add(cd.getmId());
					cd2.setUsers(users);
					sendAll(cd2);
					break;
				case ChattData.MESSAGE:
					html = "<div style='border:1px solid #667434; padding:3px;'>" + cd.toString() + "</div>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					sendAll(cd);
					break;
				case ChattData.LOGOUT:
					html = "<font color = '#a35748'>" + cd.getmId()+"�� �α׾ƿ��Ͽ����ϴ�. </font>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					throw new Exception(); // logout�̶�� ��ɾ ������ x��ư�� ������ ���� ���� ����� �����ϸ� �Ǳ� ������ exception���� �ѱ�
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		} catch (Exception e) {
			int index = frame.clients.indexOf(ServerThread.this); // ��������� Ŭ���̾�Ʈ ��ȣ�� ����
			frame.model.remove(index); // ��Ͽ��� ����
			frame.clients.remove(index); // ����Ʈ���� ����
			// �ٸ� �������� ������ �α׾ƿ��� ����� �뺸
			ChattData cd = new ChattData();
			cd.setCommand(ChattData.LOGOUT);
			cd.setmId(this.mId);
			try {
				sendAll(cd);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void sendAll(ChattData cd) throws Exception{
		for(ServerThread st : frame.clients) {
			st.oos.writeObject(cd);
			st.oos.flush();
		}
	}
}