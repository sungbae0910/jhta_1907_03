package h_api;

/*
 * String과 StringBuilder의 속도 비교
 */
public class StringBuilderExam {

	public StringBuilderExam() {
		//String의 속도
		long sTime = 0, eTime = 0;
		String str = "";
		
		sTime = System.nanoTime();
		for(int i=0; i<50000; i++) {
			str+="a";
		}
		eTime = System.nanoTime();
		
		System.out.println("String 처리 시간 :" + (eTime-sTime));
		
		//StringBuilder 처리 시간
		//싱글처리에는 StringBuilder사용 멀티스레드는 StringBuffer사용
		StringBuilder sb = new StringBuilder(); 
		sTime=System.nanoTime();
		for(int i=0; i<50000; i++) {
			sb.append("a");
		}
		eTime = System.nanoTime();
		
		System.out.println("StringBuilder 처리 시간 : "+(eTime-sTime));
	}
	
	public static void main(String[] args) {
		new StringBuilderExam();
	}

}
