package e_class;

/*/
 * 이름, 주소, 연락처 
 * "홍길동","종로구","010-1111-1111"으로 필드를 초기화(irum, address, phone)
 * 이름을 파라미터로 전달하면 전달된 이름만 필드에 적용되는 생성자를 중복 선언하시오.
 * 이름, 주소 , 연락처를 파라미터로 전달하면 모든 값을 필드에 적용하는 생성자를 중복 선언 하시오.
 * main()을 작성하여 위의 요구 조건이 처리되는지를 테스트 하시오.
 */
public class Student {
	String irum;
	String address;
	String phone;

	public Student() {
		this.irum = "홍길동";
		this.address = "종로구";
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
		System.out.println("이름 : " + this.irum);
		System.out.println("주소 : " + this.address);
		System.out.println("전화번호 : " + this.phone);
		System.out.println("=======================");
	}

	public static void main(String[] args) {
		Student stu = new Student();
		stu.prn();
		Student stu2 = new Student("이성배");
		stu2.prn();
		Student stu3 = new Student("나나나", "마포구", "010-7740-9609");
		stu3.prn();

	}

}
