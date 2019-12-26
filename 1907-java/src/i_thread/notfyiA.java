package i_thread;

public class notfyiA extends Thread{
	private WorkObject workobject;
	
	public notfyiA(WorkObject workobject){
		this.workobject=workobject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workobject.methodA();
		}
	}
}
