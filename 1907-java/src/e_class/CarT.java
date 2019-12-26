package e_class;

public class CarT {
	int gas;

	public void setGas(int gas) {
		this.gas = gas;
	}

	public boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("가스가 없습니다.");
			return false;
		}
		System.out.println("가스가 있습니다.");
		return true;
	}

	public void run() {
		boolean dd = true;
		while (dd) {
			if (gas > 0) {
				System.out.println("차가 달립니다. (가스 잔량 : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("가스가 부족합니다. (가스 잔량 : " + gas + ")");
				dd = false;
			}
		}
	}
}
