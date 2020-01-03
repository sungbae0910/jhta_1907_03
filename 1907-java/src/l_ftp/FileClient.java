package l_ftp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileClient extends JFrame {

	
	List<FileTransfer> files;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JTextField tIp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileClient frame = new FileClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileClient() {
		setTitle("\uD30C\uC77C\uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		
		try {
			InetAddress addr = InetAddress.getLocalHost();
			getTIp().setText(addr.getHostAddress());
		} catch (Exception e) {
		}
	}
	
	public void fileChooser() {
		JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		int flag = fc.showOpenDialog(FileClient.this);
		
		if(flag == JFileChooser.APPROVE_OPTION) {
			File[] tempFiles = fc.getSelectedFiles();
			files = new ArrayList<FileTransfer>();
			for(File f : tempFiles) {
				FileTransfer ft = new FileTransfer(f.getPath()); // 파일명을 넘겨주기위해 
				files.add(ft);
				panel_1.add(ft);
				panel_1.updateUI();
			}
		}
	}

	public void send() {
		//전송할 파일의 목록과 파일의 크기를 Data에 담아서 서버전달
		Data data = new Data();
		ObjectInputStream ois = null;
		Socket socket = null;
		for(FileTransfer ft : files) {
			File f = new File(ft.getFileName().getText());
			
			data.fileName.add(f.getName());
			data.fileSize.add(ft.fileSize);
		}
		try {
			socket = new Socket(tIp.getText(), 5555);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(data);
			oos.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
				
		//서버가 전달한 port번호를 사용하여 서버에 추가접속함
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			for(FileTransfer ft : files) {
				Data temp = (Data)ois.readObject();
				ft.ip = getTIp().getText();
				ft.port = temp.port;
				Thread t = new Thread(ft);
				t.join();
				t.start();
			}
		} catch (Exception e) {
		}
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getTIp());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD30C\uC77C\uC120\uD0DD");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fileChooser();
				}
			});
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC804\uC1A1");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
				}
			});
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(420, 2));
			scrollPane.setViewportView(getPanel_1());
		}
		return scrollPane;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(430, 10));
		}
		return panel_1;
	}
	private JTextField getTIp() {
		if (tIp == null) {
			tIp = new JTextField();
			tIp.setColumns(10);
		}
		return tIp;
	}
}
