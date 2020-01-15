package z_exam;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PropertyEx extends JFrame {

	String fileName = "PropertyEx.properties";
	
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea txtrleeohzzzz;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyEx frame = new PropertyEx();
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
	public PropertyEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getScrollPane());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] data = txtrleeohzzzz.getText().split("\n");
					Properties prop = new Properties();
					try {
						FileWriter fw = new FileWriter(fileName);
						for(String temp : data) {
							String[] d = temp.split("=");
							String key = new String(d[0].getBytes(), "utf-8");
							String value = new String(d[1].getBytes(), "utf-8");
							prop.setProperty(key, value);
						}
						prop.store(fw, "property test");
						fw.flush();
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(81, 24, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC77D\uAE30");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Properties prop = new Properties();
					txtrleeohzzzz.setText("");
					try {
						FileReader fr = new FileReader(fileName); //문자 스트림을 읽어들임
						prop.load(fr);
						Set set = prop.keySet();
						for(Object o : set) {
							String key = (String)o;
							String value = (String)prop.get(key);
							
							
							txtrleeohzzzz.append(key + "=" + value + "\n");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
			btnNewButton_1.setBounds(224, 24, 97, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 63, 410, 189);
			scrollPane.setViewportView(getTxtrleeohzzzz());
		}
		return scrollPane;
	}
	private JTextArea getTxtrleeohzzzz() {
		if (txtrleeohzzzz == null) {
			txtrleeohzzzz = new JTextArea();
			txtrleeohzzzz.setText("1=lee\r\n2=oh\r\n3=zzzz\r\n4=\uC774\uC131\uBC30");
		}
		return txtrleeohzzzz;
	}
}