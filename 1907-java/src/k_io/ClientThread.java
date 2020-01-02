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
					this.mId=cd.getmId(); // 아이디가 자신이면 메시지를 오른쪽에 배치하기 위해 id를 필드에 저장
					if(frame.getTmId().getText().equals(this.mId)) {
						html = "<div id='a' style='border:1px solid #0000ff; padding:3px; margin-left:100px; width:100px; word-break:break-all;'>"
								+ cd.toString() + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					}else { // 자신의 아이디가 아닌 사람의 메시지는 왼쪽에 배치 
						html = "<div id='b' style='border:1px solid #06ffff; padding:3px; width:100px;'>"
								+ cd.toString() + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					}
					break;
				case ChattData.LOGIN:
					for(int i =0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i);
						frame.model.addElement(mId); // ClientFrame에 있는 JList에 추가 
						// 목록이 갱신되지 않는 경우가 있어 강제로 갱신해준다.
						/*frame.getList().paint(frame.getList().getGraphics()); // frame.getList().updateUI(); 둘이 비슷..?*/
						frame.getList().ensureIndexIsVisible(frame.model.getSize());
					}
					break;
				case ChattData.LOGOUT:
					frame.model.removeElement(cd.getmId());
					frame.getList().paint(frame.getList().getGraphics());
					break;
				case ChattData.GETOUT:
					//서버중지 getout? 특정유저만 강퇴?인지 판단
					if(cd.getUsers() == null) { //서버종료
						html = "<font color = '#a35748'>" + cd.getmId()+"서버가 종료됨 </font>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
						frame.model.clear();
						throw new Exception();
					}else { //강퇴 당했을때
						for(String mId :  cd.getUsers()) {
							if(mId.equals(frame.getTmId().getText())) {
								html = "<font color = '#a35748'>" + "강퇴당하셨습니다. </font>";
								frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
								frame.model.clear();
								
								frame.conA.setEnabled(true); //강퇴 당했을때 버튼을 접속 버튼을 활성화
								frame.exB.setEnabled(false); //강퇴 당했을때 버튼을 종료 버튼을 비활성화
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
