package e_class;

public class KoreanExample {

	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = new Car("aa");
		Car car3 = new Car("leesungbae","blue",100);
		
		
		car.maxSpeed = 200;
		System.out.println(car3.color+" "+car3.maxSpeed+" "+car3.mm);;
		System.out.println(car2.mm);
		System.out.println("car.color : "+car.color);
		
		System.out.println("car3 spec");
		System.out.println("car3.model : "+car3.mm );
		System.out.println("car3.color : "+car3.color);
		System.out.println("car3.maxSpeed : "+car3.maxSpeed);
		
		car3.Speedup();
		System.out.println("car3.maxSpeed : " + car3.maxSpeed );
	}
}
