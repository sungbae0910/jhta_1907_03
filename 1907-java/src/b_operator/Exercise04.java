package b_operator;

import java.util.Scanner;

public class Exercise04 {

	public Exercise04() {
		int i;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.printf("연필의 숫자를 입력해주세요 :");
			int pencils = scan.nextInt();
			System.out.printf("학생의 숫자를 입력해주세요 :");
			int students = scan.nextInt();
			int pencilss = pencils / students;
			int left = pencils % students;

			System.out.println("나눠준 연필의 숫자 :" + pencilss);
			System.out.println("남은 연필의 숫자 :" + left);

			System.out.println("다시 실행하려면 1 종료하려면 2 :");
			i = scan.nextInt();

		} while (i == 1);
		System.out.println("종료되었습니다.");
		scan.close();
	}

	public static void main(String[] args) {
		new Exercise04();
	}
}
