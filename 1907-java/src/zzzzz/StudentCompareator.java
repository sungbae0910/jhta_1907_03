package zzzzz;

import java.util.Comparator;

public class StudentCompareator implements Comparator<Student>{
	int s;
	int a;
	
	public StudentCompareator(int s) {
		this.s=s;
	}
	
	@Override
	public int compare(Student s1, Student s2) {
		if(s==1) {
			a=s1.sno-s2.sno;
		}else if(s==2) {
			a=s1.score-s2.score;
		}
		return a;
	}
	
	
/*	if(s==1) {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.sno - s2.sno;
		}
	}else if(s==2) {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.score - s2.score;
		}
	}
	*/

	

	
	/*(s1.name).compareTo(s2.name);*/
	
/*	public class StudentCompareator implements Comparator{
		
		@Override
		public int compare(Student s1, Student s2) {
			Student s1 = (Student)s1;
			Student s2 = (Student)s2;
			return (s1.name).compareTo(s2.name);
		}*/

}
