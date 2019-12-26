package h_api;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SimpleDateExam extends JInternalFrame {
	private JButton btnNewButton;
	private JLabel ok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleDateExam frame = new SimpleDateExam();
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
	public SimpleDateExam() {
		super("SimpleDateFormat", false,true,true,true);
		setBounds(100, 100, 430, 225);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getOk());
		setVisible(true);
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC624\uB298\uB0A0\uC9DC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date dt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)ø‰¿œ hh:mm:ss");
					
					ok.setText(sdf.format(dt));
					
				}
			});
			btnNewButton.setBounds(12, 10, 97, 23);
		}
		return btnNewButton;
	}
	private JLabel getOk() {
		if (ok == null) {
			ok = new JLabel("");
			ok.setOpaque(true);
			ok.setBackground(Color.LIGHT_GRAY);
			ok.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 17));
			ok.setHorizontalAlignment(SwingConstants.CENTER);
			ok.setBounds(12, 53, 390, 106);
		}
		return ok;
	}
}
