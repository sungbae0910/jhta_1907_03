package b_operator;

public class operator2 {
	public operator2() {

		int kor = 80;
		int eng = 90;

		// ���� 60�̻��̰� ���������� 60�̻��̸� �հ�
		if (kor >= 60 && eng >= 60) {
			System.out.println("�հ�");
		} else {
			System.out.println("���հ�");
		}
		
		//������� 60�̻� �̰ų� ������� 60�̻��̸� �հ�
		if(kor>=60 || eng>=60) {
			System.out.println("�հ�");
		}else {
			System.out.println("���հ�");
		}
	}

	public static void main(String[] args) {
		new operator2();
	}

}
