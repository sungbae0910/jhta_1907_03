package e_class;

/*/
 * �̸�, �ּ�, ����ó 
 * "ȫ�浿","���α�","010-1111-1111"���� �ʵ带 �ʱ�ȭ(irum, address, phone)
 * �̸��� �Ķ���ͷ� �����ϸ� ���޵� �̸��� �ʵ忡 ����Ǵ� �����ڸ� �ߺ� �����Ͻÿ�.
 * �̸�, �ּ� , ����ó�� �Ķ���ͷ� �����ϸ� ��� ���� �ʵ忡 �����ϴ� �����ڸ� �ߺ� ���� �Ͻÿ�.
 * main()�� �ۼ��Ͽ� ���� �䱸 ������ ó���Ǵ����� �׽�Ʈ �Ͻÿ�.
 */
public class Student {
	String irum;
	String address;
	String phone;

	public Student() {
		this.irum = "ȫ�浿";
		this.address = "���α�";
		this.phone = "010-1111-1111";
	}

	public Student(String irum) {
		this.irum = irum;
		this.address = "zzz";
	}
	

	public Student(String irum, String address, String phone) {
		this.irum = irum;
		this.address = address;
		this.phone = phone;
	}
	
	void prn() {
		System.out.println("�̸� : " + this.irum);
		System.out.println("�ּ� : " + this.address);
		System.out.println("��ȭ��ȣ : " + this.phone);
		System.out.println("=======================");
	}

	public static void main(String[] args) {
		Student stu = new Student();
		stu.prn();
		Student stu2 = new Student("�̼���");
		stu2.prn();
		Student stu3 = new Student("������", "������", "010-7740-9609");
		stu3.prn();

	}

}
