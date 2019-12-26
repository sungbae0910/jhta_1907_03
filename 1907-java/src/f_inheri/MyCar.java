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

		// 객체가 한국타이어로 만들어진 경우 참
		Tire h1 = new HankookTire();
		if (h1 instanceof KumhoTire) {
			System.out.println("한국타이어로 만들었어요");
		} else {
			System.out.println("한국타이어가 아니예요");
		}
	}

}
