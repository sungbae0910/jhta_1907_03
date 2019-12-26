package sort;

import java.util.Arrays;
import java.util.Objects;

public class SortExam {

	// 숫자형 배열값을 오름차순으로 정렬
	public void memberSort() {
		int[] n = { 1, 10, 11, 20, 3, 2, 44, 15, 12418 };
		int temp = 0;

		System.out.println("정렬전 : ");
		System.out.println(Arrays.toString(n));

		for (int i = 0; i < n.length - 1; i++) { // 기준
			for (int j = i + 1; j < n.length; j++) { // 비교
				if (n[i] > n[j]) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if
			} // j
		} // i

		System.out.println("정렬 후 : ");
		System.out.println(Arrays.toString(n));

	}

	// 문자형 배열값을 오름차순으로 정렬
	public void strSort() {
		String[] n = new String[] { "a", "c", "g", "b", "y", "e", "z", "n", "k", "123", "오오" };
		String temp = "";

		for (int i = 0; i < n.length - 1; i++) {
			for (int j = i + 1; j < n.length; j++) {
				if (n[i].compareTo(n[j]) > 0) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(n));

	}
	
	public void objSort() {
		Student[] std = new Student[] {
				new Student(10,"lee",60), 
				new Student(13,"oh",80), 
				new Student(25,"shin",30),
				new Student(2,"kim",70), 
				new Student(16,"park",100)
		};
		
		Student temp = null;
		
		for(int i=0; i<std.length; i++) {
			for(int j=i+1; j<std.length; j++) {
				int result = Objects.compare(std[i], std[j], new StudentCompareator(1));
				if(result>0) {
					temp = std[i];
					std[i] = std[j];
					std[j] = temp;
				}
			}
		}
		
		for(int i=0; i<std.length; i++) {
			System.out.println(std[i]);
		}
		
	}

	public static void main(String[] args) {
		SortExam se = new SortExam();

		se.objSort();
	}

}
