package d_array;

import java.util.Scanner;

public class ArrayExam4 {
	Scanner scan = new Scanner(System.in);
	int i;
	String[] names = new String[10];
	int[][] jum = new int[10][2];
	int cnt = 0;

	// 무한 루프를 돌면서 메뉴를 출력
	public ArrayExam4() {
		String a = "";

		do {
			System.out.println("--------------------------------");
			System.out.println("1. 성적입력 | 2.성적수정 | 3. 성적 조회  ");
			System.out.println("------종료하려면 q를 입력하세요!!------");
			System.out.println("--------------------------------");
			System.out.print("> ");
			a = scan.nextLine();

			if (a.equals("1")) {
				input();
			} else if (a.equals("2")) {
				modify();
			} else if (a.equals("3")) {
				search();
			}
		} while (!a.equals("q"));

		scan.close();
		System.out.println("종료되었습니다");
	}

	// 성적 정보를 입력할 때
	public void input() {
		String name = "";
		int kor = 0;
		int eng = 0;
		int sum = 0;
		double avg = 0;

		System.out.print("이름을 입력하세요 : ");
		name = scan.nextLine();
		System.out.print("국어 : ");
		kor = scan.nextInt();
		System.out.print("영어 : ");
		eng = scan.nextInt();
		scan.nextLine();

		sum = kor + eng;
		avg = sum / 2.0;
		System.out.println("이름 : " + name);
		System.out.println("합계 : " + kor);
		System.out.println("평균 : " + eng);

		if (cnt < 10) {
			names[cnt] = name;
			jum[cnt][0] = kor;
			jum[cnt][1] = eng;
			cnt++;
		} else {
			System.out.println("공간이 부족합니다.");
		}

	}

	// 학생의 정보를 수정
	public void modify() {
		String sh = "";

		System.out.print("이름을 입력하세요 : ");
		sh = scan.nextLine();

		for (int i = 0; i < cnt; i++) {
			if (names[i].equals(sh)) {
				System.out.println("이름 : " + names[i]);
				System.out.println("국어 성적 : " + jum[i][0]);
				System.out.println("영어 성적 : " + jum[i][1]);
				
				System.out.println("수정할 내용");
				System.out.print("이름 : ");
				names[i] = scan.nextLine();
				System.out.print("국어 : ");
				jum[i][0] = scan.nextInt();
				System.out.print("영어 : ");
				jum[i][1] = scan.nextInt();
				scan.nextLine();
			}else {
				System.out.println("찾으시는 값이 없습니다.");
			}
		}//for

	}//modify

	// 학생 성적 정보를 조회 및 출력
	public void search() {
		String sh = "";
		
		int sum = 0;
		double avg = 0;

		System.out.print("검색어를 입력하세요 : ");
		sh = scan.nextLine();

		for (int i = 0; i < cnt; i++) {
			if (names[i].equals(sh)) {
				System.out.println("이름 : " + names[i]);
				System.out.println("국어 성적 : " + jum[i][0]);
				System.out.println("영어 성적 : " + jum[i][1]);
				System.out.println("성적 합계 : " + (jum[i][0] + jum[i][1]));
				System.out.println("성적 평균 : " + (jum[i][0] + jum[i][1]) / 2.0);
			} else if (!names[i].equals(sh)) {
				System.out.println("찾으시는 이름이 없습니다.");
			}
		}
	}

	public static void main(String[] args) {
		ArrayExam4 asd = new ArrayExam4();
	}

}
