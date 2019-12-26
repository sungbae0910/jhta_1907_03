package zzzzz;

public class Student {
	public int sno;
	public String name;
	public int score;

	Student(int sno, String name, int score) {
		this.sno = sno;
		this.name = name;
		this.score = score;
	}

	Student(int sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return sno + "-" + name + "-" + score;
	}
}
