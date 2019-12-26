package i_thread;

public class YieldA extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("yieldA......");
			}else {
				Thread.yield();
			}//if
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}//while
		System.out.println("AÁ¾·á");
	}
}
