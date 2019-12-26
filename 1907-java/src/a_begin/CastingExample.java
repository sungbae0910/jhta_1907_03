package a_begin;

public class CastingExample {

	public CastingExample() {
		int intvalue = 44032;
		char charvalue = (char) intvalue;
		System.out.println(intvalue + " --> " + charvalue);
		
		long longvalue = 500;
		intvalue = (int)longvalue;
		System.out.println(intvalue);
		
		double d2 = 10/(double)3;
		System.out.println(d2);
	}

	public static void main(String[] args) {
		new CastingExample();
	}
}
