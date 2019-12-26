package c_control;

/*
 * 1~1000까지의 수중 5의 배수 이거나 7의 배수 출력
 */
public class ForExam6 {
	int i = 0;
	int sum = 0;

	public ForExam6() {
		for (i = 1; i <= 1000; i++) {
			if (i % 5 == 0) {
				System.out.println("5의배수 " + i);
			} else if (i % 7 == 0) {
				System.out.println("7의배수 " + i);
			}
		}
	}
}
