package f_inheri;

public class SupersonicAirplane extends Airplane {
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;

	public int flyMode = NOMAL;
	
	public SupersonicAirplane() {
		//생성자 안에서 생성자를 호출할 때는 첫 줄에 작성해야함.
		super(10);
		System.out.println("먼저");
	}

	@Override
	public void fly() {
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		} else {
			super.fly();
		}
	}

}
