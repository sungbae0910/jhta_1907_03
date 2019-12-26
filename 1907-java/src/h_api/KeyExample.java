package h_api;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		HashMap<Key, String> has = new HashMap<Key, String>();

		has.put(new Key(1), "¿À¿À!!");
		has.put(new Key(3), "get");

		String asd = has.get(new Key(1));
		String zxc = has.get(new Key(3));
		System.out.println(asd);
		System.out.println(zxc);

	}

}
