package c_control;

import java.util.Scanner;

public class DoWhileExample {
	public DoWhileExample() {
		Scanner scan = new Scanner(System.in);
		String inputString = "";
		
		System.out.println("�޽����� �Է��ϼ���");
		System.out.println("�����Ϸ��� q�� �Է��ϼ���");
		
		do {
			System.out.println(">>");
			inputString = scan.nextLine();
			System.out.println(inputString);
		}while(!inputString.equals("q"));
		
		System.out.println("���α׷� ����");

	}
}
