package f_inheri;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Withdraw extends JPanel {
	private JLabel lblNewLabel;
	private JTextField ano;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField irum;
	private JLabel lblNewLabel_2;
	private JTextField wAmt;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JTextField amount;
	private int num;
	private JLabel errorme;

	/**
	 * Create the panel.
	 */
	public Withdraw() {
		setLayout(null);
		add(getLblNewLabel());
		add(getAno());
		add(getBtnNewButton());
		add(getLblNewLabel_1());
		add(getLabel());
		add(getIrum());
		add(getLblNewLabel_2());
		add(getWAmt());
		add(getBtnNewButton_1());
		add(getLblNewLabel_3());
		add(getAmount());
		add(getErrorme());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uCD9C\uAE08");
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
					String find = ano.getText();
					DecimalFormat df = new DecimalFormat("##,###,###,###.##");
					for (int i = 0; i < Bank.count; i++) {
						Acnt ac = Bank.ac[i];
						if (ac.getAno().equals(find)) {
							irum.setText(ac.getIrum());
							amount.setText(df.format(ac.getAmount()));
							num = i;
							break;
						} else {
							errorme.setText("계좌가 없습니다.");
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
			lblNewLabel_2 = new JLabel("\uCD9C\uAE08\uC561");
			lblNewLabel_2.setBounds(152, 132, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getWAmt() {
		if (wAmt == null) {
			wAmt = new JTextField();
			wAmt.setBounds(213, 129, 116, 21);
			wAmt.setColumns(10);
		}
		return wAmt;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uCD9C\uAE08\uC644\uB8CC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!ano.getText().equals("")) {
						try {
							long amt = Long.parseLong(wAmt.getText());
							if (num >= 0) {
								Acnt ac = Bank.ac[num];
								long temp = ac.getAmount() - amt;
								if (temp >= 0) {
									ac.setAmount(temp);
								} else {
									errorme.setText("출금액이 예금액보다 많습니다.");
								}
							}
						} catch (Exception e2) {
							errorme.setText("예금액에 문자나 공백이 있습니다!!");
							amount.requestFocus();
						}
					}
				}
			});
			btnNewButton_1.setBounds(213, 160, 116, 23);
		}
		return btnNewButton_1;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uB0A8\uC740\uAE08\uC561");
			lblNewLabel_3.setBounds(152, 98, 57, 15);
		}
		return lblNewLabel_3;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setEditable(false);
			amount.setBounds(213, 98, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}

	private JLabel getErrorme() {
		if (errorme == null) {
			errorme = new JLabel("");
			errorme.setBackground(Color.CYAN);
			errorme.setOpaque(true);
			errorme.setHorizontalAlignment(SwingConstants.CENTER);
			errorme.setBounds(48, 205, 333, 97);
		}
		return errorme;
	}
}
