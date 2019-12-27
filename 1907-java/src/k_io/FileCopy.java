package k_io;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Color;

public class FileCopy extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField original;
	private JTextField target;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JProgressBar progressBar;
	private JButton btnNewButton_2;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileCopy frame = new FileCopy();
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
	public FileCopy() {
		super("파일복사", false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 489, 271);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getOriginal());
		getContentPane().add(getTarget());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getProgressBar());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC6D0\uBCF8\uD30C\uC77C");
			lblNewLabel.setBounds(12, 30, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB300\uC0C1\uD30C\uC77C");
			lblNewLabel_1.setBounds(12, 62, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getOriginal() {
		if (original == null) {
			original = new JTextField();
			original.setBounds(81, 27, 254, 21);
			original.setColumns(10);
		}
		return original;
	}
	private JTextField getTarget() {
		if (target == null) {
			target = new JTextField();
			target.setBounds(81, 59, 254, 21);
			target.setColumns(10);
		}
		return target;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCC3E\uC544\uBCF4\uAE30");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int state = fc.showOpenDialog(FileCopy.this);
					if(state==JFileChooser.APPROVE_OPTION) {//열기버튼
						original.setText(fc.getSelectedFile().getPath());
					}
				}
			});
			btnNewButton.setBounds(366, 26, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uCC3E\uC544\uBCF4\uAE30");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int state = fc.showSaveDialog(FileCopy.this);
					if(state==JFileChooser.APPROVE_OPTION) {
						target.setText(fc.getSelectedFile().getPath());
					}
				}
			});
			btnNewButton_1.setBounds(366, 58, 97, 23);
		}
		return btnNewButton_1;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(12, 101, 450, 21);
		}
		return progressBar;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uBCF5\uC0AC");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileCopyThread fct = new FileCopyThread(progressBar);
					fct.setOriginal(original.getText());
					fct.setTarget(target.getText());
					
					status.setText("파일 복사중....");
					try {
						fct.join();
						fct.start();
						
						status.setText("복사가 완료되었습니다.");
					}catch (Exception ex) {
					}
				}
			});
			btnNewButton_2.setBounds(182, 132, 97, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("New label");
			status.setOpaque(true);
			status.setBackground(Color.LIGHT_GRAY);
			status.setBounds(12, 172, 451, 56);
		}
		return status;
	}
}
