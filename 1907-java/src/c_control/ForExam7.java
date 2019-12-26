package c_control;

public class ForExam7 {

	ForExam7() {
		int primeNum = 0;
		int count = 0;
		for(primeNum = 2; primeNum <= 1000; primeNum++) { //1은 소수가 아니므로 2로 초기화
			
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
