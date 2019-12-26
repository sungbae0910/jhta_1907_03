package c_control;

/*
 * 1~1000까지의 합계가 5000이 넘는 순간의 수를 출력하시오.
 */
public class ForExam5 {
	int sum = 0;
	int num = 0;

	public ForExam5() {
		for (int i = 1; i<= 1000; i++) {
			num += i;
			if (num >= 5000) {
				System.out.println("넘는순간의 합 : " + num);
				break;
			}
		} // for
	}// 클래스의끝
}
