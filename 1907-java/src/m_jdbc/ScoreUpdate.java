package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ScoreUpdate extends JInternalFrame {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel oh;
	private JLabel lblNewLabel_7;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreUpdate frame = new ScoreUpdate();
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
	public ScoreUpdate() {
		super("update", false, true, true, true);
		setBounds(100, 100, 393, 424);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getTextField_3());
		getContentPane().add(getTextField_4());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getOh());
		getContentPane().add(getLblNewLabel_7());
		getContentPane().add(getTextField_5());
		setVisible(true);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC218\uC815");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 353, 39);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC751\uC2DC\uBC88\uD638");
			lblNewLabel_1.setBounds(22, 59, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setBounds(22, 95, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC751\uC2DC\uC77C\uC790");
			lblNewLabel_3.setBounds(22, 160, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC751\uC2DC\uACFC\uBAA9");
			lblNewLabel_4.setBounds(22, 191, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC131\uC801");
			lblNewLabel_5.setBounds(22, 219, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(116, 56, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(116, 92, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(116, 157, 116, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(116, 188, 116, 21);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(116, 216, 116, 21);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao dao = new ScoreDao();
					int serial = Integer.parseInt(textField.getText());
					ScoreVo sv = dao.search(serial);
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
			btnNewButton.setBounds(242, 55, 110, 33);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao dao = new ScoreDao();
					Date date = null;
					try {
						date = sdf.parse(textField_2.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					int aaa = Integer.parseInt(textField_4.getText());
					int se = Integer.parseInt(textField.getText());
					ScoreVo sv = new ScoreVo(se, textField_1.getText(), textField_5.getText(), date , textField_3.getText(), aaa);
					
					int re = dao.update(sv);
					if(re>0) {
						oh.setText("정상적으로 수정되었습니다.");
					}else {
						oh.setText("수정 실패!!");
					}
				}
			});
			btnNewButton_1.setBounds(12, 258, 353, 54);
		}
		return btnNewButton_1;
	}
	private JLabel getOh() {
		if (oh == null) {
			oh = new JLabel("New label");
			oh.setBackground(Color.LIGHT_GRAY);
			oh.setOpaque(true);
			oh.setHorizontalAlignment(SwingConstants.CENTER);
			oh.setBounds(12, 322, 353, 63);
		}
		return oh;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("\uC774\uB984");
			lblNewLabel_7.setBounds(22, 126, 57, 15);
		}
		return lblNewLabel_7;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(116, 123, 116, 21);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
}
