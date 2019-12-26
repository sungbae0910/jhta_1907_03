package j_collections;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreSearch extends JInternalFrame {
	DefaultListModel<String> modelSno = new DefaultListModel<String>();
	DefaultListModel<String> modelExam = new DefaultListModel<String>();
	Map<String, List<ScoreVo>> map;
	List<ScoreVo> lv;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JList listSno;
	private JScrollPane scrollPane_1;
	private JList listExam;
	private InputPanel panel;
	private JTextField se;
	JButton btnFind;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSearch frame = new ScoreSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScoreSearch() {
		super("조회", false, true, true, true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getScrollPane_1_1());
		getContentPane().add(getPanel_1());
		getContentPane().add(getSe());
		getContentPane().add(getBtnFind());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		setVisible(true);
		setBounds(100, 100, 632, 558);

	}
	
	public ScoreSearch(Map<String, List<ScoreVo>> map) {
		this();
		this.map=map;
		
		//학번추출 JList에 표시
		Set<String> key = map.keySet();
		//JList에 추가
		Iterator<String> iter = key.iterator();
		while(iter.hasNext()) {
			modelSno.addElement(iter.next());
		}
		
		listSno.setModel(modelSno);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC131\uC801 \uC218\uC815/\uC0AD\uC81C");
			lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
			lblNewLabel.setBounds(12, 10, 163, 41);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(39, 53, 119, 387);
			scrollPane.setViewportView(getListSno());
		}
		return scrollPane;
	}
	private JList getListSno() {
		if (listSno == null) {
			listSno = new JList();
			listSno.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent ev) {
					String sno = (String)listSno.getSelectedValue();
					if(sno==null) return;
					lv = map.get(sno);
					modelExam = new DefaultListModel<>();
					for(int i=0; i<lv.size(); i++) {
						ScoreVo vo = lv.get(i);
						String temp = String.format("%s : %d (%s)", vo.getmName(), vo.getGrade(), vo.getExam());
						modelExam.addElement(temp);
					}
					listExam.setModel(modelExam);
				}
			});
		}
		return listSno;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(182, 53, 140, 387);
			scrollPane_1.setViewportView(getListExam());
		}
		return scrollPane_1;
	}
	private JList getListExam() {
		if (listExam == null) {
			listExam = new JList();
			listExam.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int index = listExam.getSelectedIndex();
					int grade = -1;
					if(index<0) {
						return;
					}
					
					ScoreVo vo = lv.get(index);
					panel.tSno.setText(vo.getSno());
					panel.tmName.setText(vo.getmName());
					panel.tKor.setText(Integer.toString(vo.getKor()));
					panel.tEng.setText(Integer.toString(vo.getEng()));
					panel.tMat.setText(Integer.toString(vo.getMat()));
					panel.tTot.setText(Integer.toString(vo.getTot()));
					panel.tAvg.setText(String.format("%4.1f", vo.getAvg()));
					
					//시험종류 선택
					if(vo.getExam().equals("중간")) {
						panel.r1.setSelected(true);
					}else {
						panel.r2.setSelected(true);
					}
					
					//학년선택
					grade = vo.getGrade()-1;
					panel.cGrade.setSelectedIndex(grade);
				}
			});
		}
		return listExam;
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new InputPanel();
			panel.setBounds(351, 53, 217, 387);
		}
		return panel;
	}
	private JTextField getSe() {
		if (se == null) {
			se = new JTextField();
			se.setBounds(351, 24, 135, 21);
			se.setColumns(10);
		}
		return se;
	}
	private JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("\uAC80\uC0C9");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String findStr = se.getText(); //검색어 저장
					ScoreDao dao = new ScoreDao(map); 
					Map<String, List<ScoreVo>> newMap = dao.list(findStr);
					
					Set<String> set = newMap.keySet();
					modelSno = new DefaultListModel<String>(); //model.clear 
					Iterator<String> iter = set.iterator();
					while(iter.hasNext()) {
						modelSno.addElement(iter.next());
					}
					
					listSno.setModel(modelSno);
					modelExam.clear();
					
					panel.tSno.setText("");
					panel.tmName.setText("");
					panel.tKor.setText("");
					panel.tEng.setText("");
					panel.tMat.setText("");
					panel.tTot.setText("");
					panel.tAvg.setText("");
				}
			});
			btnFind.setBounds(498, 23, 70, 23);
		}
		return btnFind;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
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
					
					ScoreVo sv = new ScoreVo(key,mName,exam,grade,kor,eng,mat);
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.update(key, index, sv);
					if(b) {
						status.setText("수정완료!!");
					}else {
						status.setText("오류발생!!");
					}
					
				}
			});
			btnNewButton_1.setBackground(Color.WHITE);
			btnNewButton_1.setBounds(351, 450, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = panel.tSno.getText();
					int index = listExam.getSelectedIndex();
					
					ScoreDao dao = new ScoreDao(map);
					boolean b = dao.delete(key, index);
					
					if(b) {
						status.setText("삭제완료!!");
						panel.tSno.setText("");
						panel.tmName.setText("");
						panel.tKor.setText("");
						panel.tEng.setText("");
						panel.tMat.setText("");
						panel.tTot.setText("");
						panel.tAvg.setText("");
						if(modelExam.size()>0) {
							modelExam.remove(index);
						}
					}else {
						status.setText("오류발생");
					}
					
					
				}
			});
			btnNewButton_2.setBounds(471, 450, 97, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC54C\uB9BC\uCC3D");
			status.setBounds(39, 483, 529, 34);
		}
		return status;
	}
}
