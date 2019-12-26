package zzzzz;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StringExam extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField jumin;
	private JButton btnNewButton;
	private TextArea sta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringExam frame = new StringExam();
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
	public StringExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getJumin());
		contentPane.add(getBtnNewButton());
		contentPane.add(getSta());
	}

	public void checkJumin(){
		String msg = "";
		int leng = jumin.getText().length();
		msg += "문자열의 길이 : "+ leng + "\n";
		String birth = jumin.getText().substring(0, 6);
		msg+= "생년월일 : "+birth+"\n";
		char sex = jumin.getText().charAt(7);
		String aa = "";
		
		if(sex%2==0) {
			aa = "여자";
		}else {
			aa="남자";
		}
		msg += "성별 : "+aa;
		
		sta.setText(msg);
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			lblNewLabel.setBounds(40, 61, 59, 34);
		}
		return lblNewLabel;
	}
	private JTextField getJumin() {
		if (jumin == null) {
			jumin = new JTextField();
			jumin.setBounds(101, 65, 239, 27);
			jumin.setColumns(10);
		}
		return jumin;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uD655\uC778");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkJumin();
				}
			});
			btnNewButton.setBounds(352, 67, 97, 23);
		}
		return btnNewButton;
	}
	private TextArea getSta() {
		if (sta == null) {
			sta = new TextArea();
			sta.setBounds(40, 110, 405, 155);
		}
		return sta;
	}
}
