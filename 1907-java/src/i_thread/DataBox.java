package i_thread;

public class DataBox {
	private String data;

	public synchronized String getData() {
		if(this.data==null) {
			try {
				wait();
			}catch (Exception e) {}
		}
		String returnValue = data;
		System.out.println("ConsummerThread가 읽은 데이터 : "+returnValue);
		data=null;
		notify();
		return returnValue;
	}

	public synchronized void setData(String data) {
		if(this.data !=null) {
			try {
				wait();
			} catch (Exception e) {}
		}
		this.data=data;
		System.out.println("ProducerThread가 생성한 데이터 : "+data);
		notify();
	}

	
}
