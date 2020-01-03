package l_ftp;

import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class FileTransferReceive extends JPanel implements Runnable{
	long fileSize;
	FileOutputStream fos;
	InputStream is;
	Socket socket;
	int port;
	JPanel panel;
	
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnNewButton;

	
	public FileTransferReceive() {
		setPreferredSize(new Dimension(418, 67));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnNewButton());

	}
	
	public FileTransferReceive(int port, String file, long fileSize, JPanel panel) {
		this();
		this.port=port;
		this.fileSize = fileSize;
		this.panel=panel;
		getFileName().setText(file);
		status.setText("0/"+fileSize);
		
		try {
			System.out.println(port+"서버 Open");
			Thread t = new Thread(FileTransferReceive.this);
			t.start();
		} catch (Exception e) {
		}
	}
	
	@Override
	public void run() {
		// 지정된 파일을 FileInputStream으로 읽어서 Socket의 DataOutputStream으로 전송
		byte[] readData = new byte[4096];
		int readSize = 0;
		long readTotSize=0;
		getProgressBar().setValue(0);
		try {
			ServerSocket ss = new ServerSocket(port);
			socket = ss.accept();
			
			fos = new FileOutputStream("C:/Temp/"+getFileName().getText());
			is = socket.getInputStream();
			while((readSize= is.read(readData)) != -1 ){
				readTotSize += readSize;
				getStatus().setText(readTotSize+"/"+fileSize);
				getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
				getProgressBar().setStringPainted(true); // %표시하기 위한 소스
				
				fos.write(readData, 0 , readSize);
			}
			fos.flush();
			fos.close();
			is.close();
		} catch (Exception e) {
		}
	}
	
	private JLabel getFileName() {
		if (fileName == null) {
			fileName = new JLabel("\uD30C\uC77C\uBA85");
			fileName.setBounds(12, 10, 338, 15);
		}
		return fileName;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(12, 31, 389, 15);
		}
		return progressBar;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC9C4\uD589\uB960");
			status.setBounds(337, 49, 68, 15);
		}
		return status;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("X");
			btnNewButton.setBounds(362, 10, 43, 15);
		}
		return btnNewButton;
	}
}
