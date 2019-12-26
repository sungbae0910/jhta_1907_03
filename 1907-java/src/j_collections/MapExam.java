package j_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public void test1() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("lee", 90);
		map.put("hong", 90);
		map.put("shin", 100);
		map.put("park", 60);
		map.put("kim", 70);
		System.out.println("map�� ������ : " + map.size());
		
		//Ű������ value���
		System.out.println(map.get("lee"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyInt = keySet.iterator();
		while(keyInt.hasNext()) {
			String key = keyInt.next();
			Integer value =map.get(key);
			System.out.println(key + ":" + value);
		}
		System.out.println();
		
		//map.entry
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter2 = entrySet.iterator();
		
		while(iter2.hasNext()) {
			Map.Entry<String, Integer> entry = iter2.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println(key + ":" + value);
		}
		
		map.put("lee", 100);
		System.out.println("���� :" + map.get("lee")+ "\n");
		
		// 1.keySet
		Set<String> ks = map.keySet();
		Iterator<String> it = ks.iterator();
		while(it.hasNext()) {
			String ss = it.next();
			Integer a = map.get(ss);
			System.out.println(ss + ":" + a);
		}
		
		System.out.println("===========================");
		
		// 2.Map.Entry
		Set<Map.Entry<String, Integer>> s = map.entrySet();
		Iterator<Map.Entry<String, Integer>> i = s.iterator();
		
		while(i.hasNext()) {
			Map.Entry<String, Integer> entry = i.next();
			String zz = entry.getKey();
			Integer in = entry.getValue();
			
			System.out.println(zz+":"+in);
		}
		
		// 3.���� for�� Ȱ��
		for(Map.Entry<String, Integer> zxc : s) {
			System.out.println(zxc.getKey()+":" + zxc.getValue());
		}
	}
	
	//key���� Student type�� ���
	public void test2() {
		Map<Student, String> m = new HashMap<Student, String>();
		
		m.put(new Student(1,"lee"), "010-1111-1234");
		m.put(new Student(2,"shin"), "010-1458-1234");
		m.put(new Student(3,"park"), "010-9854-1234");
		m.put(new Student(4,"kim"), "010-6441-1234");
		prn(m);
		System.out.println("-----------------------");
		m.put(new Student(4, "kim"), "010-8789-6595");
		prn(m);
		System.out.println("-----------------------");
		m.remove(new Student(4, "kim"));
		prn(m);
	}
	
	public void prn(Map<Student, String> map) {
		Set<Student> st = map.keySet();
		Iterator<Student> its = st.iterator();
		while(its.hasNext()) {
			Student key = its.next();
			String value = map.get(key);
			
			System.out.println(key+":"+value);
		}
	}
	
	// value���� Sale type��� 
	//map���� key�� �ߺ� �Ұ��� value�� �ߺ�����
	public void test3() {
		Map<Integer, Student> m = new HashMap<Integer, Student>();
		
		m.put(20191201, new Student(201, "lee"));
		m.put(20191202, new Student(202, "kim"));
		m.put(20191203, new Student(203, "homng"));
		m.put(20191204, new Student(204, "oh"));
		prn2(m);
		
		System.out.println("==============");
		//kim���� �̸��� �ھ��� ����
		m.put(20191202, new Student(202, "park"));
		prn2(m);
		System.out.println("==============");
		//oh���� ����
		m.remove(20191204);
		//������� ���
		prn2(m);
	}
	
	public void prn2(Map<Integer, Student> m) {
		Set<Integer> ss = m.keySet();
		Iterator<Integer> iti = ss.iterator();
		while(iti.hasNext()) {
			Integer key = iti.next();
			Student st = m.get(key);
			System.out.println(key + ":" + st);
		}
	}
	
	public static void main(String[] args) {
		MapExam p = new MapExam();
		p.test1();
		p.test2();
		p.test3();
	}

}
