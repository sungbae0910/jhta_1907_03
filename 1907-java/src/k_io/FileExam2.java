package k_io;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileExam2 extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileExam2 frame = new FileExam2();
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
	public FileExam2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 504);
		setJMenuBar(getMenuBar_1());
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("\uD30C\uC77C\uBCF5\uC0AC");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileCopy panel = new FileCopy();
					contentPane.add(panel);
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("\uD30C\uC77C\uD3B8\uC9D1");
			mnNewMenu_1.add(getMntmNewMenuItem_3());
			mnNewMenu_1.add(getMntmNewMenuItem_1());
			mnNewMenu_1.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("\uBD88\uB7EC\uC624\uAE30");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int flag = fc.showOpenDialog(FileExam2.this);
					if(flag == JFileChooser.APPROVE_OPTION) {
						String fileName = fc.getSelectedFile().getPath();
						TextEditor panel = new TextEditor(fileName);
						contentPane.add(panel);
						panel.toFront();
					}
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("\uC800\uC7A5\uD558\uAE30");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//현재 선택되어 있는 창의 정보를 가져옴
					JInternalFrame jif = contentPane.getSelectedFrame();
					if(jif instanceof TextEditor) { //넘겨받은 창이 TextEditor일경우 TextEditor로 캐스팅한 후 save메소드 실행
						TextEditor te = (TextEditor)jif;
						
						//새로 만들기한 경우에 TextEditor의 fileName이 null
						if(te.fileName == null) {
							JFileChooser fc = new JFileChooser();
							int flag = fc.showSaveDialog(FileExam2.this);
							if(flag == JFileChooser.APPROVE_OPTION) {
								te.fileName = fc.getSelectedFile().getPath();
								te.setTitle(te.fileName);
							}else {
								te.getStatus().setText("파일저장취소");
								return;
							}
						}
						
						boolean b = te.save();
						if(b) {
							te.getStatus().setText("파일저장완료");
						}else {
							te.getStatus().setText("오류발생");
						}
					}
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	private JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("\uC0C8\uB85C \uB9CC\uB4E4\uAE30");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TextEditor te = new TextEditor();
					contentPane.add(te);
					te.toFront();
				}
			});
		}
		return mntmNewMenuItem_3;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
			mnNewMenu_2.add(getMntmNewMenuItem_4());
			mnNewMenu_2.add(getMntmNewMenuItem_5());
			mnNewMenu_2.add(getMntmNewMenuItem_6());
		}
		return mnNewMenu_2;
	}
	private JMenuItem getMntmNewMenuItem_4() {
		if (mntmNewMenuItem_4 == null) {
			mntmNewMenuItem_4 = new JMenuItem("\uD68C\uC6D0\uC785\uB825");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberInput mi = new MemberInput();
					contentPane.add(mi);
					mi.toFront();
				}
			});
		}
		return mntmNewMenuItem_4;
	}
	private JMenuItem getMntmNewMenuItem_5() {
		if (mntmNewMenuItem_5 == null) {
			mntmNewMenuItem_5 = new JMenuItem("\uD68C\uC6D0\uC870\uD68C");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberSearch ms = new MemberSearch();
					contentPane.add(ms);
					ms.toFront();
				}
			});
		}
		return mntmNewMenuItem_5;
	}
	private JMenuItem getMntmNewMenuItem_6() {
		if (mntmNewMenuItem_6 == null) {
			mntmNewMenuItem_6 = new JMenuItem("\uC218\uC815/\uC0AD\uC81C");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberModify mm = new MemberModify();
					contentPane.add(mm);
					mm.toFront();
				}
			});
		}
		return mntmNewMenuItem_6;
	}
}
