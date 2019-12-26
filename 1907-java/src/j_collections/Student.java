package j_collections;

import java.text.MessageFormat;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno=sno;
		this.name=name;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean r = false;
		if(obj instanceof Student) {
			Student as = (Student)obj;
			if(sno==as.sno && name.equals(as.name)) {
				r = true;
			}else {
				r= false;
			}
		}
		return r;
	}

	@Override
	public int hashCode() {
		return this.sno + this.name.hashCode();
	}

	@Override
	public String toString() {
		String mf = MessageFormat.format("{0} --- {1}", sno, name);
		return mf;
	}
	
}
