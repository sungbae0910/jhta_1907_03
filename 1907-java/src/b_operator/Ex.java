package b_operator;

import java.util.Scanner;

public class Ex {

	public Ex() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ݰ�� : 1�� | ���ڰ�� : 2�� ");
		int num = scan.nextInt();

		if (num == 1) {
			System.out.println("�ݾ��� �Է����ּ���  : ");
			double value = scan.nextDouble();
			double aa = Math.floor(value * 0.01) * 100;
			System.out.println(aa);
			scan.close();
		} else if (num == 2) {
			System.out.println("�ݾ��� �Է����ּ��� : ");
			double value = scan.nextDouble();
			double bb = Math.ceil(value * 0.01) * 100;
			System.out.println(bb);
			scan.close();
		}
	}

	public static void main(String[] args) {
		new Ex();
	}
}
