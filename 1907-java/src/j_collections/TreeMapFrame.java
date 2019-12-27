package j_collections;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class TreeMapFrame extends JInternalFrame {
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	TreeMap<Integer, String> tm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeMapFrame frame = new TreeMapFrame();
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
	public TreeMapFrame() {
		super("TreeMap", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());

	}
	
	public void process() {
		tm = new TreeMap<Integer, String>();
		tm.put(87, "이성배");
		tm.put(90, "우엉");
		tm.put(80, "후엉");
		tm.put(75, "구엉");
		tm.put(79, "프엉");
		textArea.setText("");
		
		Map.Entry<Integer, String> entry = null;
		
		entry = tm.firstEntry();
		textArea.append("최소값 : " + entry.getKey() + " " + entry.getValue() + "\n");
		
		entry = tm.lastEntry();
		textArea.append("최소값 : " + entry.getKey() + " " + entry.getValue() + "\n");
		
		entry = tm.lowerEntry(95);
		textArea.append("95점 아래 점수 : " + entry.getKey() + " " + entry.getValue() + "\n");
		
		entry = tm.higherEntry(80);
		textArea.append("80점 위의 점수 : " + entry.getKey() + " " + entry.getValue() + "\n");
		
	}
	
	public void asc() {
		if( tm != null){
			textArea.setText("");
			NavigableMap<Integer, String> map = tm.descendingMap().descendingMap();
			Set<Map.Entry<Integer, String>> en = map.entrySet();
			
			for(Map.Entry<Integer, String> tey : en) {
				textArea.append(tey.getKey()+ " " + tey.getValue() + "\n");
			}
		}else {
			textArea.setText("실행버튼먼저 눌러주세요!!!");
		}
	}
	
	public void desc() {
		if( tm!=null) {
			textArea.setText("");
			NavigableMap<Integer, String> map = tm.descendingMap();
			Set<Map.Entry<Integer, String>> en = map.entrySet();
			for(Map.Entry<Integer, String> tey : en) {
				textArea.append(tey.getKey() + " " + tey.getValue() + "\n");
			}
		}else {
			textArea.setText("실행버튼을 먼저 눌러주세요");
		}
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2E4\uD589");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					process();
				}
			});
			btnNewButton.setBounds(35, 10, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("ASC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					asc();
				}
			});
			btnNewButton_1.setBounds(167, 10, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("DESC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					desc();
				}
			});
			btnNewButton_2.setBounds(299, 10, 97, 23);
		}
		return btnNewButton_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 57, 410, 204);
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
