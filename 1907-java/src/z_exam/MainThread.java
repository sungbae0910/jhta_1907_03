package z_exam;

public class MainThread {
	
	public static void main(String[] args) {
		System.out.println("���� ������ ����");
		
		SubThread st = new SubThread();
		Thread t = new Thread(st);
		
		try {
			t.start();
			t.join(); // SubThread�����尡 ����Ǳ������� MainThred�� �����Ű�� ����
		} catch (Exception e) {}
		System.out.println("���ν����� ����");
	}
}

