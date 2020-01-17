package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ScoreInsert extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JLabel oh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInsert frame = new ScoreInsert();
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
	public ScoreInsert() {
		super("insert", false, true, true, true);
		setBounds(100, 100, 349, 426);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getTextField_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getTextField_3());
		getContentPane().add(getTextField_4());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getOh());
		setVisible(true);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 309, 33);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_2.setBounds(22, 56, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC751\uC2DC\uC77C\uC790");
			lblNewLabel_3.setBounds(22, 102, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("\uC751\uC2DC\uACFC\uBAA9");
			lblNewLabel_4.setBounds(22, 147, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uC810\uC218");
			lblNewLabel_5.setBounds(22, 195, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(127, 53, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(127, 99, 116, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(127, 147, 116, 21);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(127, 192, 116, 21);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao sd = new ScoreDao();
					ScoreVo sv = new ScoreVo();
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						
						sv.setId(textField_1.getText());
						sv.setRd(sdf.parse(textField_2.getText()));
						sv.setSub(textField_3.getText());
						sv.setSc(Integer.parseInt(textField_4.getText()));
						
						int cnt=sd.insert(sv);
						if(cnt>0) {
							oh.setText("정보입력완료");
						}else {
							oh.setText("정보입력실패");
						}
						
						textField_1.requestFocus();
						textField_1.selectAll();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			});
			btnNewButton.setBounds(69, 252, 209, 55);
		}
		return btnNewButton;
	}
	private JLabel getOh() {
		if (oh == null) {
			oh = new JLabel("New label");
			oh.setBackground(Color.LIGHT_GRAY);
			oh.setOpaque(true);
			oh.setHorizontalAlignment(SwingConstants.CENTER);
			oh.setBounds(12, 317, 314, 55);
		}
		return oh;
	}
}
