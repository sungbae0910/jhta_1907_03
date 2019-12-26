package c_control;

import java.util.Scanner;

public class DoWhileExample {
	public DoWhileExample() {
		Scanner scan = new Scanner(System.in);
		String inputString = "";
		
		System.out.println("메시지를 입력하세요");
		System.out.println("종료하려면 q를 입력하세요");
		
		do {
			System.out.println(">>");
			inputString = scan.nextLine();
			System.out.println(inputString);
		}while(!inputString.equals("q"));
		
		System.out.println("프로그램 종료");

	}
}
