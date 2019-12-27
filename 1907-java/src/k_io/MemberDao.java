package k_io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	String fileName = "member.dat";
	
	
	public List<MemberVo> search(MemberSearch ms){
		List<MemberVo> list = new ArrayList<MemberVo>();
		//member.dat에 있는 자료들을 읽어 list에 추가한 후 반환
		try {
			InputStream is = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			String find = ms.getFindStr().getText();
			
			List<MemberVo> temp = (List)ois.readObject();
			for(MemberVo vo : temp) {
				if(vo.equals(find)) {
					list.add(vo);
				}
			}
		} catch (Exception e) {
			list = null;
		}
		return list;
	}
	
	public void input() {
		
	}
	
	public void modify() {
		
	}
	
}
