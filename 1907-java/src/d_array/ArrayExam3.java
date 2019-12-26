package d_array;

import java.util.Scanner;

public class ArrayExam3 {
	int sum;

	public ArrayExam3() {

	}// 생성자

	public void Array() {
		int[][] test = { { 95, 85 }, { 100, 102, 101 } };
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.println(test[i][j]);
			}
		}
	}// Array 메소드

	public void asdas() {
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		int[][] asd = { { 1, 2, 4 }, { 2, 4, 4 }, { 1, 2, 6 } };

		for (int i = 0; i < asd.length; i++) { // 행의 갯수만큼 증가
			if (asd[i][2] % 2 == 0) { // 3번째열이 짝수일때만 합침
				sum += asd[i][2];
				cnt++;
			} // if
		} // for
		if (cnt > 0) {
			avg = (double) sum / cnt;
		}
		System.out.println(avg);

	} // asdas

	// 문자열 1차원 배열에(names) 임의의 성명 5개를 대입
	// 정수형 2차원배열(score) 5명의 국어, 영어 성적을 대입
	public int test2() {
		String[] names = { "lee", "kim", "oh", "shin", "park" };
		int[][] score = { { 90, 20 }, { 100, 60 }, { 95, 45 }, { 85, 80 }, { 79, 84 } };
		int sum = 0;
		double ads = 0;
		// 배열의 첫 번째 학생의 이름과 성적을 출력
		System.out.println("학생이름 : " + names[0]);
		System.out.println("국어 성적 : " + score[0][0]);
		System.out.println("영어 성적 : " + score[0][1]);

		sum = score[0][0] + score[0][1];
		ads = sum / 2.0;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + ads);

		// 3번째 학생의 국어점수를 100으로 수정
		score[2][0] = 100;

		// 3번째 학생의 이름과 국어성적 출력
		System.out.println("3번째 학생이름 : " + names[2]);
		System.out.println("3번째 학생 국어 성적 : " + score[2][0]);

		return 0;
	}

	public void ddd() {
		// 학생명이 shin인 사람의 국어,영어 성적의 합계와 평균 계산
		// 검색어를 입력하여 검색하고 검색을 중지하려면 "quit"를 입력하도록 작성
		String[] names = { "lee", "kim", "oh", "shin", "park" };
		int[][] score = { { 90, 20 }, { 100, 60 }, { 95, 45 }, { 85, 80 }, { 79, 84 } };
		int sum = 0;
		double ads = 0;
		Scanner scan = new Scanner(System.in);
		String zzz = "";
		int dd = -1;

		do {
			System.out.println("종료하려면 quit를 입력하세요");
			System.out.print("검색어를 입력하세요 : ");
			zzz = scan.nextLine();
			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(zzz)) {
					dd = i;
					System.out.println(score[dd][0]);
					System.out.println(score[dd][1]);

					sum = score[dd][0] + score[dd][1];
					ads = sum / 2.0;
					System.out.println("찾는 사람의 배열 위치 : " + dd);
					System.out.println("찾는 사람의 점수 합계 : " + sum);
					System.out.println("찾는 사람의 점수 평균 : " + ads);
					break; //한개의 결과값만 찾기 위해 break를 삽입 아니면 삭제
				}
			}
			if (dd == -1) {
				System.out.println("찾는값이 없습니다.");
			}
		} while (!zzz.equals("quit"));
		System.out.println("종료");
	}

	public static void main(String[] args) {
		ArrayExam3 asd = new ArrayExam3();
		asd.ddd();
	}// 메인
}
