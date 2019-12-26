package i_thread;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : " + mainThread.getName());
		
		Thread a = new ThreadA();
		System.out.println("작업 스레드 이름 : "+ a.getName());
		
		Thread b = new ThreadB();
		System.out.println("작업 스레드 이름 : "+ b.getName());
		
		a.start();
		b.start();
	}
}
