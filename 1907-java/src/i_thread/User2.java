package i_thread;

public class User2 extends Thread{
	private Calculator cal;
	
	public void setCal(Calculator cal) {
		this.cal=cal;
		this.setName("User2");
	}
	
	@Override
	public void run() {
		cal.setMemory(50);
	}

}
