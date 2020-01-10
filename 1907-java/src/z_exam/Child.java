package z_exam;

public class Child extends MyClass{

	public MyClass method1(MyClass mc) {
		MyClass m = new MyClass();
		return m;
	}
	
	public Child method2(Child c) {
		Child myC = new Child();
		return myC;
	}
	
	public static void main(String[] args) {
		MyClass mc = new Child();
		
		Child c = (Child)mc;
		c.method1(mc);
		c.method2(c);
		
		Child c2 = new Child();
		c2.method1(mc);
		c2.method1(c);
		
		//c2.method2(mc);
		c2.method2(c);
	}


}
