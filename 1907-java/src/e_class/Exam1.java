package e_class;

/*
 * 1. 두 정수를 전달 받아 합계를 반환하는 메서드 구현(sum)
 * 2. 두 정수(x, y) 를 전달 받아 x~y까지의 합계를 구하여 리턴(sum2)
 * 3. 가로, 세로값을 실수형으로 전달받아 사각형의 넓이를 계산하여 리턴(sum3)
 * 4. 구구단 수를 전달 받아 구구단을 하나의 문자열로 만들어 리턴(gugudan)
 */
public class Exam1 {


	int sum(int x, int y) {
		int sum = x + y;
		return sum;
	}

	int sum2(int x, int y) {
		int sum2 = 0;
		for (; x <= y; x++) {
			sum2 += x;
		}

		return sum2;
	}

	double sum3(double x, double y) {
		double aa = x * y;
		return aa;
	}

	int gugudan(int dan) {
		int result = 0;
		for (int i = 1; i <= 9; i++) {
			result = dan * i;
			System.out.println(dan + "*" + i + "=" + result);
		}
		return result;
	}

	String gugu(int dan) {
		String r = "";
		for (int i = 1; i <= 9; i++) {
			int result = dan * i;
			r += dan + "*" + i + "=" + result + "\n";
		}
		return r;
	}
}
