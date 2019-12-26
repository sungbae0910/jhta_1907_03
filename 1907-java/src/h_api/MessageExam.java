package h_api;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MessageExam extends JInternalFrame {
	private JPanel panel;
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
					MessageExam frame = new MessageExam();
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
	public MessageExam() {
		super("MessageFormat", false, true, true, true);
		setBounds(100, 100, 404, 363);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
		setVisible(true);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 30));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("DM \uBC1C\uC1A1");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sd = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
					String now = sd.format(new Date());
					String[][] data = {{"11-111","lee","¿À¿À","°í°´°ü¸®ÆÀ",now}, {"22-222","hong","okokokok","Àü·«ÆÀ","now"},
							{"33-333","park","qwerasdzxc","È«º¸ÆÀ",now}, {"44-444","oh","uiophjkl","È¸°èÆÀ",now}};
					String dm = "¿ìÆí¹øÈ£ : {0} \n°í°´¸í : {1} \n\n {2} \n\n¹ß¼ÛÃ³ : {3}\n\n {4} \n";
					dm+="---------------------------------------------------------------\n";
					
					StringBuilder sb = new StringBuilder();
					
					for(int i=0; i<data.length; i++) {
						String temp = MessageFormat.format(dm, data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
						/*¶È°°Àº °á°ú°¡ Æ¢¾î³ª¿È
						 *String temp = MessageFormat.format(dm, data[i]); 
						 */
						sb.append(temp);
					}
					
					textArea.setText(sb.toString());
				}
			});
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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
