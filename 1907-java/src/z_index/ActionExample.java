package z_index;

public class ActionExample {

	public static void main(String[] args) {
		/*Action action = new Aa();
		action.work();*/
		
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("���縦 �մϴ�.");
			}
		};
		action.work();
	}

}
