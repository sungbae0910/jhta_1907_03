package zzzzzzzzzz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class asdad extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField sad;
	static String timerBuffer; 
	static int oldTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asdad frame = new asdad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new asdad();
	}

	
	/**
	 * Create the frame.
	 */
	public asdad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSad(), BorderLayout.CENTER);
		Thread th = new Thread(this);
		th.start();
	}

	private JTextField getSad() {
		if (sad == null) {
			sad = new JTextField();
			sad.setColumns(10);
		}
		return sad;
	}


	@Override
	public void run() {
		while(true) {
			oldTime = (int) System.currentTimeMillis() / 1000;
			int hour, min, sec;
			SimpleDateFormat dataformat = new SimpleDateFormat("hh:mm:ss.SSS");
			Calendar cl = Calendar.getInstance();
			String msg = dataformat.format(cl.getTime());
			sad.setText(msg);
			System.out.println(msg);
			try {
			} catch (Exception e) {
			}
		}
		
	}
}
