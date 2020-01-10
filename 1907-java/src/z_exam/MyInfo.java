package z_exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyInfo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn123;
	private JButton btnABC;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInfo frame = new MyInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getBtn123(), BorderLayout.CENTER);
		contentPane.add(getBtnABC(), BorderLayout.NORTH);
	}

	public synchronized void job() { // synchronized 상호 배타적 동기화를 구현
		
		synchronized(this) { // 여기서의 this는 class 자기자신 
		}
	}
	
	private JButton getBtn123() {
		if (btn123 == null) {
			btn123 = new JButton("123");
			btn123.addActionListener(this);
		}
		return btn123;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			SubThread st = new SubThread();
			Thread t = new Thread(st);
			t.setDaemon(true);
			t.start();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	private JButton getBtnABC() {
		if (btnABC == null) {
			btnABC = new JButton("abc");
			btnABC.addActionListener(this);
		}
		return btnABC;
	}
}
