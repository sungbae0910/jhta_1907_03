package i_thread;

public class ThreadA extends Thread {
	public ThreadA() {
		// setName�� ���� Thread�� �̸��� �������� �� ����
		setName("�����");
	}

	// Thread�� ��ӹ޾� run()�޼ҵ带 ��������
	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(this.getName() + "�� ����� ����");
		}
	}
}
