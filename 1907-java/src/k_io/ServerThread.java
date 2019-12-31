package k_io;

import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
		}
	}
	
	public void sendAll(ChattData cd) throws Exception{
		for(ServerThread st : frame.clients) {
			st.oos.writeObject(cd);
			st.oos.flush();
		}
	}
}