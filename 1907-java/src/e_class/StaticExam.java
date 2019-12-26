package e_class;

public class StaticExam {

	public static void main(String[] args) {
		Account f = new Account();
		f.prn();
		f.withdraw(500);
		
		
		Account m = new Account();
		m.prn();
		m.withdraw(1000);
		
		Account c1 = new Account();
		c1.prn();
		c1.deposit(5000);
		c1.prn();
		
		
	}

}
