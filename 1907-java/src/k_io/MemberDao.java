package k_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	String fileName = "member.dat";
	
	
	public List<MemberVo> search(MemberSearch ms){ // JinternalFrame자체를 넘겨도 되지만 getFindstr만 넘겨서 받아도 됨.
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
			ois.close();
			is.close();
		} catch (Exception e) {
			list = null;
		}
		return list;
	}
	
	public boolean input(MemberVo mv) {
		boolean r = false;
		/*
		 * 파일의 정보를 읽어서 메모리에 적재
		 * 매개변수로 입력된 vo를 메모리에 추가
		 * 해당 내용을 다시 파일에 저장
		 */
		try {
			InputStream is  = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(is);
			List<MemberVo> list = (List)ois.readObject();
			list.add(mv);
			ois.close();
			is.close();
			
			OutputStream os = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			os.close();
			r = true;
		} catch (Exception e) {
			r = false;
		}finally { //finally안에서 return을 사용하면 문법적인 오류는 아니지만 의도치 않은 오류가 발생할 수 있기 때문에 사용시 주의해야함.
			return r;	
		}
	}
	
	public void modify() {
		
	}
	
}
