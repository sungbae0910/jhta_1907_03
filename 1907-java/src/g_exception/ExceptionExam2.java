package g_exception;

public class ExceptionExam2 {

	public ExceptionExam2() throws Exception {
		this.method();
	}

	public void method() throws Exception {
		int su = 100;
		int su2 = 10;
		System.out.println(su / su2);
		throw new Exception("酔嬢っっっっっっっ");
	}

	public static void main(String[] args) {

		try {
			new ExceptionExam2();
		} catch (Exception e) {
			System.out.println("神神!!");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
