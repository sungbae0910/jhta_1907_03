package c_control;

public class ForExam8 {

	ForExam8() {
		int s1 = 0;
		int s10 = 0;
		int s20 = 0;
		int s30 = 0;
		int s40 = 0;
		int s50 = 0;
		int s60 = 0;
		int s70 = 0;
		int s80 = 0;
		int s90 = 0;

		for (int n = 1; n <= 1000; n++) { // ���� 1000�� �߻�
			int num = (int) (Math.random() * 100) + 1; // ���� NUM�� 1~100������ ����

			if (num < 10) { // ���ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s1++;
			} else if (num < 20) { // 10�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s10++;
			} else if (num < 30) { // 20�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s20++;
			} else if (num < 40) { // 30�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s30++;
			} else if (num < 50) { // 40�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s40++;
			} else if (num < 60) { // 50�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s50++;
			} else if (num < 70) { // 60�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s60++;
			} else if (num < 80) { // 70�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s70++;
			} else if (num < 90) { // 80�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ
				s80++;
			} else if (num <= 100) { // 90�ڸ��� ���� ������ ���´ٸ� +1ī��Ʈ *100�� ���͵� ī��Ʈ
				s90++;
			}
		}
		System.out.println("���ڸ� : " + s1);
		System.out.println("10�ڸ� : " + s10);
		System.out.println("20�ڸ� : " + s20);
		System.out.println("30�ڸ� : " + s30);
		System.out.println("40�ڸ� : " + s40);
		System.out.println("50�ڸ� : " + s50);
		System.out.println("60�ڸ� : " + s60);
		System.out.println("70�ڸ� : " + s70);
		System.out.println("80�ڸ� : " + s80);
		System.out.println("90�ڸ� : " + s90);
	}
}
