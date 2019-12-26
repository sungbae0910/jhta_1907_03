package h_api;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PatternExam2 extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField id;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JTextField email;
	private JTextField zip;
	private JButton btnNewButton;
	private JLabel notice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternExam2 frame = new PatternExam2();
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
	public PatternExam2() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getId());
		contentPane.add(getPwd());
		contentPane.add(getMName());
		contentPane.add(getPhone());
		contentPane.add(getEmail());
		contentPane.add(getZip());
		contentPane.add(getBtnNewButton());
		contentPane.add(getNotice());
	}
	
	public void check(){
		String regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String regId = "[a-zA-Z]+\\d+[$,!,_]+{4,10}"; //오류
		String regPwd = "[a-zA-Z]+\\d+[$,!,_]+{4,10}"; //오류
		String regphone = "\\d{2,3}-\\d{3,4}-\\d{4}";
		String mN = "[가-힣]{2,20}";
		String post = "\\d{2}-\\d{3}";
		notice.setText("");
		
		if(!Pattern.matches(regExp, email.getText())) {
			notice.setText("e메일을 확인해주세요!!");
			email.requestFocus();
			email.selectAll();
		}
			
		if(!Pattern.matches(regId, id.getText())) {
			notice.setText("아이디를 확인해주세요!!");
			id.requestFocus();
			id.selectAll();
		}
		
		if(!Pattern.matches(mN, mName.getText())) {
			notice.setText("성명을 확인해주세요!!");
			mName.requestFocus();
			mName.selectAll();
		}
		
		if(!Pattern.matches(regPwd, pwd.getText())) {
			notice.setText("비밀번호를 확인해주세요!!");
			pwd.requestFocus();
			pwd.selectAll();
		}
		
		if(!Pattern.matches(regphone, phone.getText())) {
			notice.setText("전화번호를 확인해주세요!!");
			phone.requestFocus();
			phone.selectAll();
		}
		
		if(!Pattern.matches(post, zip.getText())) {
			notice.setText("우편번호를 확인해주세요!!");
			zip.requestFocus();
			zip.selectAll();
		}
		
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC544\uC774\uB514");
			label.setBounds(12, 52, 57, 15);
		}
		return label;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC554\uD638");
			lblNewLabel.setBounds(12, 77, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC131\uBA85");
			lblNewLabel_1.setBounds(12, 102, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC5F0\uB77D\uCC98");
			lblNewLabel_2.setBounds(12, 127, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC774\uBA54\uC77C");
			lblNewLabel_3.setBounds(12, 152, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
			lblNewLabel_4.setBounds(12, 177, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(81, 49, 166, 21);
			id.setColumns(10);
		}
		return id;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(81, 74, 166, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(81, 99, 166, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(81, 124, 166, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(81, 149, 166, 21);
			email.setColumns(10);
		}
		return email;
	}
	private JTextField getZip() {
		if (zip == null) {
			zip = new JTextField();
			zip.setBounds(81, 174, 166, 21);
			zip.setColumns(10);
		}
		return zip;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCCB4\uD06C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnNewButton.setBounds(112, 205, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getNotice() {
		if (notice == null) {
			notice = new JLabel("");
			notice.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			notice.setOpaque(true);
			notice.setBackground(Color.CYAN);
			notice.setHorizontalAlignment(SwingConstants.CENTER);
			notice.setForeground(Color.BLACK);
			notice.setBounds(12, 249, 324, 100);
		}
		return notice;
	}
}
