package i_thread;

public class WorkObject {
	public synchronized void methodA() {
		System.out.println("A�۾� ����");
		notify(); //methodB�� ��������·� ��ȯ
		try {
			wait(); //methodA�� ���� ���·� ��ȯ
		}catch (Exception e) {}
	}
	
	public synchronized void methodB() {
		System.out.println("B�۾� ����");
		notify();
		try {
			wait();
		} catch (Exception e) {}
	}
}
