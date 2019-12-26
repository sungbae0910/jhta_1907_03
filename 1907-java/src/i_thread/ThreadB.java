package i_thread;

public class ThreadB extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<500; i++) {
			System.out.println(this.getName()+"ÀÌ Ãâ·Â");
		}
	}
}
