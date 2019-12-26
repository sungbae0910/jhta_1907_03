package h_api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class GetPropertyExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private TextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetPropertyExam frame = new GetPropertyExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GetPropertyExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	public void view() {
		String msg = "";
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");

		msg += "운영체제 이름 : " + osName + "\n";
		msg += "사용자 이름 : " + userName + "\n";
		msg += "사용자 홈디렉토리 : " + userHome + "\n";
		msg += "============================\n";
		msg += " [key] value \n";
		msg += "============================\n";
		Properties pp = System.getProperties();
		Set keys = pp.keySet();
		for (Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			msg += "[" + key + "]" + value + "\n";
		}

		textArea.setText(msg);
	}

	public void viewClass() {
		String a = "";
		Key k = new Key(3);
		Class c1 = k.getClass();

		a += c1.getName() + "\n";
		a += c1.getSimpleName() + "\n";
		a += c1.getPackage().getName() + "\n";

		try {
			Class c2 = Class.forName("h_api.Key");

			a += c2.getName() + "\n";
			a += c2.getSimpleName() + "\n";
			a += c2.getPackage().getName() + "\n";
		} catch (Exception e) {
			e.printStackTrace();
		}

		textArea.setText(a);
	}

	public void viewReflection() {
		String a = "";
		Class c1 = null;
		try {
			c1=Class.forName("h_api.Key");
		} catch (Exception e) {
		}
		
		a+= "[클래스 이름] \n";
		a+= c1.getName()+"\n";
		
		a+="[생성자 정보] \n";
		Constructor[] constructors = c1.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			a+=constructor.getName()+"(";
			Class[] parameters = constructor.getParameterTypes();
			a+=") \n";
		}
		
		a+="[필드 정보] \n";
		Field[] fields = c1.getDeclaredFields();
		for(Field field : fields) {
			a+=field.getType().getSimpleName()+" "+field.getName()+"\n";
		}
		
		a+="[메소드 정보] \n";
		Method[] methods = c1.getDeclaredMethods();
		for(Method method : methods) {
			a+=method.getName()+"(";
			Class[] parameters = method.getParameterTypes();
			a+=") \n";
		}

		textArea.setText(a);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC18D\uC131\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					view();
				}
			});
		}
		return btnNewButton;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
		}
		return textArea;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uD074\uB798\uC2A4");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewClass();
				}
			});
		}
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uB9AC\uD50C\uB809\uC158");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewReflection();
				}
			});
		}
		return btnNewButton_2;
	}
}
