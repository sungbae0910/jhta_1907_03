/*
 * 2019.11.27(수)
 * 연산자 계산
*/
package b_operator;

public class operator {

	public operator() {
		// 나머지 연산
		System.out.println(" 12 % 5 = " + (12 % 5));

		int n = 123;

		String r = (n % 2 == 0) ? "짝수" : "홀수";
		System.out.println(r);

		// 증감 연산자
		int a = 10;
		int b = 10;
		a++;
		++b;
		System.out.println(a + "," + b);

		int c = a++;
		int d = ++b;
		System.out.println(c + "," + d);

		// String 타입 비교
		String name = "lee";
		String irum = "lee";

		String irum2 = new String("lee");

		System.out.println(name == irum);
		System.out.println(name == irum2);
		System.out.println(name.equals(irum2));
	}

	public static void main(String[] args) {
		new operator();
	}
}
