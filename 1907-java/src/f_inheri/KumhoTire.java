package f_inheri;

public class KumhoTire implements Tire{
	
	//implements를 하면 추상메소드를 반드시 재정의해야함
	@Override
	public void run() {
		System.out.println("금호타이어가 굴러갑니다");
	}// run
	
}
