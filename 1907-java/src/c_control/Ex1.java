package c_control;

import java.util.Scanner;

/*/
 * ��� ó���� �����ڸ� ����Ͽ� �ذ�
 * ����, �ּ�, ����ó�� ���ڿ��� �߻�
 * ������ ���������� �߻��Ͽ� ���� kor, eng, mat�� ����
 * if else if���� ����ϰ� ��հ��� ����Ͽ� ������ ���ؼ� ������ ���� grade�� ����
 */
public class Ex1 {

	public Ex1() {
		String name = "lee sung bae";
		String address = "seoul mapo";
		String phone = "010-7740-9609";
		char grade = ' ';
		Scanner scan = new Scanner(System.in);

		System.out.println("������ �Է����ּ���");
		System.out.print("���� : ");
		int kor = scan.nextInt();
		System.out.print("���� : ");
		int eng = scan.nextInt();
		System.out.print("���� : ");
		int mat = scan.nextInt();

		int tot = kor + eng + mat;
		double avg = tot / 3.0;


		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("================");
		System.out.println("ó�����");
		System.out.println("================");
		System.out.println("���� : " + name);
		System.out.println("�ּ� : " + address);
		System.out.println("����ó : " + phone);
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("���� : " + mat);
		System.out.println("���� : " + tot);
		System.out.println("��� : " + avg);
		System.out.println("���� : " + grade);
		
		scan.close();

	}

	public static void main(String[] args) {
//		Ex1 eee = new Ex1();

	}

}
