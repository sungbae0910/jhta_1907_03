package i_thread;

public class ThreadA extends Thread {
	public ThreadA() {
		// setName을 통해 Thread의 이름을 정의해줄 수 있음
		setName("우오오");
	}

	// Thread를 상속받아 run()메소드를 재정의함
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(this.getName() + "가 출력한 내용");
		}
	}
}
