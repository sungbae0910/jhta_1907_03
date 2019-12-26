package e_class;

public class Car {
	String mm = "³ë³ë";
	String color;
	int maxSpeed;

	public Car() {

	}

	public Car(String model) {
		
	}

	public Car(String model, String color, int maxSpeed) {
		this.mm = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public void Speedup() {
		this.maxSpeed += 10;
	}
	
	public void Speeddown() {
		this.maxSpeed -= 10;
	}
	

}
