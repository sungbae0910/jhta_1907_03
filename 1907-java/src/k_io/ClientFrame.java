package k_io;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.Socket;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientFrame extends JFrame implements Runnable{

	Socket socket;
	HTMLEditorKit kit = new HTMLEditorKit();
	HTMLDocument doc = new HTMLDocument();
	ClientThread ct;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField server;
	private JLabel lblNewLabel_1;
	private JTextField port;
	private JLabel lblNewLabel_2;
	private JTextField tmId;
	private JLabel lblNewLabel_3;
	private JTextField tPw;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
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
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
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
			
			if(socket.isConnected()) {
				login();
			}
		} catch (Exception e) {
		}
	}
	
	public void login() throws Exception{
		String mid = tmId.getText();
		String pwd = tPw.getText(); 
		String msg = "¿ì¾û";
		int cmd = ChattData.LOGIN;
		
		ChattData cd = new ChattData(mid, cmd, msg);
		ct.oos.writeObject(cd);
		ct.oos.flush();
	}
	
	public void send() {
		try {
			String mid = tmId.getText();
			String msg = message.getText();
			int cmd = ChattData.MESSAGE;
			ChattData cd = new ChattData(mid, cmd, msg);
			
			if(socket.isConnected()) {
				ct.oos.writeObject(cd);
				ct.oos.flush();
			}
		} catch (Exception e) {
			
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
	private JTextField getTmId() {
		if (tmId == null) {
			tmId = new JTextField();
			tmId.setText("Lee");
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC5F0\uACB0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(ClientFrame.this);
					t.start();
				}
			});
			btnNewButton.setBounds(316, 6, 65, 44);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Exit");
			btnNewButton_1.setBounds(386, 6, 58, 44);
		}
		return btnNewButton_1;
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
	private JList getList() {
		if (list == null) {
			list = new JList();
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
			comboBox.addItem("ÀüÃ¼¸Þ½ÃÁö");
			comboBox.addItem("±Ó¼Ó¸»");
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
				}
			});
			btnNewButton_3.setBounds(379, 293, 65, 23);
		}
		return btnNewButton_3;
	}
}
