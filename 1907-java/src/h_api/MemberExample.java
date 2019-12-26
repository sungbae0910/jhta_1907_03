package h_api;

import java.util.Arrays;

public class MemberExample {

	public static void main(String[] args) {
		Member mb = new Member("blue","lee","111",25,true);
		
		Member bb = mb.getMember();
		bb.password="123545";
		
		System.out.println(mb.id);
		System.out.println(mb.name);
		System.out.println(mb.password);
		System.out.println(mb.age);
		System.out.println(mb.adult);
		
		bb.car.model="гогого";
		System.out.println(mb.car.model);
		System.out.println(bb.car.model);
		
		bb.scores[1]=100;
		System.out.println(Arrays.toString(mb.scores));
		System.out.println(Arrays.toString(bb.scores));
		
		
		System.out.println("-----------------------");
		
		System.out.println(bb.id);
		System.out.println(bb.name);
		System.out.println(bb.password);
		System.out.println(bb.age);
		System.out.println(bb.adult);
	}

}
