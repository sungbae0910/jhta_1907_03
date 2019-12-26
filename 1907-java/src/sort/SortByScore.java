package sort;

import java.awt.Font;
import java.awt.TextArea;
import java.util.Objects;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortByScore extends JPanel {
	private JLabel lblNewLabel;
	private TextArea textArea;

	/**
	 * Create the panel.
	 */
	public SortByScore() {
		setLayout(null);
		add(getLblNewLabel());
		add(getTextArea());
		scoreList();

	}
	
	public void scoreList() {
		Student[] s = StudentApp.std;
		Student temp = null;
		for(int i=0; i<StudentApp.cnt-1; i++) {
			for(int j=i+1; j<StudentApp.cnt; j++) {
				int result = Objects.compare(s[i], s[j], new StudentCompareator(2));
				if(result<0) {
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
		String dh = "";
		for(int i=0; i<StudentApp.cnt; i++) {
			Student a = StudentApp.std[i];
			dh += a.score;
			dh += "\t"+a.name;
			dh += "\t"+a.sno+"\n";
		}
		textArea.setText(dh);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC21C");
			lblNewLabel.setFont(new Font("µ¸¿òÃ¼", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 10, 90, 30);
		}
		return lblNewLabel;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
			textArea.setBounds(23, 61, 391, 170);
		}
		return textArea;
	}
}
