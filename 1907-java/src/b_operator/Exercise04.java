package b_operator;

import java.util.Scanner;

public class Exercise04 {

	public Exercise04() {
		int i;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.printf("������ ���ڸ� �Է����ּ��� :");
			int pencils = scan.nextInt();
			System.out.printf("�л��� ���ڸ� �Է����ּ��� :");
			int students = scan.nextInt();
			int pencilss = pencils / students;
			int left = pencils % students;

			System.out.println("������ ������ ���� :" + pencilss);
			System.out.println("���� ������ ���� :" + left);

			System.out.println("�ٽ� �����Ϸ��� 1 �����Ϸ��� 2 :");
			i = scan.nextInt();

		} while (i == 1);
		System.out.println("����Ǿ����ϴ�.");
		scan.close();
	}

	public static void main(String[] args) {
		new Exercise04();
	}
}
