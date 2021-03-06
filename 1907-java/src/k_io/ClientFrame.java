package k_io;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class ClientFrame extends JFrame implements Runnable{

	Socket socket;
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	ClientThread ct;
	DefaultListModel<String> model = new DefaultListModel<String>(); //JList를 활용하기 위해 선언
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField server;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JLabel lblNewLabel_2;
	private JTextField tmId;
	private JLabel lblNewLabel_3;
	private JTextField tPw;
	public JButton conA;
	public JButton exB;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_2;
	private JComboBox comboBox;
	private JTextField message;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setTitle("\uCC44\uD305\uD074\uB77C\uC774\uC5B8\uD2B8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getServer());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPort());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTmId());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTPw());
		contentPane.add(getConA());
		contentPane.add(getExB());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getComboBox());
		contentPane.add(getMessage());
		contentPane.add(getBtnNewButton_3());
		
	}
	
	@Override
	public void run() {
		try {
			String id = server.getText();
			int pt = Integer.parseInt(port.getText());
			socket = new Socket(id, pt);
			ct = new ClientThread(ClientFrame.this, socket);
			ct.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login() throws Exception{
		String mid = tmId.getText();
		String pwd = tPw.getText(); 
		String msg = "우엉";
		int cmd = ChattData.LOGIN;
		
		ChattData cd = new ChattData(mid, cmd, msg);
		ct.oos.writeObject(cd);
		ct.oos.flush();
	}
	
	// 서버에게 로그아웃 통보
	// 자신의 유저목록을 모두 제거
	// clientThread를 종료
	public void logout() {
		ChattData cd = new ChattData();
		cd.setmId(tmId.getText());
		cd.setCommand(ChattData.LOGOUT);
		try {
			ct.oos.writeObject(cd);
			ct.oos.flush();
			model.clear(); // 자신의 JList목록들 제거
			ct.stop(); // clientThread 종료
			socket.close();
			socket = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send() {
		try {
			String mid = tmId.getText();
			String msg = message.getText();
			int cmd = ChattData.MESSAGE;
			ChattData cd = new ChattData(mid, cmd, msg);
			
			 
			if(comboBox.getSelectedIndex()==1) { // 귓속말
				Object[] obj = getList().getSelectedValues();
				List<String> users = new ArrayList<String>();
				for(Object str :  obj) {
					users.add((String)str);
				}
				cd.setUsers(users);
				cd.setCommand(ChattData.WHISPER);
			}
			
			if(socket.isConnected()) {
				ct.oos.writeObject(cd);
				ct.oos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC11C\uBC84");
			lblNewLabel.setBounds(12, 10, 33, 15);
		}
		return lblNewLabel;
	}
	private JTextField getServer() {
		if (server == null) {
			server = new JTextField();
			server.setBounds(43, 7, 121, 21);
			server.setColumns(10);
			
			try {
				InetAddress ia = InetAddress.getLocalHost();
				server.setText(ia.getHostAddress());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return server;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Port");
			lblNewLabel_1.setBounds(176, 10, 33, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getPort() {
		if (port == null) {
			port = new JTextField();
			port.setText("4444");
			port.setBounds(204, 7, 86, 21);
			port.setColumns(10);
		}
		return port;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("ID");
			lblNewLabel_2.setBounds(12, 35, 18, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setText("\u314B");
			tmId.setBounds(43, 35, 121, 21);
			tmId.setColumns(10);
		}
		return tmId;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("PW");
			lblNewLabel_3.setBounds(176, 35, 23, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getTPw() {
		if (tPw == null) {
			tPw = new JTextField();
			tPw.setText("123456");
			tPw.setBounds(203, 35, 87, 21);
			tPw.setColumns(10);
		}
		return tPw;
	}
	private JButton getConA() {
		if (conA == null) {
			conA = new JButton("\uC5F0\uACB0");
			conA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(ClientFrame.this);
					t.start();
					conA.setEnabled(false);
					exB.setEnabled(true);
				}
			});
			conA.setBounds(316, 6, 65, 44);
		}
		return conA;
	}
	private JButton getExB() {
		if (exB == null) {
			exB = new JButton("Exit");
			exB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logout();
					conA.setEnabled(false);
					exB.setEnabled(false);
				}
			});
			exB.setBounds(386, 6, 58, 44);
		}
		return exB;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 82, 133, 173);
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_4());
		}
		return scrollPane;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			list.setModel(model);
		}
		return list;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC811\uC18D\uC790");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_4;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_1.setBounds(154, 82, 290, 173);
			scrollPane_1.setViewportView(getTextPane());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_5());
		}
		return scrollPane_1;
		
	}
	public JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setContentType("text/html");
			
			textPane.setEditorKit(kit);
			textPane.setDocument(doc);
		}
		return textPane;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Message");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_5;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uD574\uC81C");
			btnNewButton_2.setBounds(12, 265, 130, 23);
		}
		return btnNewButton_2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(12, 294, 130, 21);
			comboBox.addItem("전체메시지");
			comboBox.addItem("귓속말");
		}
		return comboBox;
	}
	private JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						send();
						message.setText("");
					}
				}
			});
			message.setBounds(155, 294, 219, 21);
			message.setColumns(10);
		}
		return message;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC804\uC1A1");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					send();
					message.setText("");
				}
			});
			btnNewButton_3.setBounds(379, 293, 65, 23);
		}
		return btnNewButton_3;
	}
}
