package f_inheri;

public class Bank {
	static Acnt[] ac;
	static int count; // °èÁÂ¼ö

	static {
		ac = new Acnt[100];
		Acnt a = new Acnt("lee", "11-11", 5000);
		ac[0] = a;

		a = new Acnt("kim", "22-22", 10000);
		ac[1] = a;

		a = new Acnt("hong", "33-33", 1000000);
		ac[2] = a;

		count = 3;
	}
}
