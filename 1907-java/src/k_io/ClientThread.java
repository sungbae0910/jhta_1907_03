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
			while(true) {
				ChattData cd = (ChattData)ois.readObject();
				String html = "";
				switch(cd.getCommand()) {
				case ChattData.MESSAGE:
					html = "<div style='border:1px solid #0000ff; padding:3px; width:150px; margin-left:60px'>"
							+ cd.toString() + "</div>";
					frame.kit.insertHTML(frame.doc, frame.doc.getLength(), html, 0, 0, null);
					break;
				}
				frame.getTextPane().scrollRectToVisible(new Rectangle(0, frame.getTextPane().getHeight()+100, 1, 1));
			}
		} catch (Exception e) {
		}
	}
	

}