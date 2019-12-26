package j_collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> st = new HashSet<String>();
		
		st.add("응");
		st.add("...");
		st.add("naiton");
		st.add("흐핳");
		st.add("흐핳");
		
		int size = st.size();
		System.out.println("HashSet의 사이즈:"+size);
		
		Iterator<String> it = st.iterator();
		while(it.hasNext()) {
			String element = it.next();
			System.out.println("HashSet의 내용 :"+element);
		}
		System.out.println("=========================");
		
		st.remove("...");
		size = st.size();
		System.out.println("HashSet의 사이즈 :"+size);
		
		it = st.iterator();
		while(it.hasNext()) {
			String element = it.next();
			System.out.println("HashSet의 내용 :"+element);
		}
		
		st.clear();
		if(st.isEmpty()) {
			System.out.println("텅비었음!!");
		}
		
		
		Set<MemberVo> ss = new HashSet<MemberVo>();
		ss.add(new MemberVo("a","111","hong","010-1234"));
		ss.add(new MemberVo("b","111","hong","010-1234"));
		ss.add(new MemberVo("b","111","hong","010-0000"));
		ss.add(new MemberVo("b","222","kim","010-1234"));
		
		
		Iterator<MemberVo> s2 = ss.iterator();
		while(s2.hasNext()) {
			MemberVo  mv = s2.next();
			System.out.println(mv);
		}

		MemberVo szxc = new MemberVo("a","111","hong","010-1234");
		ss.remove(szxc);
		
		//향상된 for문
		for(MemberVo aa : ss) {
			System.out.println(aa);
		}
	}
}
