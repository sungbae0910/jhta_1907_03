package j_collections;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class MemberMain extends JFrame {
	List<MemberVo> ls = new ArrayList<MemberVo>(); //기본 사이즈 10개
	Map<String, List<ScoreVo>> map = new HashMap<String, List<ScoreVo>>(); //key하나의 값에 여러개의 list를 구현하기 위해 생성 
	Set<ProductVo> ils = new HashSet<ProductVo>(); //입고리스트
	Set<ProductVo> pls = new HashSet<ProductVo>(); //출고리스트
	static int iSerial = 1; //입고시리얼
	static int eSerial = 1; //출고시리얼
	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItem;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenuItem mntmNewMenuItem_13;

	/**
	 * Launch the application.
	 */
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
		setTitle("\uD68C\uC6D0\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 575);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ArrayList sampleData 입력
		for(int i=0; i<500; i++) {
			MemberVo mv = new MemberVo("no"+i,"pwd"+i,"name"+i,"111-111"+i);
			ls.add(mv);
		}
		
		//성적관리 sample
		ScoreVo svo = new ScoreVo("1","lee","중간",1,90,80,95);
		List<ScoreVo> list1 = new ArrayList<ScoreVo>();
		list1.add(svo);
		list1.add(new ScoreVo("1","lee","기말",1,80,95,83));
		list1.add(new ScoreVo("1","lee","기말",2,100,95,85));
		map.put("1", list1);
		
		list1 = new ArrayList<ScoreVo>();
		list1.add(new ScoreVo("2","kim","중간",3,80,95,80));
		list1.add(new ScoreVo("2","kim","기말",3,90,90,90));
		map.put("2", list1);
		
		list1 = new ArrayList<ScoreVo>();
		list1.add(new ScoreVo("3","park","중간",2,100,95,80));
		list1.add(new ScoreVo("3","park","중간",3,90,100,90));
		list1.add(new ScoreVo("3","park","기말",3,90,90,100));
		map.put("3", list1);

		
		//HashSet sampleData입력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<100; i++) {
			String tempSerial = sdf.format(new Date())+"-"+MemberMain.iSerial;
			ProductVo pv = new ProductVo(tempSerial, "pCode"+i, "pName"+i, 3000, new Date());
			ils.add(pv); // 입고 값 입력
			pls.add(pv); // 출고 값 입력
			MemberMain.iSerial++;
			MemberMain.eSerial++;
		}
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu.add(getMenuItem());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu;
	}
	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("\uC785\uB825");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MemberInput mi = new MemberInput(ls);
					contentPane.add(mi);
					mi.toFront();
				}
			});
		}
		return menuItem;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberSearch ms = new MemberSearch(ls);
					contentPane.add(ms);
					ms.toFront();
				}
			});
		}
		return mntmNewMenuItem;
	}
	
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uC218\uC815/\uC0AD\uC81C");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberModify mm = new MemberModify(ls);
					contentPane.add(mm);
					mm.toFront();
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uC790\uC7AC\uAD00\uB9AC");
			mnNewMenu_1.add(getMntmNewMenuItem_2());
			mnNewMenu_1.add(getMntmNewMenuItem_3());
			mnNewMenu_1.add(getMntmNewMenuItem_4());
			mnNewMenu_1.add(getMntmNewMenuItem_5());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC785\uACE0");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ProductInput pi = new ProductInput(ils);
					contentPane.add(pi);
					pi.toFront();
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uCD9C\uACE0");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductOutput po = new ProductOutput(pls);
					contentPane.add(po);
					po.toFront();
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductSearch ps = new ProductSearch(ils, pls);
					contentPane.add(ps);
					ps.toFront();
				}
			});
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uC218\uC815|\uC0AD\uC81C");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductModify pm = new ProductModify(ils, pls);
					contentPane.add(pm);
					pm.toFront();
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uC131\uC801\uC870\uD68C");
			mnNewMenu_2.add(getMntmNewMenuItem_6());
			mnNewMenu_2.add(getMntmNewMenuItem_7());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("\uC785\uB825");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreInput si = new ScoreInput(map, MemberMain.this);
					contentPane.add(si);
					si.toFront();
				}
			});
		}
		return mntmNewMenuItem_6;
	}
	private JMenuItem getMntmNewMenuItem_7() {
		if (mntmNewMenuItem_7 == null) {
			mntmNewMenuItem_7 = new JMenuItem("\uC870\uD68C");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreSearch ss = new ScoreSearch(map);
					contentPane.add(ss);
					ss.toFront();
				}
			});
		}
		return mntmNewMenuItem_7;
	}
	private JMenu getMnNewMenu_3() {
		if (mnNewMenu_3 == null) {
			mnNewMenu_3 = new JMenu("\uAE30\uD0C0\uCEEC\uB809\uC158");
			mnNewMenu_3.add(getMntmNewMenuItem_8());
			mnNewMenu_3.add(getMntmNewMenuItem_9());
			mnNewMenu_3.add(getMntmNewMenuItem_13());
			mnNewMenu_3.add(getMntmNewMenuItem_10());
			mnNewMenu_3.add(getMntmNewMenuItem_11());
		}
		return mnNewMenu_3;
	}
	private JMenuItem getMntmNewMenuItem_8() {
		if (mntmNewMenuItem_8 == null) {
			mntmNewMenuItem_8 = new JMenuItem("Properties");
			mntmNewMenuItem_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Property pt = new Property();
					contentPane.add(pt);
					pt.toFront();
				}
			});
		}
		return mntmNewMenuItem_8;
	}
	private JMenuItem getMntmNewMenuItem_9() {
		if (mntmNewMenuItem_9 == null) {
			mntmNewMenuItem_9 = new JMenuItem("TreeSet");
			mntmNewMenuItem_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeSetFrame tf = new TreeSetFrame();
					contentPane.add(tf);
					tf.toFront();
				}
			});
		}
		return mntmNewMenuItem_9;
	}
	private JMenuItem getMntmNewMenuItem_10() {
		if (mntmNewMenuItem_10 == null) {
			mntmNewMenuItem_10 = new JMenuItem("Stack");
			mntmNewMenuItem_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StackFrame sf = new StackFrame();
					contentPane.add(sf);
					sf.toFront();
				}
			});
		}
		return mntmNewMenuItem_10;
	}
	private JMenuItem getMntmNewMenuItem_11() {
		if (mntmNewMenuItem_11 == null) {
			mntmNewMenuItem_11 = new JMenuItem("Queue");
			mntmNewMenuItem_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QueueFrame qf = new QueueFrame();
					contentPane.add(qf);
					qf.toFront();
				}
			});
		}
		return mntmNewMenuItem_11;
	}
	private JMenuItem getMntmNewMenuItem_13() {
		if (mntmNewMenuItem_13 == null) {
			mntmNewMenuItem_13 = new JMenuItem("TreeMap");
			mntmNewMenuItem_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeMapFrame tmf = new TreeMapFrame();
					contentPane.add(tmf);
					tmf.toFront();
				}
			});
		}
		return mntmNewMenuItem_13;
	}
}
