package e_class;

public class ArrayParam {

	public ArrayParam() {

	}

	ArrayParam(int[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	int arraySum(int[] s) {
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += s[i];
		}
		return sum;
	}

	// ���޹��� �迭���� �ִ밪�� �̾Ƴ��� ��������
	int maxArray(int[] s) {
		int max = s[0];
		for (int i = 0; i < s.length; i++) {
			if (max < s[i]) {
				max = s[i];
			}
		}
		return max;
	}

	// ���޹��� �迭���� �ּҰ��� �����Ͽ� ��ȯ
	int arrayMin(int[] s) {
		int min = s[0];
		for (int i = 0; i < s.length; i++) {
			if (min > s[i]) {
				min = s[i];
			}
		}
		return min;
	}

	int[] maxMin(int[] s) {
		int[] m = new int[2];
		int[] aaa= {500,20};


		m[0] = arrayMin(aaa);
		m[1] = maxArray(aaa);
		return m;
	}

	public static void main(String[] args) {
		int[] abc = { 600, 2, 3, -55, 15 };
		ArrayParam apl = new ArrayParam(abc);

		int hap = apl.arraySum(abc);
		System.out.println(hap);

		int max = apl.maxArray(abc);
		System.out.println(max);

		int min = apl.arrayMin(abc);
		System.out.println(min);

		int maxMin[] = new int[2];
		maxMin = apl.maxMin(abc);

		System.out.println("�ִ� �� : " + maxMin[1]);
		System.out.println("�ּ� �� : " + maxMin[0]);
	}
}
