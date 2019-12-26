package e_class;

import d_array.A;
/*
 * 접근자 제한 종류 테스트
 * d.Array패키지 A.java | B.java
 * E.class C.java
 */
public class C {
	A a = new A();
	
	C(){
		a.f1 = 10; // public
		a.f2 = 10; // default(A클래스랑 다른 패키지이기 때문에 실행 불가능)
		a.f3 = 55; // private(외부 패키지이기 때문에 실행 X)
		
	}
}
