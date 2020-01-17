package m_jdbc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MemberUpdate extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel label;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JLabel oh;
	private JComboBox comboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUpdate frame = new MemberUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MemberUpdate() {
		super("update", false, true, true, true);
		setBounds(100, 100, 304, 397);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTextField());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTextField_1());
		getContentPane().add(getLabel());
		getContentPane().add(getTextField_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getOh());
		getContentPane().add(getComboBox());
		setVisible(true);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC815\uBCF4 \uC218\uC815");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 264, 35);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
			lblNewLabel_1.setBounds(12, 55, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(53, 52, 116, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					String find = textField.getText();
					MemberVo mv = dao.uSelect(find);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					textField_1.setText(mv.getmName());
					textField_2.setText(sdf.format(mv.getrDate()));
					comboBox.setSelectedIndex(mv.getGrade()-1);
				}
			});
			btnNewButton.setBounds(179, 51, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setBounds(12, 96, 35, 15);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(53, 93, 116, 21);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC785\uD559\uC77C");
			label.setBounds(12, 142, 46, 15);
		}
		return label;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(53, 139, 116, 21);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD559\uB144");
			lblNewLabel_3.setBounds(12, 188, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					int gra = comboBox.getSelectedIndex()+1;
					Date dt = null;
					
					try {
						dt = sdf.parse(textField_2.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					MemberVo mv = new MemberVo(textField.getText(), textField_1.getText(), dt, gra);
					
					int d = dao.update(mv);
					if(d>0) {
						oh.setText("수정 완료!!!");
					}else {
						oh.setText("수정 실패ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");
					}
					 
				}
			});
			btnNewButton_1.setBounds(12, 233, 264, 35);
		}
		return btnNewButton_1;
	}
	private JLabel getOh() {
		if (oh == null) {
			oh = new JLabel("New label");
			oh.setHorizontalAlignment(SwingConstants.CENTER);
			oh.setBackground(Color.LIGHT_GRAY);
			oh.setOpaque(true);
			oh.setBounds(12, 278, 264, 58);
		}
		return oh;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			comboBox.setBounds(56, 185, 113, 18);
		}
		return comboBox;
	}
}
