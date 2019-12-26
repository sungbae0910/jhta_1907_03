package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AccountModify extends JPanel {
	private JLabel lblNewLabel;
	private JTextField ano;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField irum;
	private JLabel lblNewLabel_2;
	private JTextField amount;
	private JButton btnNewButton_1;
	private int num;
	private JLabel errorme;

	/**
	 * Create the panel.
	 */
	public AccountModify() {
		setLayout(null);
		add(getLblNewLabel());
		add(getAno());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getIrum());
		add(getLblNewLabel_2());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getErrorme());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC88C\uC218\uC815");
			lblNewLabel.setFont(new Font("돋움체", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 10, 94, 24);
		}
		return lblNewLabel;
	}

	private JTextField getAno() {
		if (ano == null) {
			ano = new JTextField();
			ano.setBounds(196, 54, 138, 21);
			ano.setColumns(10);
		}
		return ano;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = ano.getText();
					num = -1;
					for (int i = 0; i < Bank.count; i++) {
						Acnt a = Bank.ac[i];
						if (a.getAno().equals(find)) {
							irum.setText(a.getIrum());
							amount.setText(a.getAmount() + "");
							num = i;
							break;
						}
					}
				}
			});
			btnNewButton.setBounds(336, 53, 80, 23);
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setBounds(12, 98, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getIrum() {
		if (irum == null) {
			irum = new JTextField();
			irum.setBounds(64, 95, 116, 21);
			irum.setColumns(10);
		}
		return irum;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_2.setBounds(12, 138, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(64, 135, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815\uD655\uC778");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!irum.getText().equals("") && !amount.getText().equals("")) {
						try {
							if (num >= 0) {
								Acnt a = Bank.ac[num];
								Long amt = Long.parseLong(amount.getText());
								a.setIrum(irum.getText());
								a.setAmount(amt);
							}
						} catch (Exception e2) {
							errorme.setText("예금액은 숫자만 입력해주세요!!");
							amount.requestFocus();
						}
					} else {
						errorme.setText("예금주나 예금액이 공백");
					}
				}
			});
			btnNewButton_1.setBounds(64, 166, 116, 23);
		}
		return btnNewButton_1;
	}

	private JLabel getErrorme() {
		if (errorme == null) {
			errorme = new JLabel("New label");
			errorme.setHorizontalAlignment(SwingConstants.CENTER);
			errorme.setOpaque(true);
			errorme.setBackground(Color.CYAN);
			errorme.setBounds(32, 234, 334, 83);
		}
		return errorme;
	}
}
