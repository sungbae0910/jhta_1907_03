package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
	ClientFrame frame;
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String mId;
	
	public ClientThread() {
		
	}
	
	public ClientThread(ClientFrame frame, Socket socket) {
		this.frame=frame;
		this.socket=socket;
	}
	
	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			frame.login();
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				switch(cd.getCommand()) {
				case ChattData.WHISPER:
				case ChattData.MESSAGE:
					this.mId=cd.getmId(); // ���̵� �ڽ��̸� �޽����� �����ʿ� ��ġ�ϱ� ���� id�� �ʵ忡 ����
					if(frame.getTmId().getText().equals(this.mId)) {
						html = "<div id='a' style='border:1px solid #0000ff; padding:3px; margin-left:100px; width:100px; word-break:break-all;'>"
								+ cd.toString() + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					}else { // �ڽ��� ���̵� �ƴ� ����� �޽����� ���ʿ� ��ġ 
						html = "<div id='b' style='border:1px solid #06ffff; padding:3px; width:100px;'>"
								+ cd.toString() + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					}
					break;
				case ChattData.LOGIN:
					for(int i =0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i);
						frame.model.addElement(mId); // ClientFrame�� �ִ� JList�� �߰� 
						// ����� ���ŵ��� �ʴ� ��찡 �־� ������ �������ش�.
						/*frame.getList().paint(frame.getList().getGraphics()); // frame.getList().updateUI(); ���� ���..?*/
						frame.getList().ensureIndexIsVisible(frame.model.getSize());
					}
					break;
				case ChattData.LOGOUT:
					frame.model.removeElement(cd.getmId());
					frame.getList().paint(frame.getList().getGraphics());
					break;
				case ChattData.GETOUT:
					//�������� getout? Ư�������� ����?���� �Ǵ�
					if(cd.getUsers() == null) { //��������
						html = "<font color = '#a35748'>" + cd.getmId()+"������ ����� </font>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						frame.model.clear();
						throw new Exception();
					}else { //���� ��������
						for(String mId :  cd.getUsers()) {
							if(mId.equals(frame.getTmId().getText())) {
								html = "<font color = '#a35748'>" + "������ϼ̽��ϴ�. </font>";
								frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
								frame.model.clear();
								
								frame.conA.setEnabled(true); //���� �������� ��ư�� ���� ��ư�� Ȱ��ȭ
								frame.exB.setEnabled(false); //���� �������� ��ư�� ���� ��ư�� ��Ȱ��ȭ
								throw new Exception();
							}else {
								frame.model.removeElement(mId);
							}
						}
					}
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		} catch (Exception e) {
			try {
				ois.close();
				oos.close();
				socket.close();
				
				ois = null;
				oos = null;
				socket = null;
			} catch (Exception e2) {
			}
		}
	}
}
