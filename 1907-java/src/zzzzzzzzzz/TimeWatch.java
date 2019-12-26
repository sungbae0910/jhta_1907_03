package zzzzzzzzzz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TimeWatch extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField time;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeWatch frame = new TimeWatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new TimeWatch();
	}
	
	/**
	 * Create the frame.
	 */
	public TimeWatch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getTime());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getPanel());
		
		setVisible(true);
		Time t = new Time(time);
		t.setDaemon(true);
		t.start();
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC2DC\uACC4");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTime() {
		if (time == null) {
			time = new JTextField();
			time.setHorizontalAlignment(SwingConstants.CENTER);
			time.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			time.setBounds(22, 35, 425, 83);
			time.setColumns(10);
		}
		return time;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC2A4\uD1B1\uC6CC\uCE58");
			lblNewLabel_1.setBounds(12, 136, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC2DC\uC791");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					StopWatchThread swt = (StopWatchThread)panel;
					swt.stop=false;
					Thread stw = new Thread(swt);
					stw.setDaemon(true);
					stw.start();
				}
			});
			btnNewButton.setBounds(104, 293, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC885\uB8CC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StopWatchThread swt = (StopWatchThread)panel;
					swt.stop=true;
				}
			});
			btnNewButton_1.setBounds(262, 293, 97, 23);
		}
		return btnNewButton_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new StopWatchThread();
			panel.setBounds(22, 174, 420, 91);
		}
		return panel;
	}
}
