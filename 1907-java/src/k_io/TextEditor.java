package k_io;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextEditor extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTextArea textArea;
	public String fileName;
	private JLabel status;
	boolean modifyFlag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditor frame = new TextEditor();
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
	public TextEditor() {
		super("noName", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}
	
	public TextEditor(String fileName) {
		this();
		this.fileName=fileName;
		setTitle(fileName); //파일을 열었을때 파일의 이름을 표시
		load();
	}
	
	public void load() {
		try {
			FileReader fr = new FileReader(fileName);
			char[] data = new char[100];
			int readData = 0; //읽은 데이터의 크기
			textArea.setText("");
			
			while((readData = fr.read(data)) != -1) {
				String temp =  new String(data,0,readData);
				textArea.append(temp);
			}
			fr.close();
		} catch (Exception e) {
			
		}
	}
	
	public boolean save() {
		boolean b = true;
		
		if(!modifyFlag) return b;
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(textArea.getText());
			fw.flush();
			fw.close();
			setTitle(fileName);
			b=true;
		} catch (Exception e) {
			b=false;
		}
		
		return b;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
			scrollPane.setRowHeaderView(getStatus());
		}
		return scrollPane;
	}
	
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					// if(e.getKeyCode == KeyEvent.VK_ENTER) {} 키이벤트 예제
					if(e.getKeyCode() != KeyEvent.VK_SHIFT && 
					   e.getKeyCode() != KeyEvent.VK_ALT &&
					   e.getKeyCode() != KeyEvent.VK_CONTROL &&
					   e.getKeyCode() != KeyEvent.VK_HOME &&
					   e.getKeyCode() != KeyEvent.VK_END &&
					   e.getKeyCode() != KeyEvent.VK_PAGE_DOWN &&
					   e.getKeyCode() != KeyEvent.VK_PAGE_UP &&
					   e.getKeyCode() != KeyEvent.VK_LEFT &&
					   e.getKeyCode() != KeyEvent.VK_RIGHT &&
					   e.getKeyCode() != KeyEvent.VK_UP &&
					   e.getKeyCode() != KeyEvent.VK_DOWN) {
						modifyFlag = true;
						if(fileName==null) {
							setTitle("noName*");
						}else {
							setTitle(fileName+"*");
						}
					}
				}
			});
		}
		return textArea;
	}
	public JLabel getStatus() {
		if (status == null) {
			status = new JLabel("New label");
		}
		return status;
	}
}