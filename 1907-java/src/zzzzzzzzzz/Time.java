package zzzzzzzzzz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

public class Time extends Thread{
	private JTextField dd;
	
	//������ ������ ���޹޾ұ� ������ �Ȱ��� �ּҸ� �����ϰ� �־� �̰����� ���� �ٲ㵵 �Ѱ��� �������� ������ ��.
	public Time(JTextField time) {
		this.dd=time;
	}

	@Override
	public void run() {
		while(true) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
			dd.setText(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
