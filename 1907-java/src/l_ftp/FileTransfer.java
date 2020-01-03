package l_ftp;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class FileTransfer extends JPanel implements Runnable{
	long fileSize;
	int port; //파일 전송을 위한 port
	String ip;
	private JLabel fileName;
	private JProgressBar progressBar;
	private JLabel status;
	private JButton btnNewButton;

	public FileTransfer() {
		setPreferredSize(new Dimension(418, 67));
		setLayout(null);
		add(getFileName());
		add(getProgressBar());
		add(getStatus());
		add(getBtnNewButton());
	}
	
	public FileTransfer(String file) {
		this();
		getFileName().setText(file);
		File f = new File(file);
		fileSize = f.length()/1000;
		status.setText("0/"+fileSize+"kb");
	}
	
	@Override
	public void run() {
		// 지정된 파일을 FileInputStream으로 읽어서 Socket의 DataOutputStream으로 전송
		byte[] readData = new byte[4096];
		int readSize = 0;
		long readTotSize=0;
		getProgressBar().setValue(0);
		try {
			Socket socket = new Socket(ip, port);
			OutputStream os = socket.getOutputStream();
			FileInputStream fis = new FileInputStream(getFileName().getText());
			while((readSize=fis.read(readData)) != -1){
				readTotSize += readSize;
				getStatus().setText(readTotSize+"/"+fileSize);
				getProgressBar().setValue((int)((double)readTotSize/fileSize*100));
				getProgressBar().setStringPainted(true);
				os.write(readData, 0, readSize);
			}
			os.flush();
			os.close();
		} catch (Exception e) {
		}
	}
	
	public JLabel getFileName() {
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
