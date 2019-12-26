package zzzzzzzzzz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

public class asdasd extends JInternalFrame {
	private JScrollPane scrollPane;
	private TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asdasd frame = new asdasd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void asd() {
		BoardVo[] s = BoardMain.data;
		BoardVo temp = null;
		String dd ="";
		for(int i=0; i<BoardMain.count; i++) {
			temp = BoardMain.data[i];
			dd+=temp.toString();
		}
		textArea.setText(dd);
	}
	/**
	 * Create the frame.
	 */
	public asdasd() {
		super("ddd", false,true,true,true);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
		setVisible(true);
		asd();

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
		}
		return textArea;
	}
}
