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
				case ChattData.MESSAGE:
						html = "<div style='border:1px solid #0000ff; padding:3px; width:150px; margin-left:60px'>"
								+ cd.toString() + "</div>";
						frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					break;
				case ChattData.LOGIN:
					this.mId= cd.getmId();
					for(int i =0; i<cd.getUsers().size(); i++) {
						String mId = cd.getUsers().get(i);
						frame.model.addElement(mId); // ClientFrame에 있는 JList에 추가 
						// 목록이 갱신되지 않는 경우가 있어 강제로 갱신해준다.
						frame.getList().paint(frame.getList().getGraphics()); // frame.getList().updateUI(); 둘다 비슷..?
					}
					break;
				case ChattData.LOGOUT:
					frame.model.removeElement(cd.getmId());
					frame.getList().paint(frame.getList().getGraphics());
					break;
				case ChattData.GETOUT:
					html = "<font color = '#a35748'>" + cd.getmId()+"서버가 종료됨 </font>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					frame.model.clear();
					throw new Exception();
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