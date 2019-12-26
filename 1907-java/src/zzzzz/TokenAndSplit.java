package zzzzz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TokenAndSplit extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTextField str;
	private JLabel lblNewLabel;
	private JTextField deli;
	private JButton to;
	private JButton sp;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TokenAndSplit frame = new TokenAndSplit();
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
	public TokenAndSplit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getStr());
		contentPane.add(getLblNewLabel());
		contentPane.add(getDeli());
		contentPane.add(getTo());
		contentPane.add(getSp());
		contentPane.add(getScrollPane());
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBB38\uC790\uC5F4");
			label.setFont(new Font("±¼¸²", Font.PLAIN, 15));
			label.setBounds(22, 17, 65, 24);
		}
		return label;
	}
	private JTextField getStr() {
		if (str == null) {
			str = new JTextField();
			str.setText("a,text,,,sddd,\uC624\uC624,wqe,,2541");
			str.setBounds(73, 12, 298, 36);
			str.setColumns(10);
		}
		return str;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uAD6C\uBD84\uC790");
			lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 15));
			lblNewLabel.setBounds(22, 77, 50, 24);
		}
		return lblNewLabel;
	}
	private JTextField getDeli() {
		if (deli == null) {
			deli = new JTextField();
			deli.setBounds(73, 72, 87, 36);
			deli.setColumns(10);
		}
		return deli;
	}
	private JButton getTo() {
		if (to == null) {
			to = new JButton("Token");
			to.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String msg = "";
					String d = deli.getText();
					StringTokenizer tok = new StringTokenizer(str.getText(),d);
					while(tok.hasMoreTokens()) {
						msg+=tok.nextToken()+"\n";
					}
					textArea.setText(msg);
				}
			});
			to.setBounds(166, 78, 97, 23);
		}
		return to;
	}
	private JButton getSp() {
		if (sp == null) {
			sp = new JButton("Split");
			sp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg = "";
					String d = deli.getText();
					String[] spit = str.getText().split(d);
					for(String name : spit) {
						msg+=name+"\n";
					}
					textArea.append(msg);
				}
			});
			sp.setBounds(275, 78, 97, 23);
		}
		return sp;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(73, 125, 298, 151);
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
