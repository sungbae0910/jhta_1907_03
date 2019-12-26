package h_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//date 클래스 예제 실습
public class DateExample {
	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt);
		

		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(dt));
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		System.out.println(now.get(Calendar.JULY));
		
	}
}
