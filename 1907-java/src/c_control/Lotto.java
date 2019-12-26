package c_control;

public class Lotto {
	int i[] = new int[6];
	int a;

	void process() {
		boolean value = false; // 중복되지 않음
		for (a = 0; a < 6;) {
			// this를 사용한다면 멤버변수를 나타냄
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
