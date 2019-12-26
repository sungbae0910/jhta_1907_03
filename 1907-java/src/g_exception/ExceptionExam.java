package g_exception;

public class ExceptionExam {
	public static void main(String[] args) {
		String data = null;

		// NullPointerException
		try {
			System.out.println(data.toString());
			System.out.println("Dddddd");
		} catch (NullPointerException e) {
			System.out.println("data변수에 값 없음");
		} finally {
			System.out.println("와웅");
		}

		
		// ArrayIndexOutOfBoundsException
		int[] s = { 1, 2, 3 };
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println(s[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열첨자를 벗어남");
		}

		
		// NumberFormatException
		try {
			data = "123";
			int su = Integer.parseInt(data);
			System.out.println("오오");
		} catch (NumberFormatException e) {
			System.out.println("int변환 실패");
			e.printStackTrace();
		}

		
		// ClassCastException(형변환 오류)
		try {
			Car mycar = new Car();
			SportsCar c = (SportsCar) mycar;
		} catch (ClassCastException e) {
			System.out.println("형변환 오류오오");
		}

	}
}
