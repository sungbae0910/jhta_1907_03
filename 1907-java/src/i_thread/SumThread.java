package i_thread;

public class SumThread extends Thread {
	private int sum;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void run() {
		for(int i = 1; i<=100; i++) {
			sum+=i;
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
}
