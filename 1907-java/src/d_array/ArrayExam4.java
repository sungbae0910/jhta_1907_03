package d_array;

import java.util.Scanner;

public class ArrayExam4 {
	Scanner scan = new Scanner(System.in);
	int i;
	String[] names = new String[10];
	int[][] jum = new int[10][2];
	int cnt = 0;

	// ���� ������ ���鼭 �޴��� ���
	public ArrayExam4() {
		String a = "";

		do {
			System.out.println("--------------------------------");
			System.out.println("1. �����Է� | 2.�������� | 3. ���� ��ȸ  ");
			System.out.println("------�����Ϸ��� q�� �Է��ϼ���!!------");
			System.out.println("--------------------------------");
			System.out.print("> ");
			a = scan.nextLine();

			if (a.equals("1")) {
				input();
			} else if (a.equals("2")) {
				modify();
			} else if (a.equals("3")) {
				search();
			}
		} while (!a.equals("q"));

		scan.close();
		System.out.println("����Ǿ����ϴ�");
	}

	// ���� ������ �Է��� ��
	public void input() {
		String name = "";
		int kor = 0;
		int eng = 0;
		int sum = 0;
		double avg = 0;

		System.out.print("�̸��� �Է��ϼ��� : ");
		name = scan.nextLine();
		System.out.print("���� : ");
		kor = scan.nextInt();
		System.out.print("���� : ");
		eng = scan.nextInt();
		scan.nextLine();

		sum = kor + eng;
		avg = sum / 2.0;
		System.out.println("�̸� : " + name);
		System.out.println("�հ� : " + kor);
		System.out.println("��� : " + eng);

		if (cnt < 10) {
			names[cnt] = name;
			jum[cnt][0] = kor;
			jum[cnt][1] = eng;
			cnt++;
		} else {
			System.out.println("������ �����մϴ�.");
		}

	}

	// �л��� ������ ����
	public void modify() {
		String sh = "";

		System.out.print("�̸��� �Է��ϼ��� : ");
		sh = scan.nextLine();

		for (int i = 0; i < cnt; i++) {
			if (names[i].equals(sh)) {
				System.out.println("�̸� : " + names[i]);
				System.out.println("���� ���� : " + jum[i][0]);
				System.out.println("���� ���� : " + jum[i][1]);
				
				System.out.println("������ ����");
				System.out.print("�̸� : ");
				names[i] = scan.nextLine();
				System.out.print("���� : ");
				jum[i][0] = scan.nextInt();
				System.out.print("���� : ");
				jum[i][1] = scan.nextInt();
				scan.nextLine();
			}else {
				System.out.println("ã���ô� ���� �����ϴ�.");
			}
		}//for

	}//modify

	// �л� ���� ������ ��ȸ �� ���
	public void search() {
		String sh = "";
		
		int sum = 0;
		double avg = 0;

		System.out.print("�˻�� �Է��ϼ��� : ");
		sh = scan.nextLine();

		for (int i = 0; i < cnt; i++) {
			if (names[i].equals(sh)) {
				System.out.println("�̸� : " + names[i]);
				System.out.println("���� ���� : " + jum[i][0]);
				System.out.println("���� ���� : " + jum[i][1]);
				System.out.println("���� �հ� : " + (jum[i][0] + jum[i][1]));
				System.out.println("���� ��� : " + (jum[i][0] + jum[i][1]) / 2.0);
			} else if (!names[i].equals(sh)) {
				System.out.println("ã���ô� �̸��� �����ϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		ArrayExam4 asd = new ArrayExam4();
	}

}
