package c_control;

/*
 * 1~1000������ ���� 5�� ��� �̰ų� 7�� ��� ���
 */
public class ForExam6 {
	int i = 0;
	int sum = 0;

	public ForExam6() {
		for (i = 1; i <= 1000; i++) {
			if (i % 5 == 0) {
				System.out.println("5�ǹ�� " + i);
			} else if (i % 7 == 0) {
				System.out.println("7�ǹ�� " + i);
			}
		}
	}
}
