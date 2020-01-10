package z_exam;

public class SubThread implements Runnable{

	
	@Override
	public void run() {
		for(int i=0; i<=100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
