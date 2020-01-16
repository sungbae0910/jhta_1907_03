package m_jdbc;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MemberSelect extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField find;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSelect frame = new MemberSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberSelect() {
		super("select", false, true, true, true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getFind());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		setVisible(true);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC815\uBCF4\uC870\uD68C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 410, 36);
		}
		return lblNewLabel;
	}
	private JTextField getFind() {
		if (find == null) {
			find = new JTextField();
			find.setBounds(83, 43, 195, 21);
			find.setColumns(10);
		}
		return find;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					String f = find.getText();
					List<MemberVo> list = dao.select(f);
					
					if(list.isEmpty()) {
						textArea.setText("찾는정보가 없음");
					}else {
						textArea.setText("");
						for(MemberVo vo : list) {
						textArea.append(vo.toString());
						}
					}
				}
			});
			btnNewButton.setBounds(298, 42, 97, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 93, 373, 146);
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
