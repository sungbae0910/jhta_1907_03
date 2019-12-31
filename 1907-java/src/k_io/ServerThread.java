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
					html = "<font color = '#a35748'>" + cd.getmId()+"가 접속하였습니다. </font>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					
					//먼저 자신과 연결된 oos에게 기존 접속자 목록 전송
					ChattData cd2 = new ChattData();
					List<String> users = new ArrayList<String>();
					for(int i=0; i<frame.model.size(); i++) {
						users.add(frame.model.get(i));
					}
					cd2.setCommand(ChattData.LOGIN);
					cd2.setUsers(users);
					oos.writeObject(cd2);
					oos.flush();
					//자신의 아이디를 model에 추가
					frame.model.addElement(cd.getmId()); //로그인이 들어왔을 때 아이디 값을 model에 담아 표현해준다
					//모든 접속자에게 현재 자신의 아이디를 전송
					users.clear();
					users.add(cd.getmId());
					cd2.setUsers(users);
					sendAll(cd2);
					break;
				case ChattData.MESSAGE:
					html = "<div style='border:1px solid #667434; padding:3px;'>" + cd.toString() + "</div>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					sendAll(cd);
					break;
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendAll(ChattData cd) throws Exception{
		for(ServerThread st : frame.clients) {
			st.oos.writeObject(cd);
			st.oos.flush();
		}
	}
}