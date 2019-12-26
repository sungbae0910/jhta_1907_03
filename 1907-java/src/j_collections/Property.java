package j_collections;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Property extends JInternalFrame {
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Property frame = new Property();
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
	public Property() {
		super("Properties", false, true, true, true);
		setVisible(true);
		setTitle("Properties");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getTextArea());
	}
	
	public void check(){
		try {
			Properties properties = new Properties();
			String path = Property.class.getResource("database.properties").getPath();
			path = URLDecoder.decode(path,"uhf-8");
			properties.load(new FileReader(path));
			
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			textArea.append("driver : " + driver + "\n");
			textArea.append("url : " + url + "\n");
			textArea.append("username : " + username + "\n");
			textArea.append("password : " + password + "\n");
		} catch (Exception e) {
			textArea.setText("오류발생");
		}
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Check");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnNewButton.setBounds(167, 10, 97, 44);
		}
		return btnNewButton;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(12, 60, 410, 182);
		}
		return textArea;
	}
}
