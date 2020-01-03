package l_ftp;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerThread extends Thread{
	Socket socket;
	InputStream is;
	ObjectInputStream ois;
	String fileName;

	public ServerThread(Socket s) {
		this.socket=s;
	}
	
	@Override
	public void run() {
		try {
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			while(true) {
				Object obj = ois.readObject();
			}
		} catch (Exception e) {
		}
	}

	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
