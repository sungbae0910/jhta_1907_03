package z_exam;

public class MainThread {
	
	public static void main(String[] args) {
		System.out.println("메인 스레드 시작");
		
		SubThread st = new SubThread();
		Thread t = new Thread(st);
		
		try {
			t.start();
			t.join(); // SubThread스레드가 종료되기전까지 MainThred를 종료시키지 않음
		} catch (Exception e) {}
		System.out.println("메인스레드 종료");
	}
}

