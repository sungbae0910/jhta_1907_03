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
				System.out.println("출발합니다.");
				car.run();
			}

			boolean ad = car.isLeftGas();
			if (ad) {
				System.out.println("가스가 충분");
				System.out.println("남은 가스 : " + car.gas);
			} else {
				System.out.println("가스를 넣어주세요");
				System.out.println("남은 가스 : " + car.gas);
			}

			System.out.println("가스를 충전하시겠습니까 ? ");
			System.out.println("1. 충전 | 2. 종료 ");
			aa = scan.nextInt();
			if (aa == 1) {
				System.out.println("얼마나 충천하시겠습니까? : ");
				gg = scan.nextInt();
			} else if (aa == 2) {
				aa = 2;
				System.out.println("종료되었습니다.");
			}
		}
	}
}
