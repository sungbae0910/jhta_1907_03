package sort;

public class Score implements Comparable<Score> {
	int kor;
	
	
	//ĸ��ȭ�� ���� �ѱ������ int������ �޴°� �ƴ� String���� ���� �� Ŭ�������� ����ȯ
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
