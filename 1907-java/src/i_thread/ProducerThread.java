package i_thread;

public class ProducerThread extends Thread{
	private DataBox databox;
	
	public ProducerThread(DataBox databox) {
		this.databox=databox;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			String data = "Data-" + i;
			databox.setData(data);
		}
	}
}
