package c_control;

import java.util.Scanner;

public class SumExample {
	Scanner scan = new Scanner(System.in); // ��ĳ�� ����
	int sum = 0;
	int i = 0;
	int a = 1;

	public SumExample() {
		System.out.print("�հ踦 ���� ���� �Է��ϼ��� : ");
		i = scan.nextInt(); 	// scanner�� �̿��� ���� ���� �Է¹���

		while (a <= i) {	 // a�� �Է��� ������ �۰ų� ���������� ���ư�
			sum += a;
			a++;
		}
		System.out.println("1~" + i + "������ �� : " + sum);
	}
}
