package i_thread;

public class ConsumerThread extends Thread{
	private DataBox databox;
	
	public ConsumerThread(DataBox databox) {
		this.databox=databox;
	}
	
	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			String Data = databox.getData();
		}
	}

	
}
