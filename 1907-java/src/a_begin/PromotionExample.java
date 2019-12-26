package a_begin;

//class 구성요소 변수,메소드 2가지
public class PromotionExample {
	
	PromotionExample() {
		byte bytevalue = 10;
		int intvalue = bytevalue;
		System.out.println(intvalue);
		
		char charvalue = '가';
		intvalue = charvalue;
		System.out.println(intvalue);
		
		intvalue = 500;
		long longvalue = intvalue;
		System.out.println(longvalue);
		
		intvalue = 200;
		double doublevalue = intvalue;
		System.out.println(doublevalue);
		
	}

	//static이 있는 것이 가장 먼저 메모리에 올라감
	public static void main(String[] args) {
		 new PromotionExample(); 
	}

}
