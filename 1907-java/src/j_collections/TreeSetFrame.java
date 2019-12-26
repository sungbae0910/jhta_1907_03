package j_collections;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class TreeSetFrame extends JInternalFrame {
	private JTextField tf;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeSetFrame frame = new TreeSetFrame();
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
	public TreeSetFrame() {
		super("TreeSet", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 491, 372);
		getContentPane().setLayout(null);
		getContentPane().add(getTf());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());

	}
	
	public void process() {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		StringTokenizer stk = new StringTokenizer(tf.getText(), ",");
		
		textArea.setText("");
		//hasMoreElements와 hasMoreTokens 동일한 결과 나옴 
		while(stk.hasMoreElements()) {
			//textArea.append(stk.nextToken()+"\n");
			scores.add(Integer.parseInt(stk.nextToken()));
		}
		
		textArea.append("가장 작은 값 : " + scores.first()+"\n");
		textArea.append("가장 큰 값 : " + scores.last()+"\n");
		textArea.append("60 이하 : " + scores.lower(60)+"\n");
		textArea.append("90이상 : " + scores.higher(90)+"\n");
		
		textArea.append("100이거나 100점 바로 밑 : " + scores.floor(100)+"\n");
		textArea.append("50이거나 50바로 위 : " + scores.ceiling(50)+"\n");
		
		while(!scores.isEmpty()) {
			textArea.append(scores.pollFirst() + "남은 객체 수 : " + scores.size() + "\n");
		}
	}
	
	public void Desc() { //내림차순
		TreeSet<Integer> scores = new TreeSet<Integer>();
		StringTokenizer stk = new StringTokenizer(tf.getText() , ",");
		
		while(stk.hasMoreTokens()) {
			scores.add(Integer.parseInt(stk.nextToken()));
		}
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		textArea.append(descendingSet+"");
	}
	
	public void Asc() { //오름차순
		TreeSet<Integer> scores = new TreeSet<Integer>();
		StringTokenizer stk = new StringTokenizer(tf.getText(), ",");
		
		while(stk.hasMoreTokens()) {
			scores.add(Integer.parseInt(stk.nextToken()));
		}
		
		NavigableSet<Integer> desc = scores.descendingSet().descendingSet();
		textArea.setText(desc+"");
	}
	

	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setText("51,2,5,9,8,6,547,9,,321,65,8,48,91");
			tf.setBounds(12, 21, 343, 21);
			tf.setColumns(10);
		}
		return tf;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E4\uD589");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					process();
				}
			});
			btnNewButton.setBounds(366, 20, 97, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 98, 451, 220);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("DESC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Desc();
				}
			});
			btnNewButton_1.setBounds(258, 52, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("ASC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Asc();
				}
			});
			btnNewButton_2.setBounds(366, 52, 97, 23);
		}
		return btnNewButton_2;
	}
}
