package c_control;

import java.util.Scanner;

public class SumExample {
	Scanner scan = new Scanner(System.in); // 스캐너 선언
	int sum = 0;
	int i = 0;
	int a = 1;

	public SumExample() {
		System.out.print("합계를 구할 수를 입력하세요 : ");
		i = scan.nextInt(); 	// scanner를 이용해 구할 값을 입력받음

		while (a <= i) {	 // a가 입력한 수보다 작거나 같을때까지 돌아감
			sum += a;
			a++;
		}
		System.out.println("1~" + i + "까지의 합 : " + sum);
	}
}
