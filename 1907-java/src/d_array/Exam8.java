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
		System.out.println("�迭�� �� : " + sum);

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
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);

		// 5
		for (int i = 0; i < aa.length; i++) {
			max = 0; //�� ���� �ִ밪�� ���ϱ� ���� �迭�� �ִ밪�� 0���� �ʱ�ȭ ������
			for (int j = 0; j < aa[i].length; j++) {
				if (aa[i][j] > max) {
					max = aa[i][j];
				}
			}
			cnt++;
			System.out.println(cnt + "���� �ִ밪 : " + max);
		}

	}

	public static void main(String[] args) {
		Exam8 ex = new Exam8();
	}
}
