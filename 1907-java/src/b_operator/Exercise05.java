package b_operator;

import java.util.Scanner;

public class Exercise05 {

	public Exercise05() {
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("���ڸ� �Է����ּ��� : ");
		int a = scan.nextInt();
		int b = a/100;
		int c = b*100;
		
		System.out.println("����� : "+c);
		scan.close();
	}
	
	public static void main(String[] args) {
		new Exercise05();
	}
}
