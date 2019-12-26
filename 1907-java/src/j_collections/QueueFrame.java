package j_collections;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class QueueFrame extends JInternalFrame {
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	Queue<Message> queue = new LinkedList<Message>();
	private JTextField to;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueFrame frame = new QueueFrame();
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
	public QueueFrame() {
		super("Queue", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getTo());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getComboBox());

	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OFFER");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					queue.offer(new Message(comboBox.getSelectedItem()+"", to.getText()));
				}
			});
			btnNewButton.setBounds(212, 10, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("POLL");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					while(!queue.isEmpty()) {
						Message message = queue.poll();
						switch(message.command) {
							case "KaKao" :
								textArea.append(message.to+"´Ô¿¡°Ô Ä«ÅåÀ» º¸³À´Ï´Ù.");
								break;
							case "SMS" :
								textArea.append(message.to+"´Ô¿¡°Ô SMSÀ» º¸³À´Ï´Ù.");
								break;
							case "Mail" :
								textArea.append(message.to+"´Ô¿¡°Ô MailÀ» º¸³À´Ï´Ù.");
								break;
						}
						textArea.append("\n");
					}
				}
			});
			btnNewButton_1.setBounds(212, 52, 97, 23);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 96, 410, 149);
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
	private JTextField getTo() {
		if (to == null) {
			to = new JTextField();
			to.setBounds(92, 53, 90, 21);
			to.setColumns(10);
		}
		return to;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Command");
			lblNewLabel.setBounds(12, 14, 65, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("To");
			lblNewLabel_1.setBounds(12, 56, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(92, 10, 90, 21);
			
			comboBox.addItem("KaKao");
			comboBox.addItem("SMS");
			comboBox.addItem("Mail");
		}
		return comboBox;
	}
}
