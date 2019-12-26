package d_array;

import java.util.Calendar;

public class EnumWeekExample {

	public EnumWeekExample() {
		Week today = null;

		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK); //일(1)~토(7) 숫자로 돌려줌

		switch (week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.THUSEDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}

		System.out.println("오늘의 요일은 : " + today);
		
		if(today == Week.SUNDAY) {
			System.out.println("주말이당");
		}else {
			System.out.println("학원...");
		}
	}// 생성자

	public static void main(String[] args) {
		EnumWeekExample aaa = new EnumWeekExample();
		
	}
}
