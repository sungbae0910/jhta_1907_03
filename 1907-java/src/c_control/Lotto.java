package c_control;

public class Lotto {
	int i[] = new int[6];
	int a;

	void process() {
		boolean value = false; // �ߺ����� ����
		for (a = 0; a < 6;) {
			// this�� ����Ѵٸ� ��������� ��Ÿ��
			this.i[a] = (int) (Math.random() * 45) + 1;

			for (int q = 0; q < a; q++) {
				if (i[q] == i[a]) {
					value = true;
				}
			}

			if (!value) {

				a++;
			}
		}

	}

	public void prn() {
		for (a = 0; a < 6; a++) {
			System.out.print(i[a] + " ");
		}
		
	}

	public static void main(String[] args) {
		Lotto start = new Lotto();
		start.process();
		start.prn();

	}

}
