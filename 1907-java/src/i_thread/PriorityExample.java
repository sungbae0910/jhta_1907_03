package i_thread;

public class PriorityExample {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			//�����ڸ� ���� thread�̸��� �Ѱ���
			Thread a = new CalcThread("thread"+i);
			//i�� 10�̾ƴϸ� 1 ���� 10�̸� �켱���� 10���� ���� 
			if(i != 10) {
				a.setPriority(Thread.MIN_PRIORITY);
			}else {
				a.setPriority(Thread.MAX_PRIORITY);
			}
			/*
			 * ������ : thread10�� �켱����10�� ���������� ������ thread10�� ����
			 * �������� ����
			 */
			a.start();
		}
	}
}
