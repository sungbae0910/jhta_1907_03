package i_thread;

public class WorkObject {
	public synchronized void methodA() {
		System.out.println("A작업 실행");
		notify(); //methodB를 실행대기상태로 변환
		try {
			wait(); //methodA를 정지 상태로 변환
		}catch (Exception e) {}
	}
	
	public synchronized void methodB() {
		System.out.println("B작업 실행");
		notify();
		try {
			wait();
		} catch (Exception e) {}
	}
}
