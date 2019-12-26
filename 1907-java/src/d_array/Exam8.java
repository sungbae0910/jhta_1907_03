package d_array;

public class Exam8 {

	public Exam8() {
		int[][] aa = new int[5][5];
		int sum = 0;
		int max = 0;
		int min = 201;
		int cnt = 0;

		// 1
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa[i].length; j++) {
				aa[i][j] = (int) (Math.random() * 100 + 100) + 1;
				System.out.print(aa[i][j] + " ");
			}
			System.out.println();
		}

		// 2
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa[i].length; j++) {
				sum += aa[i][j];
			}
		}
		System.out.println("배열의 합 : " + sum);

		// 3,4
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa[i].length; j++) {
				if (aa[i][j] > max) {
					max = aa[i][j];
				}

				if (min > aa[i][j]) {
					min = aa[i][j];
				}
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

		// 5
		for (int i = 0; i < aa.length; i++) {
			max = 0; //각 행의 최대값을 구하기 위해 배열의 최대값을 0으로 초기화 시켜줌
			for (int j = 0; j < aa[i].length; j++) {
				if (aa[i][j] > max) {
					max = aa[i][j];
				}
			}
			cnt++;
			System.out.println(cnt + "행의 최대값 : " + max);
		}

	}

	public static void main(String[] args) {
		Exam8 ex = new Exam8();
	}
}
