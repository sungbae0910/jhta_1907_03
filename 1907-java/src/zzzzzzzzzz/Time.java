package zzzzzzzzzz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

public class Time extends Thread{
	private JTextField dd;
	
	//참조형 변수를 전달받았기 때문에 똑같은 주소를 참조하고 있어 이곳에서 값을 바꿔도 넘겨준 곳에서도 변경이 됨.
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
