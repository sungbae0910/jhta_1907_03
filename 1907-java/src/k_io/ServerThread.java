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
					this.mId = cd.getmId(); // 자신과 연결된 클라이언트의 아이디를 필드에 저장
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
					html = "<font color = '#a35748'>" + cd.getmId()+"가 로그아웃하였습니다. </font>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					throw new Exception(); // logout이라는 명령어가 들어오면 x버튼을 눌렀을 때와 같은 기능을 실행하면 되기 때문에 exception으로 넘김
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		} catch (Exception e) {
			int index = frame.clients.indexOf(ServerThread.this); // 접속종료된 클라이언트 번호를 받음
			frame.model.remove(index); // 목록에서 삭제
			frame.clients.remove(index); // 리스트에서 삭제
			// 다른 유저에게 본인의 로그아웃된 사실을 통보
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