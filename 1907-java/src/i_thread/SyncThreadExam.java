package i_thread;

public class SyncThreadExam {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User1 u1 = new User1();
		u1.setCalculator(cal);
		u1.start();
		
		User2 u2 = new User2();
		u2.setCal(cal);
		u2.start();
	}
	
}
