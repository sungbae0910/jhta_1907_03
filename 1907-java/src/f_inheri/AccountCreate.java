package f_inheri;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AccountCreate extends JPanel {
	private JLabel label;
	private JLabel lblNewLabel;
	private JTextField ano;
	private JLabel lblNewLabel_1;
	private JTextField irum;
	private JLabel lblNewLabel_2;
	private JTextField amount;
	private JButton btnNewButton;
	private JLabel status;

	/**
	 * Create the panel.
	 */
	public AccountCreate() {
		setLayout(null);
		add(getLabel());
		add(getLblNewLabel());
		add(getAno());
		add(getLblNewLabel_1());
		add(getIrum());
		add(getLblNewLabel_2());
		add(getAmount());
		add(getBtnNewButton());
		add(getStatus());

	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uACC4\uC88C\uC0DD\uC131");
			label.setFont(new Font("돋움체", Font.PLAIN, 20));
			label.setBounds(12, 10, 86, 24);
		}
		return label;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC88C\uBC88\uD638");
			lblNewLabel.setBounds(12, 53, 57, 15);
		}
		return lblNewLabel;
	}

	private JTextField getAno() {
		if (ano == null) {
			ano = new JTextField();
			ano.setBounds(66, 50, 116, 21);
			ano.setColumns(10);
		}
		return ano;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC608\uAE08\uC8FC");
			lblNewLabel_1.setBounds(12, 84, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JTextField getIrum() {
		if (irum == null) {
			irum = new JTextField();
			irum.setBounds(66, 81, 116, 21);
			irum.setColumns(10);
		}
		return irum;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uCD08\uAE30\uAE08\uC561");
			lblNewLabel_2.setBounds(12, 116, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getAmount() {
		if (amount == null) {
			amount = new JTextField();
			amount.setBounds(66, 113, 116, 21);
			amount.setColumns(10);
		}
		return amount;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC0DD\uC131 \uC644\uB8CC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 모든 항목이 입력되었는지 확인
					if (!ano.getText().equals("") && !irum.getText().equals("") && !amount.getText().equals("")) {
						// 예금액 항목에 숫자를 입력했는지 확인
						try {
							// 계좌번호 중복체크
							for (int i = 0; i < Bank.count; i++) {
								Acnt ac = Bank.ac[i];
								if (ac.getAno().equals(ano.getText())) {
									throw new IOException("계좌 중복");
								}
							}
							Long amt = Long.parseLong(amount.getText());
							Acnt ac = new Acnt(irum.getText(), ano.getText(), amt);
							Bank.ac[Bank.count] = ac;
							Bank.count++;
							status.setText(Bank.count + "번 째 고객이 등록되었습니다.");
							irum.setText("");
							amount.setText("");
							ano.selectAll();

						} catch (IOException ex) {
							status.setText(ex.getMessage());
							ano.requestFocus();
							ano.selectAll();
						} catch (Exception e2) {
							status.setText("예금액은 숫자만 입력해주세요!!");
							amount.requestFocus();
							amount.selectAll();
						}
					} else {
						status.setText("입력항목을 확인하세요");
						ano.requestFocus();
					}
				}
			});
			btnNewButton.setBounds(66, 154, 116, 23);
		}
		return btnNewButton;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setOpaque(true);
			status.setBackground(Color.CYAN);
			status.setBounds(12, 251, 255, 61);
		}
		return status;
	}
}
