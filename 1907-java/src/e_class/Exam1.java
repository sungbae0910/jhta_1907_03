package e_class;

/*
 * 1. �� ������ ���� �޾� �հ踦 ��ȯ�ϴ� �޼��� ����(sum)
 * 2. �� ����(x, y) �� ���� �޾� x~y������ �հ踦 ���Ͽ� ����(sum2)
 * 3. ����, ���ΰ��� �Ǽ������� ���޹޾� �簢���� ���̸� ����Ͽ� ����(sum3)
 * 4. ������ ���� ���� �޾� �������� �ϳ��� ���ڿ��� ����� ����(gugudan)
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
