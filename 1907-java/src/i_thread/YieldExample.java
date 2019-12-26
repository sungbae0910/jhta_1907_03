package i_thread;

public class YieldExample {
	public static void main(String[] args) {
		YieldA abc = new YieldA();
		YieldB bc = new YieldB();
		
		abc.start();
		bc.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		abc.work = false;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		abc.work = true;

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		abc.stop = true;
		bc.stop = true;

	}
}
