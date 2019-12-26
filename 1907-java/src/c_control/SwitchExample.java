package c_control;

public class SwitchExample {
	public SwitchExample() {
		String abc = "";
		int num = 0;
		for (int i = 0; i < 10; i++) {

			num = (int) (Math.random() * 6) + 1;

			if (num < 1 || num > 6) {
				System.out.println("번호오류 발생!!");
				System.exit(0);
			}

			switch (num) {
			case 1:
				abc = "1";
				break;
			case 2:
				abc = "2";
				break;
			case 3:
				abc = "3";
				break;
			case 4:
				abc = "4";
				break;
			case 5:
				abc = "5";
				break;
			default:
				abc = "6";
				break;
			}// switch의 끝
			System.out.println("나온 값은 : " + abc);
		} // for문의 끝
	}// 생성자의 끝
}
