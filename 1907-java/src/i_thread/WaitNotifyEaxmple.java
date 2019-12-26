package i_thread;

public class WaitNotifyEaxmple {
	public static void main(String[] args) {
		WorkObject work = new WorkObject();
		
		notfyiA asd = new notfyiA(work);
		notifyB bs = new notifyB(work);
		
		asd.start();
		bs.start();
	}
}
