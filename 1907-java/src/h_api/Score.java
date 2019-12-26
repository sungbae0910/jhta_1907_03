package h_api;

public class Score implements Comparable<Score> {
	int kor;
	
	public Score(int kor) {
		this.kor = kor;
	}
	
	public Score() {
		
	}
	
	@Override
	public int compareTo(Score a) {
		return this.kor-a.kor;
	}

}
