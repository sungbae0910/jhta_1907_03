package i_thread;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("���α׷� ���� ������ �̸� : " + mainThread.getName());
		
		Thread a = new ThreadA();
		System.out.println("�۾� ������ �̸� : "+ a.getName());
		
		Thread b = new ThreadB();
		System.out.println("�۾� ������ �̸� : "+ b.getName());
		
		a.start();
		b.start();
	}
}
