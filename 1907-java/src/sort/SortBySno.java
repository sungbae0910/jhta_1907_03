package sort;

import java.awt.Font;
import java.awt.TextArea;
import java.util.Objects;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortBySno extends JPanel {
	private JLabel lblNewLabel;
	private TextArea sno;

	/**
	 * Create the panel.
	 */
	public SortBySno() {
		setLayout(null);
		add(getLblNewLabel());
		add(getSno());
		snoList();

	}
	
	public void snoList() {
		Student[] s = StudentApp.std;
		Student temp = null;
		
		for(int i=0; i<StudentApp.cnt-1; i++) {
			for(int j=i+1; j<StudentApp.cnt; j++ ) {
				int result = Objects.compare(s[i], s[j], new StudentCompareator(1));
				if(result>0) {
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
		String str = "";
		for(int i=0; i<StudentApp.cnt; i++) {
			Student a = StudentApp.std[i];
			str += a.sno;
			str += "\t"+a.name;
			str += "\t"+a.score + "\n";
		}
		sno.setText(str);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD559\uBC88\uC21C");
			lblNewLabel.setFont(new Font("µ¸¿òÃ¼", Font.PLAIN, 15));
			lblNewLabel.setBounds(12, 10, 69, 28);
		}
		return lblNewLabel;
	}
	private TextArea getSno() {
		if (sno == null) {
			sno = new TextArea();
			sno.setBounds(21, 90, 440, 170);
		}
		return sno;
	}
}
