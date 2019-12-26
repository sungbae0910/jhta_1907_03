package g_exception;

public class ExceptionExam {
	public static void main(String[] args) {
		String data = null;

		// NullPointerException
		try {
			System.out.println(data.toString());
			System.out.println("Dddddd");
		} catch (NullPointerException e) {
			System.out.println("data������ �� ����");
		} finally {
			System.out.println("�Ϳ�");
		}

		
		// ArrayIndexOutOfBoundsException
		int[] s = { 1, 2, 3 };
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println(s[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭÷�ڸ� ���");
		}

		
		// NumberFormatException
		try {
			data = "123";
			int su = Integer.parseInt(data);
			System.out.println("����");
		} catch (NumberFormatException e) {
			System.out.println("int��ȯ ����");
			e.printStackTrace();
		}

		
		// ClassCastException(����ȯ ����)
		try {
			Car mycar = new Car();
			SportsCar c = (SportsCar) mycar;
		} catch (ClassCastException e) {
			System.out.println("����ȯ ��������");
		}

	}
}
