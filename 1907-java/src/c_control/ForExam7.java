package c_control;

public class ForExam7 {

	ForExam7() {
		int primeNum = 0;
		int count = 0;
		for(primeNum = 2; primeNum <= 1000; primeNum++) { //1�� �Ҽ��� �ƴϹǷ� 2�� �ʱ�ȭ
			
			for(int i = 2; i <= primeNum; i++) {
				
				if(primeNum % i == 0) {
					count++;
				}
			}
			if(count == 1) {
				System.out.println(primeNum);
			}
			count = 0;
		}
		
	}
}
