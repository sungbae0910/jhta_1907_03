package f_inheri;

/*
 * Mycar.java
 * KumhoTire.java
 * HankookTire.java
 * Tire.java
 */
public class MyCar {
	KumhoTire[] front = new KumhoTire[2];
	HankookTire[] back = new HankookTire[2];

	Tire[] tire = new Tire[4];

	public static void main(String[] args) {
		MyCar m = new MyCar();
		m.tire[0] = new HankookTire();
		m.back[0] = new HankookTire();

		m.tire[0].run();

		// ��ü�� �ѱ�Ÿ�̾�� ������� ��� ��
		Tire h1 = new HankookTire();
		if (h1 instanceof KumhoTire) {
			System.out.println("�ѱ�Ÿ�̾�� ��������");
		} else {
			System.out.println("�ѱ�Ÿ�̾ �ƴϿ���");
		}
	}

}
