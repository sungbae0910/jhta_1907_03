package k_io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;



public class MemberCreate {
	public static void main(String[] args) throws Exception{
		// Member.dat 파일에 직렬화된 MemeberVo객체를 추가
		List<MemberVo> list = new ArrayList<MemberVo>();
		for(int i=0; i<500; i++) {
			MemberVo mv = new MemberVo("no"+i,"pwd"+i,"name"+i,"111-111"+i);
			list.add(mv);
		}
		OutputStream os = new FileOutputStream("member.dat");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		os.close();
	}
}
