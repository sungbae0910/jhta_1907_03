package f_inheri;

public class HankookTire implements Tire{
	
	//implements를 하면 추상메소드를 반드시 재정의해야함
	@Override
	public void run() {
		System.out.println("한국 타이어가 굴러갑니다");
	}

}
