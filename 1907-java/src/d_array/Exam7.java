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
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("==============================");
			System.out.print("���� : ");
			balance = scan.nextInt();

			if (balance == 1) {
				System.out.print("���ݾ� :");
				ss = scan.nextInt();
				money += ss;
			} else if (balance == 2) {
				System.out.print("��ݾ� :");
				ss = scan.nextInt();
				if(money < ss) {
					System.out.println("�ܾ׺���!!");
				}else {
					money -= ss;
				}
			} else if (balance == 3) {
				System.out.println("�ܰ� : " + money);
			} else if (balance == 4) {
				run = false;
			}
		} // while
		System.out.println("���α׷� ����");
		scan.close();
	}// ������
}
