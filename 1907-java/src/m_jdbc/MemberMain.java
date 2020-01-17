package m_jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class MemberMain extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain frame = new MemberMain();
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
	public MemberMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 464);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD559\uC0DD \uAD00\uB9AC");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
			mnNewMenu.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC815\uBCF4\uC785\uB825");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberInsert mi = new MemberInsert();
					contentPane.add(mi);
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC815\uBCF4\uC870\uD68C");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberSelect ms = new MemberSelect();
					contentPane.add(ms);
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC815\uBCF4\uC218\uC815");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberUpdate mu = new MemberUpdate();
					contentPane.add(mu);
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC815\uBCF4\uC0AD\uC81C");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDelete md = new MemberDelete();
					contentPane.add(md);
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("query");
			mnNewMenu_1.add(getMntmNewMenuItem_4());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("sql");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Query qq = new Query();
					contentPane.add(qq);
				}
			});
		}
		return mntmNewMenuItem_4;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uC131\uC801\uAD00\uB9AC");
			mnNewMenu_2.add(getMntmNewMenuItem_5());
			mnNewMenu_2.add(getMntmNewMenuItem_6());
			mnNewMenu_2.add(getMntmNewMenuItem_7());
			mnNewMenu_2.add(getMntmNewMenuItem_8());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uC131\uC801\uC785\uB825");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreInsert si = new ScoreInsert();
					contentPane.add(si);
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("\uC131\uC801\uC870\uD68C");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreSelect ss = new ScoreSelect();
					contentPane.add(ss);
				}
			});
		}
		return mntmNewMenuItem_6;
	}
	private JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("\uC131\uC801\uC218\uC815");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreUpdate su = new ScoreUpdate();
					contentPane.add(su);
				}
			});
		}
		return mntmNewMenuItem_7;
	}
	private JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("\uC131\uC801\uC0AD\uC81C");
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDelete sd = new ScoreDelete();
					contentPane.add(sd);
				}
			});
		}
		return mntmNewMenuItem_8;
	}
}