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
			hap = "합격";
		} else {
			hap = "불합격";
		}

		System.out.println("===============");
		System.out.println("합격 여부 통지");
		System.out.println("===============");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + ma);
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println("합격 여부 : " + hap);

		boolean ok = (kor >= 40 && eng >= 40 && ma >= 40 && avg >= 60);

		hap = (ok) ? "합격" : "불합격";
		System.out.println(hap);
	}

	public static void main(String[] args) {
		new Score4();
	}
}
