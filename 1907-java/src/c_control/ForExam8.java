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

		for (int n = 1; n <= 1000; n++) { // 난수 1000개 발생
			int num = (int) (Math.random() * 100) + 1; // 변수 NUM은 1~100사이의 난수

			if (num < 10) { // 단자리의 수인 난수가 나온다면 +1카운트
				s1++;
			} else if (num < 20) { // 10자리의 수인 난수가 나온다면 +1카운트
				s10++;
			} else if (num < 30) { // 20자리의 수인 난수가 나온다면 +1카운트
				s20++;
			} else if (num < 40) { // 30자리의 수인 난수가 나온다면 +1카운트
				s30++;
			} else if (num < 50) { // 40자리의 수인 난수가 나온다면 +1카운트
				s40++;
			} else if (num < 60) { // 50자리의 수인 난수가 나온다면 +1카운트
				s50++;
			} else if (num < 70) { // 60자리의 수인 난수가 나온다면 +1카운트
				s60++;
			} else if (num < 80) { // 70자리의 수인 난수가 나온다면 +1카운트
				s70++;
			} else if (num < 90) { // 80자리의 수인 난수가 나온다면 +1카운트
				s80++;
			} else if (num <= 100) { // 90자리의 수인 난수가 나온다면 +1카운트 *100이 나와도 카운트
				s90++;
			}
		}
		System.out.println("단자리 : " + s1);
		System.out.println("10자리 : " + s10);
		System.out.println("20자리 : " + s20);
		System.out.println("30자리 : " + s30);
		System.out.println("40자리 : " + s40);
		System.out.println("50자리 : " + s50);
		System.out.println("60자리 : " + s60);
		System.out.println("70자리 : " + s70);
		System.out.println("80자리 : " + s80);
		System.out.println("90자리 : " + s90);
	}
}
