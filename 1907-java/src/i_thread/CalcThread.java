package i_thread;

public class CalcThread extends Thread{

	//�̸��� �Ѱܹ޾� �̸�����
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
