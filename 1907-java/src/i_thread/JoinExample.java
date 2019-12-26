package i_thread;

public class JoinExample {
	public static void main(String[] args) {
		SumThread abc = new SumThread();
		abc.start();
		
		try {
			abc.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("1~100까지의 합 : " + abc.getSum());
	}
}
