package e_class;

public class Static {
	// ������(�����ڿ�) : ��� ��ü�� �ϳ��� ���� ���
	// �ʱ�ȭ�� 1��
	// Ŭ����.��� �Ǵ� ��ü��.��� �Ѵ� ��� ���� 
	static int v1 = 5000; 
	int v2 = 5000; //�ν��Ͻ���
	
	public static void main(String[] args) {
		Static s1 = new Static(); 
		s1.v1=1000;
		s1.v2=1000;
		
		Static s2 = new Static();
		System.out.println(Static.v1);
		System.out.println(s2.v1);
		System.out.println(s2.v2);
	}
}
