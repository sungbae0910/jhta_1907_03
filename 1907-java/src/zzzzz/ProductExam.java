package zzzzz;

public class ProductExam {
	public static void main(String[] args) {
		
		Product pt = new TV();
		Product pt2 = new Radio();
		Product pt3 = new Video();
		
		//2. 자식 클래스에서는 getProductName()을 Override하여 자신의 이름이 출력되도록 조치하시오
		System.out.println(pt.getProductName());
		System.out.println(pt2.getProductName());
		System.out.println(pt3.getProductName());

		//3.Radio 클래스와 Video 클래스는 형변환이 안됨을 증명하는 코드를 작성 하시오.
		System.out.println(pt2 instanceof Video);
		
		//3.2 Radio, Video, TV 클래스는 Product클래스로 형변환이 가능한지 증명
		System.out.println(pt instanceof Product);
		System.out.println(pt2 instanceof Product);
		System.out.println(pt3 instanceof Product);
		
		if(pt instanceof Product) {
			System.out.println("형변환 성공");
		}else {
			System.out.println("실패");
		}
		
		if(pt instanceof Video) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		if(pt2 instanceof Video) {
			System.out.println("오오!!");
		}else {
			System.out.println("시ㅣㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ패");
		}
		
		try {
			pt2 = (Radio)pt3;
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("ㅇㅇㅇㅇ");
		}
		
		try {
			pt2 = new Radio();
			System.out.println("오오!!");
		} catch (Exception e) {
			System.out.println("실팽ㅇㅇㅇㅇ");
		}
	}
}
