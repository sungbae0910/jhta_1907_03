package sort;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreInput extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField snos;
	private JTextField namea;
	private JTextField score;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ScoreInput() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_2());
		add(getLblNewLabel_3());
		add(getSnos());
		add(getNamea());
		add(getScore());
		add(getBtnNewButton());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801 \uC785\uB825");
			lblNewLabel.setFont(new Font("µ¸¿òÃ¼", Font.PLAIN, 18));
			lblNewLabel.setBounds(12, 10, 97, 38);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uD559\uBC88");
			lblNewLabel_1.setBounds(52, 83, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC774\uB984");
			lblNewLabel_2.setBounds(52, 122, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC131\uC801");
			lblNewLabel_3.setBounds(52, 167, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getSnos() {
		if (snos == null) {
			snos = new JTextField();
			snos.setBounds(139, 80, 116, 21);
			snos.setColumns(10);
		}
		return snos;
	}
	private JTextField getNamea() {
		if (namea == null) {
			namea = new JTextField();
			namea.setBounds(139, 119, 116, 21);
			namea.setColumns(10);
		}
		return namea;
	}
	private JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setBounds(139, 164, 116, 21);
			score.setColumns(10);
		}
		return score;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC785\uB825\uC644\uB8CC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						int snol = Integer.parseInt(snos.getText());
						int scorel = Integer.parseInt(score.getText());
						Student input = new Student(snol, namea.getText(), scorel);
						StudentApp.std[StudentApp.cnt] = input;
						StudentApp.cnt++;
						snos.setText("");
						namea.setText("");
						score.setText("");
				}
			});
			btnNewButton.setBounds(296, 79, 116, 103);
		}
		return btnNewButton;
	}
}
