package c_control;

/*
 * 1~1000������ �հ谡 5000�� �Ѵ� ������ ���� ����Ͻÿ�.
 */
public class ForExam5 {
	int sum = 0;
	int num = 0;

	public ForExam5() {
		for (int i = 1; i<= 1000; i++) {
			num += i;
			if (num >= 5000) {
				System.out.println("�Ѵ¼����� �� : " + num);
				break;
			}
		} // for
	}// Ŭ�����ǳ�
}
