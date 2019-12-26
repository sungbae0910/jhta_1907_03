package j_collections;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreInput extends JInternalFrame {
	Map<String, List<ScoreVo>> map;
	private JLabel lblNewLabel;
	private InputPanel panel;
	private JButton btnNewButton;
	private JLabel status;
	MemberMain mm;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput frame = new ScoreInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public ScoreInput() {
		super("입력", false, true, true, true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getPanel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getStatus());
		setVisible(true);
		setBounds(100, 100, 306, 529);

	}
	
	public ScoreInput(Map<String, List<ScoreVo>> map, MemberMain mm) {
		this();
		this.map=map;
		this.mm=mm;
	}
	
	public void sync() {
		Object[] obj = mm.getContentPane().getComponents();
		for(int i=0; i<obj.length; i++) {
			if(obj[i] instanceof ScoreSearch) {
				ScoreSearch ss = (ScoreSearch)obj[i];
				ss.btnFind.doClick();
			}
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801\uC785\uB825");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			lblNewLabel.setBounds(22, 10, 110, 37);
		}
		return lblNewLabel;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new InputPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(32, 46, 213, 391);
		}
		return panel;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String sno = panel.tSno.getText();
					String mName = panel.tmName.getText();
					int kor = Integer.parseInt(panel.tKor.getText());
					int eng = Integer.parseInt(panel.tEng.getText());
					int mat = Integer.parseInt(panel.tMat.getText());
					String exam = "";
					int grade = 0;
					if(panel.r1.isSelected()) {
						exam="중간";
					}else {
						exam="기말";
					}
					grade = panel.cGrade.getSelectedIndex()+1;
					
					ScoreVo sv = new ScoreVo(sno,mName,exam,grade,kor,eng,mat);
					panel.tTot.setText(sv.getTot()+"");
					panel.tAvg.setText(String.format("%5.1f", sv.getAvg()));
					
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.insert(sv);
					if(b) {
						status.setText("저장완료!!");
						sync();
					}else {
						status.setText("저장 중 오류 발생");
					}
				}
			});
			btnNewButton.setBounds(130, 447, 97, 23);
		}
		return btnNewButton;
	}
	
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC54C\uB9BC\uCC3D");
			status.setBounds(30, 475, 248, 15);
		}
		return status;
	}
}