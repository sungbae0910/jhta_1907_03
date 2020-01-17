package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MemberInsert extends JInternalFrame {
	private JLabel lblMember;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel oh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInsert frame = new MemberInsert();
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
	public MemberInsert() {
		super("Insert", false, true, true, true);
		setBounds(100, 100, 304, 397);
		getContentPane().setLayout(null);
		getContentPane().add(getLblMember());
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getTextField_2());
		getContentPane().add(getComboBox());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getOh());
		setVisible(true);

	}
	private JLabel getLblMember() {
		if (lblMember == null) {
			lblMember = new JLabel("\uC815\uBCF4 \uC785\uB825");
			lblMember.setHorizontalAlignment(SwingConstants.CENTER);
			lblMember.setBounds(23, 10, 222, 33);
		}
		return lblMember;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(89, 50, 156, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(89, 99, 156, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setText("2020-01-15");
			textField_2.setBounds(89, 149, 156, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1\uD559\uB144", "2\uD559\uB144", "3\uD559\uB144", "4\uD559\uB144", "5\uD559\uB144", "6\uD559\uB144", "7\uD559\uB144", "8\uD559\uB144", "9\uD559\uB144", "10\uD559\uB144"}));
			comboBox.setMaximumRowCount(10);
			comboBox.setBounds(89, 206, 156, 26);
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String id = textField.getText();
					String name = textField_1.getText();
					int gra = comboBox.getSelectedIndex()+1;
					Date dat = null;
					try {
						dat = sdf.parse(textField_2.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					MemberVo mv = new MemberVo(id, name, dat, gra);
					int re = dao.insert(mv);
					if(re>0) {
						oh.setText("정보가 입력되었습니다.");
					}else {
						oh.setText("정보입력 실패했습니다.");
					}
				}
			});
			btnNewButton.setBounds(67, 252, 148, 43);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(12, 53, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC774\uB984");
			lblNewLabel_1.setBounds(12, 102, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC785\uB825\uC2DC\uAC04");
			lblNewLabel_2.setBounds(12, 152, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD559\uB144");
			lblNewLabel_3.setBounds(12, 212, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getOh() {
		if (oh == null) {
			oh = new JLabel("New label");
			oh.setOpaque(true);
			oh.setForeground(Color.BLACK);
			oh.setBackground(Color.LIGHT_GRAY);
			oh.setHorizontalAlignment(SwingConstants.CENTER);
			oh.setBounds(12, 313, 264, 33);
		}
		return oh;
	}
}
