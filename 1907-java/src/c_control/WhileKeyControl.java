package c_control;

public class WhileKeyControl {
	boolean run = true;
	int speed = 0;
	int keyCode = 0;

	public WhileKeyControl() throws Exception {
		
		while (run) {
			if(keyCode!=13 && keyCode!=10) {
			System.out.println("===================");
			System.out.println("1.���� | 2.���� | 3.����");
			System.out.println("===================");
			}
			
			keyCode = System.in.read();

			if (keyCode == 49) {
				speed++;
				System.out.println("����ӵ� : " + speed);
			} else if (keyCode == 50) {
				speed--;
				System.out.println("����ӵ� : " + speed);
			} else if (keyCode == 51) {
				run = false;
			}
		} // while��\
		
		System.out.println("����");
	}// ������
}
