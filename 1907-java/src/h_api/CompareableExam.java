package h_api;
/*
 * 1. 숫자정렬
	- 입력된 문자열을 정수형 배열로 Split, for문 돌려서 인트형으로 형변환
	- 오름차순 정렬 textArea 출력
2. 문자 정렬
	- 입력된 문자열을 문자로 split
	- 내림차순 정렬
3. 객체 정렬
	- 입력된 문자열을 숫자로 split하여 Score클래스의 kor 필드에 대입
	- Score 클래스는 Comparable을 구현함
	- kor순으로 정렬된 결과를 textArea에 출력
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
					String msg = "";
					String[] a=val.getText().split(",");
					
					int[] ab = new int[a.length];
					for(int i=0; i<a.length; i++) {
						ab[i] = Integer.parseInt(a[i]);
					}
					Arrays.sort(ab);
					for(int i =0; i<ab.length; i++) {
						msg+=ab[i]+"\n";
					}
					textArea.setText(msg);
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
					String msg = "";
					String ss = "";
					String[] a=val.getText().split(",");
					for(int i=0; i<a.length; i++) {
						ss += a[i];
					}
					char[] c = ss.toCharArray();
					
					Arrays.sort(c);
					//배열끝에서부터 뽑아내 내림차순 정렬
					for(int i=c.length-1; i>=0; i--) {
						msg+=c[i]+"\n";
					}
					textArea.setText(msg);
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
					String msg = "";
					String[] a=val.getText().split(",");
					Score[] s = new Score[a.length];
					int[] ab = new int[a.length];
					Score sc = new Score();
					
					for(int i=0; i<a.length; i++) {
						ab[i]=Integer.parseInt(a[i]);
						sc = new Score(ab[i]);
						s[i] = sc;
					}
					Arrays.sort(s);
					for(int i=0; i<s.length; i++) {
						msg+=s[i].kor+"\n";
					}
					textArea.setText(msg);
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
