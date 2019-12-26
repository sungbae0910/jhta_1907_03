package d_array;

public class ArrayExam2 {

	public ArrayExam2() {
		int[] arr = new int[] { 1, 10, 1999, 1011, -101, 222 };
		int max = 0;
		int min = 2000;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		System.out.println("max °ª : " + max);
		System.out.println("min °ª : " + min);

	}

	public static void main(String[] args) {
		ArrayExam2 asd = new ArrayExam2();
	}
}
