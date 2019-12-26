package i_thread;

public class PriorityExample {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			//생성자를 통해 thread이름을 넘겨줌
			Thread a = new CalcThread("thread"+i);
			//i가 10이아니면 1 설정 10이면 우선순위 10으로 설정 
			if(i != 10) {
				a.setPriority(Thread.MIN_PRIORITY);
			}else {
				a.setPriority(Thread.MAX_PRIORITY);
			}
			/*
			 * 실행결과 : thread10에 우선순위10을 배정했지만 무조건 thread10이 먼저
			 * 끝나지는 않음
			 */
			a.start();
		}
	}
}
