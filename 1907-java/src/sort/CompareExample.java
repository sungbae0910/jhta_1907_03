package sort;

import java.util.Objects;

public class CompareExample {
	
	public static void main(String[] args) {
		Student s1 = new Student(1);
		Student s2 = new Student(2);
		Student s3 = new Student(3);
		
		
		int result = Objects.compare(s1, s2, new StudentCompareator(1));
		System.out.println(result);
	}
}
