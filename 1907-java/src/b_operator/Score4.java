package b_operator;

public class Score4 {
	Score4() {
		int kor = 59;
		int eng = 68;
		int ma = 60;
		int total = kor + eng + ma;
		double avg = total / 3.0;
		String hap;

		if (kor >= 40 && eng >= 40 && ma >= 40 && avg >= 60) {
			hap = "�հ�";
		} else {
			hap = "���հ�";
		}

		System.out.println("===============");
		System.out.println("�հ� ���� ����");
		System.out.println("===============");
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("���� : " + ma);
		System.out.println("���� : " + total);
		System.out.println("��� : " + avg);
		System.out.println("�հ� ���� : " + hap);

		boolean ok = (kor >= 40 && eng >= 40 && ma >= 40 && avg >= 60);

		hap = (ok) ? "�հ�" : "���հ�";
		System.out.println(hap);
	}

	public static void main(String[] args) {
		new Score4();
	}
}
