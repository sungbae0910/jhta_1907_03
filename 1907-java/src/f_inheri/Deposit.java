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

public class Deposit extends JPanel {
	private JLabel lblNewLabel;
	private JTextField ano;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField irum;
	private JLabel lblNewLabel_2;
	private JTextField amount;
	private JButton btnNewButton_1;
	private int num;
	private JLabel errorme;

	/**
	 * Create the panel.
	 */
	public Deposit() {
		setLayout(null);
		add(getLblNewLabel());
		add(getAno());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getIrum());
		add(getLblNewLabel_2());
		add(getAmount());
		add(getBtnNewButton_1());
		add(getErrorme());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC785\uAE08");
			lblNewLabel.setFont(new Font("돋움체", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 10, 59, 24);
		}
		return lblNewLabel;
	}

	private JTextField getAno() {
		if (ano == null) {
			ano = new JTextField();
			ano.setBounds(213, 45, 116, 21);
			ano.setColumns(10);
		}
		return ano;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a = ano.getText();
					num = -1;
					for (int i = 0; i < Bank.count; i++) {
						Acnt ac = Bank.ac[i];
						if (ac.getAno().equals(a)) {
							irum.setText(ac.getIrum());
							num = i;
							break;
						} else {
							errorme.setText("계좌정보가 없습니다.");
						}
					}

				}
			});
			btnNewButton.setBounds(341, 44, 97, 23);
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel_1.setBounds(152, 48, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC608\uAE08\uC8FC");
			label.setBounds(152, 73, 57, 15);
		}
		return label;
	}

	private JTextField getIrum() {
		if (irum == null) {
			irum = new JTextField();
			irum.setEditable(false);
			irum.setBounds(213, 70, 116, 21);
			irum.setColumns(10);
		}
		return irum;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC608\uAE08\uC561");
			lblNewLabel_2.setBounds(152, 101, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(213, 98, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC608\uAE08\uC644\uB8CC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!ano.getText().equals("")) {
						try {
							Long amt = Long.parseLong(amount.getText());
							if (num >= 0) {
								Acnt a = Bank.ac[num];
								long temp = a.getAmount() + amt;
								a.setAmount(temp);
							}
						} catch (Exception e2) {
							errorme.setText("예금액에 문자나 공백이 있습니다!!");
							amount.requestFocus();
						}
					}
				}
			});
			btnNewButton_1.setBounds(213, 129, 116, 23);
		}
		return btnNewButton_1;
	}

	private JLabel getErrorme() {
		if (errorme == null) {
			errorme = new JLabel("");
			errorme.setOpaque(true);
			errorme.setHorizontalAlignment(SwingConstants.CENTER);
			errorme.setBackground(Color.CYAN);
			errorme.setBounds(12, 190, 349, 99);
		}
		return errorme;
	}
}
