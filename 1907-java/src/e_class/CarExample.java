package e_class;

import java.util.Scanner;

public class CarExample {

	public static void main(String[] args) {
		int aa = 1;
		int gg = 0;;
		Scanner scan = new Scanner(System.in);
		while (aa == 1) {
			CarT car = new CarT();
			car.setGas(gg);

			if (car.isLeftGas()) {
				System.out.println("����մϴ�.");
				car.run();
			}

			boolean ad = car.isLeftGas();
			if (ad) {
				System.out.println("������ ���");
				System.out.println("���� ���� : " + car.gas);
			} else {
				System.out.println("������ �־��ּ���");
				System.out.println("���� ���� : " + car.gas);
			}

			System.out.println("������ �����Ͻðڽ��ϱ� ? ");
			System.out.println("1. ���� | 2. ���� ");
			aa = scan.nextInt();
			if (aa == 1) {
				System.out.println("�󸶳� ��õ�Ͻðڽ��ϱ�? : ");
				gg = scan.nextInt();
			} else if (aa == 2) {
				aa = 2;
				System.out.println("����Ǿ����ϴ�.");
			}
		}
	}
}
