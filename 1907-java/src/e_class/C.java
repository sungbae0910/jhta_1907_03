package e_class;

import d_array.A;
/*
 * ������ ���� ���� �׽�Ʈ
 * d.Array��Ű�� A.java | B.java
 * E.class C.java
 */
public class C {
	A a = new A();
	
	C(){
		a.f1 = 10; // public
		a.f2 = 10; // default(AŬ������ �ٸ� ��Ű���̱� ������ ���� �Ұ���)
		a.f3 = 55; // private(�ܺ� ��Ű���̱� ������ ���� X)
		
	}
}
