package z_exam;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MapEx extends JFrame {

	Map<String, String> map = new HashMap<String, String>();
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField kt;
	private JLabel lblNewLabel_1;
	private JTextField kv;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapEx frame = new MapEx();
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
	public MapEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getKt());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getKv());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getBtnNewButton_4());
		contentPane.add(getBtnNewButton_5());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnNewButton_6());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("KEY");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getKt() {
		if (kt == null) {
			kt = new JTextField();
			kt.setBounds(64, 7, 146, 21);
			kt.setColumns(10);
		}
		return kt;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("VALUE");
			lblNewLabel_1.setBounds(12, 41, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getKv() {
		if (kv == null) {
			kv = new JTextField();
			kv.setBounds(64, 38, 146, 21);
			kv.setColumns(10);
		}
		return kv;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Keys");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Set<String> st = map.keySet();
					Iterator<String> it = st.iterator();
					textArea.setText("");
					while(it.hasNext()) {
						String key = it.next();
						textArea.append("key : " + key + "\n");
					}
					
					Set<String> st2 = map.keySet();
					for(String v : st2) {
						textArea.append("Key : " + v);
					}
				
				}
			});
			btnNewButton.setBounds(280, 10, 71, 50);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Values");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Set<String> st = map.keySet();
					Iterator<String> it = st.iterator();
					textArea.setText("");
					while(it.hasNext()) {
						String key = it.next();
						String value = map.get(key);
						textArea.append("value : " + value  + "\n");
					}
					
					//  향상된 for문을 이용한 두 번째 방법
					Collection<String> values = map.values();
					for(String v : values) {
						textArea.append("value : " + v);
					}
				}
			});
			btnNewButton_1.setBounds(353, 10, 86, 50);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC785\uB825");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					map.put(kt.getText(), kv.getText());
					kt.setText("");
					kv.setText("");
				}
			});
			btnNewButton_2.setBounds(12, 78, 97, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("\uC218\uC815");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = kt.getText();
					String value = kv.getText();
					
					textArea.setText("");
						if(map.containsKey(key)) {
							map.put(key, value);
						}else {
							textArea.setText("수정할 값이 없습니다.");
						}
					}
			});
			btnNewButton_3.setBounds(121, 78, 97, 23);
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("\uC0AD\uC81C");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = kt.getText();
					if(map.containsKey(key)) {
						map.remove(key);
						kt.setText("");
						textArea.setText(key + "가 삭제 되었습니다.");
					}else {
						textArea.setText("삭제할 값이 없습니다.");
					}
				}
			});
			btnNewButton_4.setBounds(230, 78, 97, 23);
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("Map.Entry");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
					Set<Map.Entry<String, String>> set = map.entrySet();
					
					// 1. 향상된 for문
					for(Map.Entry<String, String> m : set) {
						textArea.append("key : " + m.getKey() + " " + "value : " + m.getValue() + "\n");
					}
					
					// 2. iterator
					Iterator<Map.Entry<String, String>> it = set.iterator();
					while(it.hasNext()) {
						Map.Entry<String, String> m = it.next();
						textArea.append(m.getKey() + " " + m.getValue() + "\n");
					}
				}
			});
			btnNewButton_5.setBounds(339, 78, 97, 23);
		}
		return btnNewButton_5;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 126, 427, 233);
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
	private JButton getBtnNewButton_6() {
		if (btnNewButton_6 == null) {
			btnNewButton_6 = new JButton("\uC870\uD68C");
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(kt.getText().equals("")) {
						textArea.setText("");
						Set<String> st = map.keySet();
						for(String k : st) {
							String value = map.get(k);
							textArea.append("key : " + k + " " + "value : " + value + "\n");
						}
					}else {
						String key = kt.getText();
						String value2 = map.get(key);
						if(value2 != null) {
							kv.setText(value2);
						}else {
							textArea.setText("찾는 값이 없습니다.");
						}
					}
				}
			});
			btnNewButton_6.setBounds(218, 10, 61, 49);
		}
		return btnNewButton_6;
	}
}
