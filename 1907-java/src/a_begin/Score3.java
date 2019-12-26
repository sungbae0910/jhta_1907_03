package a_begin;

public class Score3 {

	public Score3() {
		int a = 97;
		int b = 98;
		int total = a + b;
		String today = "2019.11.27(수)";
		String name = "lee sung bae";
		double avg = total / (double)2;
				
		System.out.println("===================");
		System.out.println("성적 처리 결과");
		System.out.println("===================");
		System.out.println("작성일자 : " + today);
		System.out.println("작성자 : " + name);
		System.out.println("국어점수 : " + a);
		System.out.println("영어점수 : " + b);
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println("===================");

	}

	public static void main(String[] args) {
		new Score3();
	}
}
