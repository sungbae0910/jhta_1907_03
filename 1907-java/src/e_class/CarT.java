package e_class;

public class CarT {
	int gas;

	public void setGas(int gas) {
		this.gas = gas;
	}

	public boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("������ �����ϴ�.");
			return false;
		}
		System.out.println("������ �ֽ��ϴ�.");
		return true;
	}

	public void run() {
		boolean dd = true;
		while (dd) {
			if (gas > 0) {
				System.out.println("���� �޸��ϴ�. (���� �ܷ� : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("������ �����մϴ�. (���� �ܷ� : " + gas + ")");
				dd = false;
			}
		}
	}
}
