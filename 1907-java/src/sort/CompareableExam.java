package sort;
/*
 * 1. ��������
	- �Էµ� ���ڿ��� ������ �迭�� Split, for�� ������ ��Ʈ������ ����ȯ
	- �������� ���� textArea ���
2. ���� ����
	- �Էµ� ���ڿ��� ���ڷ� split
	- �������� ����
3. ��ü ����
	- �Էµ� ���ڿ��� ���ڷ� split�Ͽ� ScoreŬ������ kor �ʵ忡 ����
	- Score Ŭ������ Comparable�� ������
	- kor������ ���ĵ� ����� textArea�� ���
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CompareableExam extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField val;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompareableExam frame = new CompareableExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void sortNum() {
		String[] aa = val.getText().split(",");
		int[] bb = new int[aa.length];
		for(int i=0; i<aa.length; i++) {
			bb[i] = Integer.parseInt(aa[i]);
		}
		Arrays.sort(bb);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<bb.length; i++) {
			String str = String.format("[%d] = %s\n", i, bb[i]);
			sb.append(str);
		}
		
		
		//bubble ����
		boolean sort = true;
		int lastIndex = bb.length-1;
		
		while(sort) {
			sort=false;
			for(int i=0; i<lastIndex; i++) {
				if(bb[i]<bb[i+1]) {
					int t = bb[i];
					bb[i] = bb[i+1];
					bb[i+1] = t;
					sort = true;
				}
			}
			lastIndex--;
		}
		
		sb.append("-----------------------------\n");
		for(int i=0; i<bb.length; i++) {
			String str = String.format("[%d] = %s\n", i, bb[i]);
			sb.append(str);
		}
		
		//�������� �Ǿ� �ִ� ���� reverse�ؼ� ������������ ������
		Collections.reverse(Arrays.asList(bb));
		
		
		textArea.setText(sb.toString());
	}
	
	public void sortCh() {
		String msg = "";
		String ss = "";
		String[] a=val.getText().split(",");
		for(int i=0; i<a.length; i++) {
			ss += a[i];
		}
		char[] c = ss.toCharArray();
		
		Arrays.sort(c);
		//�迭 ���������� �̾Ƴ� ��������
		for(int i=c.length-1; i>=0; i--) {
			msg+=c[i]+"\n";
		}
		textArea.setText(msg);
		
		//�ڹ� API�̿��Ͽ� �������� ����
		Arrays.sort(a,Collections.reverseOrder());
		
	}
	
	public void sortObj() {
		String msg = "";
		String[] a=val.getText().split(",");
		Score[] s = new Score[a.length];
		int[] ab = new int[a.length];
		Score sc = new Score();
		
		//int������ �� ��ȯ�ѵڿ� Score��ü�� �����ϴ°� �ƴ� String���� �ϴ� ���� �� class�ȿ��� intó��
		for(int i=0; i<a.length; i++) {
			sc = new Score(a[i]);
			s[i] = sc;
		}
		//��������
		Arrays.sort(s);
		/*
		 * ��Ʈ�� ������ reverse�Ͽ� ������ �ڹٲ�
		 * Collections.reverse(Arrays.asList(sArray));
		 */
		for(int i=0; i<s.length; i++) {
			msg+=s[i].kor+"\n";
		}
		textArea.setText(msg);
	}

	/**
	 * Create the frame.
	 */
	public CompareableExam() {
		setTitle("CompareableExam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 80));
			panel.setLayout(null);
			panel.add(getVal());
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
		}
		return panel;
	}
	private JTextField getVal() {
		if (val == null) {
			val = new JTextField();
			val.setBounds(12, 10, 400, 23);
			val.setColumns(10);
		}
		return val;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC22B\uC790\uC815\uB82C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sortNum();
				}
			});
			btnNewButton.setBounds(22, 43, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uBB38\uC790\uC815\uB82C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sortCh();
				}
			});
			btnNewButton_1.setBounds(165, 43, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC1D\uCCB4\uC815\uB82C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sortObj();
				}
			});
			btnNewButton_2.setBounds(315, 43, 97, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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
}
