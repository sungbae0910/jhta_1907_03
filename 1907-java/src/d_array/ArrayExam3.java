package d_array;

import java.util.Scanner;

public class ArrayExam3 {
	int sum;

	public ArrayExam3() {

	}// ������

	public void Array() {
		int[][] test = { { 95, 85 }, { 100, 102, 101 } };
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.println(test[i][j]);
			}
		}
	}// Array �޼ҵ�

	public void asdas() {
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		int[][] asd = { { 1, 2, 4 }, { 2, 4, 4 }, { 1, 2, 6 } };

		for (int i = 0; i < asd.length; i++) { // ���� ������ŭ ����
			if (asd[i][2] % 2 == 0) { // 3��°���� ¦���϶��� ��ħ
				sum += asd[i][2];
				cnt++;
			} // if
		} // for
		if (cnt > 0) {
			avg = (double) sum / cnt;
		}
		System.out.println(avg);

	} // asdas

	// ���ڿ� 1���� �迭��(names) ������ ���� 5���� ����
	// ������ 2�����迭(score) 5���� ����, ���� ������ ����
	public int test2() {
		String[] names = { "lee", "kim", "oh", "shin", "park" };
		int[][] score = { { 90, 20 }, { 100, 60 }, { 95, 45 }, { 85, 80 }, { 79, 84 } };
		int sum = 0;
		double ads = 0;
		// �迭�� ù ��° �л��� �̸��� ������ ���
		System.out.println("�л��̸� : " + names[0]);
		System.out.println("���� ���� : " + score[0][0]);
		System.out.println("���� ���� : " + score[0][1]);

		sum = score[0][0] + score[0][1];
		ads = sum / 2.0;
		System.out.println("���� : " + sum);
		System.out.println("��� : " + ads);

		// 3��° �л��� ���������� 100���� ����
		score[2][0] = 100;

		// 3��° �л��� �̸��� ����� ���
		System.out.println("3��° �л��̸� : " + names[2]);
		System.out.println("3��° �л� ���� ���� : " + score[2][0]);

		return 0;
	}

	public void ddd() {
		// �л����� shin�� ����� ����,���� ������ �հ�� ��� ���
		// �˻�� �Է��Ͽ� �˻��ϰ� �˻��� �����Ϸ��� "quit"�� �Է��ϵ��� �ۼ�
		String[] names = { "lee", "kim", "oh", "shin", "park" };
		int[][] score = { { 90, 20 }, { 100, 60 }, { 95, 45 }, { 85, 80 }, { 79, 84 } };
		int sum = 0;
		double ads = 0;
		Scanner scan = new Scanner(System.in);
		String zzz = "";
		int dd = -1;

		do {
			System.out.println("�����Ϸ��� quit�� �Է��ϼ���");
			System.out.print("�˻�� �Է��ϼ��� : ");
			zzz = scan.nextLine();
			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(zzz)) {
					dd = i;
					System.out.println(score[dd][0]);
					System.out.println(score[dd][1]);

					sum = score[dd][0] + score[dd][1];
					ads = sum / 2.0;
					System.out.println("ã�� ����� �迭 ��ġ : " + dd);
					System.out.println("ã�� ����� ���� �հ� : " + sum);
					System.out.println("ã�� ����� ���� ��� : " + ads);
					break; //�Ѱ��� ������� ã�� ���� break�� ���� �ƴϸ� ����
				}
			}
			if (dd == -1) {
				System.out.println("ã�°��� �����ϴ�.");
			}
		} while (!zzz.equals("quit"));
		System.out.println("����");
	}

	public static void main(String[] args) {
		ArrayExam3 asd = new ArrayExam3();
		asd.ddd();
	}// ����
}
