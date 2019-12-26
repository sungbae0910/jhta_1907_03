package c_control;

import java.util.Scanner;

/*
 * main함수는 클래스내에서 바로 메소드를 실행할 때 사용하는것
 */
public class IfExample {
	Scanner scan = new Scanner(System.in);

	public int type1() {
		int a;

		System.out.println("성적을 입력하세요 : ");
		a = scan.nextInt();
		if (a >= 90) {
			System.out.println("90점이상입니다.");
			System.out.println("A학점");
		} else {
			System.out.println("으하하핳하ㅏ");
		}

		return a;
	}

	public String type2() {
		String a = "";

		System.out.println("성적입력해주세요 : ");
		int s = scan.nextInt();

		if (s >= 90) {
			System.out.println("90이상");
		} else {
			System.out.println("흐아아아");
		}

		scan.close();
		return a;
	}

	char type3() {
		char r = ' ';

		System.out.println("점수 입력 : ");
		int s = scan.nextInt();

		if (s >= 90) {
			r = 'A';
		} else if (s >= 80) {
			r = 'B';
		} else if (s >= 70) {
			r = 'C';
		} else {
			r = 'D';
		}

		scan.close();
		return r;
	}

	/*
	 * 성적이 0~100점일때만 60이상이면 '합격', 60미만이면 '불합격'출력, 성적이 범위 밖이면 성적오류
	 */
	void type4() {
		System.out.println("성적을 입력해주세요 : ");
		int abc = scan.nextInt();

		if (abc <= 100 && abc >= 0) {
			if (abc >= 60) {
				System.out.println("합격입니다!!");
			} else {
				System.out.println("불합격입니다!!");
			}
		} else {
			System.out.println("성적오류입니다. 0~100점만 입력해주세요!!");
		}

	}

	public static void main(String[] args) {
		IfExample ooo = new IfExample();

		/*
		 * int ee = ooo.type1(); String d = ooo.type2(); char jumsu = ooo.type3();
		 */
		/* ooo.type4(); */
		ooo.type4();
	}

}
