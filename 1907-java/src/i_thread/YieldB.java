package i_thread;

public class YieldB extends Thread{
	boolean stop = false;
	boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("yieldB!!!");
			}else {
				Thread.yield();
			}//if
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}//while
		System.out.println("BÁ¾·á!!");
	}
}
