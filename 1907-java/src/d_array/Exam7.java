package d_array;

import java.util.Scanner;

public class Exam7 {
	Scanner scan = new Scanner(System.in);
	public Exam7() {
		boolean run = true;
		int balance = 0;
		int money = 0;
		int ss = 0;

		while (run) {
			System.out.println("==============================");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("==============================");
			System.out.print("선택 : ");
			balance = scan.nextInt();

			if (balance == 1) {
				System.out.print("예금액 :");
				ss = scan.nextInt();
				money += ss;
			} else if (balance == 2) {
				System.out.print("출금액 :");
				ss = scan.nextInt();
				if(money < ss) {
					System.out.println("잔액부족!!");
				}else {
					money -= ss;
				}
			} else if (balance == 3) {
				System.out.println("잔고 : " + money);
			} else if (balance == 4) {
				run = false;
			}
		} // while
		System.out.println("프로그램 종료");
		scan.close();
	}// 생성자
}
