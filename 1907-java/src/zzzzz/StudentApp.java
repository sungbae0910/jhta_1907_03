package zzzzz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StudentApp extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel status;
	private JMenuItem mntmNewMenuItem_3;
	JPanel panel;
	static Student[] std = new Student[100];
	static int cnt;

	static {
		Student a = new Student(10, "lee", 60);
		std[0] = a;

		a = new Student(13, "oh", 80);
		std[1] = a;

		a = new Student(25, "shin", 30);
		std[2] = a;

		a = new Student(2, "kim", 70);
		std[3] = a;

		a = new Student(16, "park", 100);
		std[4] = a;

		cnt = 5;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentApp frame = new StudentApp();
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
	public StudentApp() {
		setTitle("\uC131\uC801\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 383);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		contentPane.add(getStatus(),BorderLayout.SOUTH);
		
		panel = new Main();
		contentPane.add(panel,BorderLayout.CENTER);
	}

	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("Home");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (panel != null) {
						contentPane.remove(panel);
					}
					panel = new Main();
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("오오!!");
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}

	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uC131\uC801\uAD00\uB9AC");
			mnNewMenu.add(getMntmNewMenuItem_3());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}

	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC131\uC801\uC785\uB825");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel != null) {
						contentPane.remove(panel);
					}
					panel = new ScoreInput(status);
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("성적을 입력해주세요.");
				}
			});
		}
		return mntmNewMenuItem;
	}

	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uD559\uBC88\uC21C");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel != null) {
						contentPane.remove(panel);
					}
					panel = new SortBySno();
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("학번순으로 정렬되었습니다.");
				}
			});
		}
		return mntmNewMenuItem_1;
	}

	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC131\uC801\uC21C");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(panel != null) {
						contentPane.remove(panel);
					}
					panel = new SortByScore();
					contentPane.add(panel);
					contentPane.updateUI();
					status.setText("성적순으로 정렬되었습니다.");
				}
			});
		}
		return mntmNewMenuItem_2;
	}

	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("\uC624\uC624!!");
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBackground(Color.CYAN);
			status.setOpaque(true);
			status.setForeground(Color.BLACK);
			status.setFont(new Font("돋움체", Font.PLAIN, 15));
			status.setBounds(12, 283, 527, 31);
		}
		return status;
	}

}
