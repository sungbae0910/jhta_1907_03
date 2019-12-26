package i_thread;

public class notifyB extends Thread{
	private WorkObject workobject;
	
	public notifyB(WorkObject workobject) {
		this.workobject=workobject;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workobject.methodB();
		}
	}
}
