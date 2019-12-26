package b_operator;

public class operator2 {
	public operator2() {

		int kor = 80;
		int eng = 90;

		// 국어 60이상이고 영어점수도 60이상이면 합격
		if (kor >= 60 && eng >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		//국어성적이 60이상 이거나 영어성적이 60이상이면 합격
		if(kor>=60 || eng>=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}

	public static void main(String[] args) {
		new operator2();
	}

}
