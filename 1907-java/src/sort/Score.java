package sort;

public class Score implements Comparable<Score> {
	int kor;
	
	
	//캡슐화의 일종 넘기기전에 int형으로 받는게 아닌 String으로 받은 뒤 클래스에서 형변환
	public Score(String kor) {
		this.kor = Integer.parseInt(kor);
	}

	
	public Score() {
		
	}
	
	@Override
	public int compareTo(Score a) {
		return this.kor-a.kor;
	}

}
