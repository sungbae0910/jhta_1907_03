package a_begin;

public class Score3 {

	public Score3() {
		int a = 97;
		int b = 98;
		int total = a + b;
		String today = "2019.11.27(��)";
		String name = "lee sung bae";
		double avg = total / (double)2;
				
		System.out.println("===================");
		System.out.println("���� ó�� ���");
		System.out.println("===================");
		System.out.println("�ۼ����� : " + today);
		System.out.println("�ۼ��� : " + name);
		System.out.println("�������� : " + a);
		System.out.println("�������� : " + b);
		System.out.println("�հ� : " + total);
		System.out.println("��� : " + avg);
		System.out.println("===================");

	}

	public static void main(String[] args) {
		new Score3();
	}
}
