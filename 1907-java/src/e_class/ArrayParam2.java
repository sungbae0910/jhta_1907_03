package e_class;

public class ArrayParam2 {

	
	void input(Student s) {
		s.prn();
	
	}
	
	void input(Car c) {
		System.out.println(c.color);
		System.out.println(c.mm);
		System.out.println(c.maxSpeed);
		
		c.Speedup();
		System.out.println(c.maxSpeed);
		c.Speedup();
		System.out.println(c.maxSpeed);
	}
	
	
	
	public static void main(String[] args) {
		ArrayParam2 ap2 = new ArrayParam2();
		
		Student std = new Student();
		ap2.input(std);
		
		Car c = new Car();
		ap2.input(c);

	}
}