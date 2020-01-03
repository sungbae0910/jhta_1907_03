package l_ftp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FileServer extends JFrame implements Runnable{

	static int port = 6000; // 6000~50000번 
	List<FileTransferReceive> files = new ArrayList<FileTransferReceive>();
	boolean threadFlag = true;
	ServerSocket server;
	FileTransferReceive st;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileServer frame = new FileServer();
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
	public FileServer() {
		setTitle("\uD30C\uC77C\uC11C\uBC84");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 379);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.NORTH);
		contentPane.add(getScrollPane_1(), BorderLayout.CENTER);
	}
	
	@Override
	public void run() {
		threadFlag = true;
		
		try { 
			server = new ServerSocket(5555);
			textArea.append("서버가 시작됨 \n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(threadFlag) { //예외가 발생해도 계속 돌리기 위해 while문 안에 try~catch문을 작성함
			try {
				Socket s = server.accept();
				textArea.append("클라이언트가 접속됨\n");
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()); //output이 먼저 선언되어야하는 버그?가 있음
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Data data = (Data)ois.readObject();
				
				textArea.append("전송될 파일 정보 수신됨\n");
				
				for(int i=0; i<data.fileName.size(); i++) {
					FileServer.port++;
					if(FileServer.port>50000) {
						FileServer.port = 6000;
					}
					
					//socket, file, filesize를 넘겨줘야함
					st = new FileTransferReceive(FileServer.port, data.fileName.get(i), data.fileSize.get(i), panel); 
					files.add(st);
					panel.add(st);
					
					Data sendData = new Data();
					sendData.port  = FileServer.port;
					oos.writeObject(sendData);
					oos.flush();
				}
				panel.updateUI();
				ois.close();
				oos.close();
			} catch (Exception e) {
			}
		}
	}

	public void serverStop() {
		files.clear();
		files = new ArrayList<FileTransferReceive>();
		
		try {
			server.close();
			server=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Server");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC11C\uBC84\uC2DC\uC791");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(FileServer.this);
					t.start();
					
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC11C\uBC84\uC911\uC9C0");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					serverStop();
					textArea.setText("서버종료");
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uD504\uB85C\uADF8\uB7A8 \uC885\uB8CC");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(2, 120));
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC11C\uBC84\uC0C1\uD0DC");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setPreferredSize(new Dimension(10, 10));
			scrollPane_1.setViewportView(getPanel());
		}
		return scrollPane_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(420, 10));
		}
		return panel;
	}
}
