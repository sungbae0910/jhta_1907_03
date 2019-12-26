package c_control;

import java.util.Scanner;

/*/
 * 모든 처리는 생성자를 사용하여 해결
 * 성명, 주소, 연락처가 문자열로 발생
 * 성적이 정수형으로 발생하여 각각 kor, eng, mat에 저장
 * if else if문을 사용하고 평균값을 사용하여 학점을 구해서 문자형 변수 grade에 저장
 */
public class Ex1 {

	public Ex1() {
		String name = "lee sung bae";
		String address = "seoul mapo";
		String phone = "010-7740-9609";
		char grade = ' ';
		Scanner scan = new Scanner(System.in);

		System.out.println("성적을 입력해주세요");
		System.out.print("국어 : ");
		int kor = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.print("수학 : ");
		int mat = scan.nextInt();

		int tot = kor + eng + mat;
		double avg = tot / 3.0;


		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("================");
		System.out.println("처리결과");
		System.out.println("================");
		System.out.println("성명 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("연락처 : " + phone);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println("학점 : " + grade);
		
		scan.close();

	}

	public static void main(String[] args) {
//		Ex1 eee = new Ex1();

	}

}
