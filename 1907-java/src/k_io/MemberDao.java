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
	
	
	public List<MemberVo> search(MemberSearch ms){ // JinternalFrame��ü�� �Ѱܵ� ������ getFindstr�� �Ѱܼ� �޾Ƶ� ��.
		List<MemberVo> list = new ArrayList<MemberVo>();
		//member.dat�� �ִ� �ڷ���� �о� list�� �߰��� �� ��ȯ
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
		 * ������ ������ �о �޸𸮿� ����
		 * �Ű������� �Էµ� vo�� �޸𸮿� �߰�
		 * �ش� ������ �ٽ� ���Ͽ� ����
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
		}finally { //finally�ȿ��� return�� ����ϸ� �������� ������ �ƴ����� �ǵ�ġ ���� ������ �߻��� �� �ֱ� ������ ���� �����ؾ���.
			return r;	
		}
	}
	
	public void modify() {
		
	}
	
}
