package h_api;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DecimalForrmatExam extends JInternalFrame {
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecimalForrmatExam frame = new DecimalForrmatExam();
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
	public DecimalForrmatExam() {
		//첫번째 true를 false로 주면 창화면을 조작못함
		super("Decimal", true, true, true, true);
		setTitle("Decimal");
		setBounds(100, 100, 467, 383);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getTextField());
		getContentPane().add(getScrollPane());
		setVisible(true);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC785\uAE08\uC561");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel.setBounds(29, 40, 57, 15);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC9C\uB2E8\uC704");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					long v = Long.parseLong(textField.getText());
					DecimalFormat df = new DecimalFormat("00,000,000,000.00");
					String r = df.format(v);
					
					textArea.append(r+"\n");
				}
			});
			btnNewButton.setBounds(38, 92, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC18C\uC22B\uC810");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double d = Double.parseDouble(textField.getText());
					DecimalFormat df = new DecimalFormat("#,###,###,###.##");
					
					textArea.append(df.format(d)+"\n");
				}
			});
			btnNewButton_1.setBounds(185, 92, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC6D0\uD654\uD45C\uC2DC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double d = Double.parseDouble(textField.getText());
					DecimalFormat df = new DecimalFormat("\u00a4 #,###.##");
					
					textArea.append(df.format(d)+"\n");
				}
			});
			btnNewButton_2.setBounds(328, 92, 97, 23);
		}
		return btnNewButton_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(87, 25, 341, 45);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 142, 387, 192);
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
