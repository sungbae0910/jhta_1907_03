package f_inheri;

public class Airplane {
	public Airplane() {
		System.out.println("�Ϲݺ����");
	}

	public Airplane(int tire) {
		System.out.println("Ÿ�̾"+tire+"���� �Ϲݺ����");
	}
	
	public void land() {
		System.out.println("�̷��մϴ�.");
	}

	public void fly() {
		System.out.println("�Ϲݺ����մϴ�.");
	}

	public void takeoff() {
		System.out.println("�̷��մϴ�.");
	}
}
