package f_inheri;

public class SupersonicAirplane extends Airplane {
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;

	public int flyMode = NOMAL;
	
	public SupersonicAirplane() {
		//������ �ȿ��� �����ڸ� ȣ���� ���� ù �ٿ� �ۼ��ؾ���.
		super(10);
		System.out.println("����");
	}

	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("�����Ӻ����մϴ�.");
		} else {
			super.fly();
		}
	}

}
