package zzzzz;

public class ProductExam {
	public static void main(String[] args) {
		
		Product pt = new TV();
		Product pt2 = new Radio();
		Product pt3 = new Video();
		
		//2. �ڽ� Ŭ���������� getProductName()�� Override�Ͽ� �ڽ��� �̸��� ��µǵ��� ��ġ�Ͻÿ�
		System.out.println(pt.getProductName());
		System.out.println(pt2.getProductName());
		System.out.println(pt3.getProductName());

		//3.Radio Ŭ������ Video Ŭ������ ����ȯ�� �ȵ��� �����ϴ� �ڵ带 �ۼ� �Ͻÿ�.
		System.out.println(pt2 instanceof Video);
		
		//3.2 Radio, Video, TV Ŭ������ ProductŬ������ ����ȯ�� �������� ����
		System.out.println(pt instanceof Product);
		System.out.println(pt2 instanceof Product);
		System.out.println(pt3 instanceof Product);
		
		if(pt instanceof Product) {
			System.out.println("����ȯ ����");
		}else {
			System.out.println("����");
		}
		
		if(pt instanceof Video) {
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		
		if(pt2 instanceof Video) {
			System.out.println("����!!");
		}else {
			System.out.println("�äӤ�����������������������");
		}
		
		try {
			pt2 = (Radio)pt3;
			System.out.println("����");
		} catch (Exception e) {
			System.out.println("��������");
		}
		
		try {
			pt2 = new Radio();
			System.out.println("����!!");
		} catch (Exception e) {
			System.out.println("���ؤ�������");
		}
	}
}
