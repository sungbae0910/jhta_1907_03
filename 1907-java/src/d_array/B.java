package d_array;

/*
 * 접근자 제한 종류 테스트
 * d.Array패키지 A.java | B.java
 * E.class C.java
 */
public class B {

	B() {
		A a = new A();
		a.f1 = 1; // public
		a.f2 = 1; // default
		a.f3 = 1; // private
		
	}

}
