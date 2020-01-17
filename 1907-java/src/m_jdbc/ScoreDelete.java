package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ScoreDelete extends JInternalFrame {
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel oh;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreDelete frame = new ScoreDelete();
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
	public ScoreDelete() {
		super("delete", false, true, true, true);
		setBounds(100, 100, 391, 395);
		getContentPane().setLayout(null);
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getOh());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTextField_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getTextField_3());
		getContentPane().add(getTextField_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getTextField_5());
		getContentPane().add(getBtnNewButton_2());
		setVisible(true);
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(74, 28, 185, 30);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao dao = new ScoreDao();
					int se = Integer.parseInt(textField.getText());
					ScoreVo sv = dao.search(se);
					if(sv == null) {
					} else {
					textField_1.setText(sv.getId());
					textField_5.setText(sv.getmName());
					textField_2.setText(sdf.format(sv.getRd()));
					textField_3.setText(sv.getSub());
					textField_4.setText(sv.getSc()+"");
					}
				}
			});
			btnNewButton.setBounds(266, 28, 97, 30);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao dao = new ScoreDao();
					int se = Integer.parseInt(textField.getText());
					
					int cnt = dao.delete(se);
					if(cnt>0) {
						oh.setText("삭제가 완료되었습니다.");
					}else {
						oh.setText("삭제 실패!!");
					}
					
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
				}
			});
			btnNewButton_1.setBounds(12, 239, 351, 50);
		}
		return btnNewButton_1;
	}
	private JLabel getOh() {
		if (oh == null) {
			oh = new JLabel("New label");
			oh.setBackground(Color.LIGHT_GRAY);
			oh.setOpaque(true);
			oh.setHorizontalAlignment(SwingConstants.CENTER);
			oh.setBounds(12, 299, 351, 57);
		}
		return oh;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(27, 71, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC751\uC2DC\uC77C");
			lblNewLabel_2.setBounds(27, 138, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uACFC\uBAA9");
			lblNewLabel_3.setBounds(27, 174, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC810\uC218");
			lblNewLabel_4.setBounds(27, 211, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(119, 68, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(119, 135, 116, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(119, 171, 116, 21);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(119, 208, 116, 21);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC751\uC2DC\uBC88\uD638");
			lblNewLabel_5.setBounds(12, 35, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uC774\uB984");
			lblNewLabel_6.setBounds(27, 101, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(119, 99, 116, 21);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC870\uD68C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(266, 31, 97, 23);
		}
		return btnNewButton_2;
	}
}
