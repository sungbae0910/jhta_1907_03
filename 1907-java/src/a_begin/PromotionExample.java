package a_begin;

//class ������� ����,�޼ҵ� 2����
public class PromotionExample {
	
	PromotionExample() {
		byte bytevalue = 10;
		int intvalue = bytevalue;
		System.out.println(intvalue);
		
		char charvalue = '��';
		intvalue = charvalue;
		System.out.println(intvalue);
		
		intvalue = 500;
		long longvalue = intvalue;
		System.out.println(longvalue);
		
		intvalue = 200;
		double doublevalue = intvalue;
		System.out.println(doublevalue);
		
	}

	//static�� �ִ� ���� ���� ���� �޸𸮿� �ö�
	public static void main(String[] args) {
		 new PromotionExample(); 
	}

}
