package f_inheri;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AccountList extends JPanel {
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public AccountList() {
		setLayout(null);
		add(getLblNewLabel());
		add(getScrollPane());
		showList();
	}
	public void showList(){
		String str = "";
		DecimalFormat df = new DecimalFormat("##,###,###,###.#");
		
		
		for(int i = 0; i<Bank.count; i++) {
			Acnt a = Bank.ac[i];
			str += a.getIrum();
			str += "\t"+a.getAno();
			str += "\t"+df.format(a.getAmount());
			str += "\n";
		}
		textArea.setText(str); //setText초기 설정 | .append기존것을 초기화 하지 않고 추가하려고 할 때
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uACC4\uC88C\uBAA9\uB85D");
			lblNewLabel.setFont(new Font("돋움체", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 10, 80, 24);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 44, 404, 246);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uACC4\uC88C\uBC88\uD638                        \uACC4\uC88C\uC8FC                     \uACC4\uC88C\uBC88\uD638\r\n");
		}
		return lblNewLabel_1;
	}
}
