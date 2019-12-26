package i_thread;

public class CalcThread extends Thread{

	//이름을 넘겨받아 이름정의
	public CalcThread(String name){
		this.setName(name);
	}
	
	@Override
	public void run() {
		for(int i =0; i<2000000000; i++) {
			
		}
		System.out.println(this.getName());
	}
}
