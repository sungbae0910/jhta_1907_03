package c_control;

import java.util.Scanner;

/*
 * main�Լ��� Ŭ���������� �ٷ� �޼ҵ带 ������ �� ����ϴ°�
 */
public class IfExample {
	Scanner scan = new Scanner(System.in);

	public int type1() {
		int a;

		System.out.println("������ �Է��ϼ��� : ");
		a = scan.nextInt();
		if (a >= 90) {
			System.out.println("90���̻��Դϴ�.");
			System.out.println("A����");
		} else {
			System.out.println("�������K�Ϥ�");
		}

		return a;
	}

	public String type2() {
		String a = "";

		System.out.println("�����Է����ּ��� : ");
		int s = scan.nextInt();

		if (s >= 90) {
			System.out.println("90�̻�");
		} else {
			System.out.println("��ƾƾ�");
		}

		scan.close();
		return a;
	}

	char type3() {
		char r = ' ';

		System.out.println("���� �Է� : ");
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
	 * ������ 0~100���϶��� 60�̻��̸� '�հ�', 60�̸��̸� '���հ�'���, ������ ���� ���̸� ��������
	 */
	void type4() {
		System.out.println("������ �Է����ּ��� : ");
		int abc = scan.nextInt();

		if (abc <= 100 && abc >= 0) {
			if (abc >= 60) {
				System.out.println("�հ��Դϴ�!!");
			} else {
				System.out.println("���հ��Դϴ�!!");
			}
		} else {
			System.out.println("���������Դϴ�. 0~100���� �Է����ּ���!!");
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
