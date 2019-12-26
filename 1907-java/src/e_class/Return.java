package e_class;

public class Return {

	public static void main(String[] args) {
		Exam1 ee = new Exam1();
		
		int sum = ee.sum(100, 50);
		System.out.println(sum);
		
		int sum2 = ee.sum2(1, 100);
		System.out.println(sum2);
		
		double sum3 = ee.sum3(10, 10);
		System.out.println("사각형의 넓이 :" + sum3);
		
		ee.gugudan(5);
		String gugudan = ee.gugu(10);
		System.out.println("구구단");
		System.out.println(gugudan);
	}
}
