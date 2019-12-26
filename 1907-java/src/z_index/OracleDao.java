package z_index;

public class OracleDao implements DataAccessObject{

	@Override
	public String select() {
		String m = "Oracle DB에서 검색";
		return m;
	}

	@Override
	public String insert() {
		return "Oracle DB에 삽입";
	}

	@Override
	public String update() {
		return "Oracle DB를 수정";
	}

	@Override
	public String delete() {
		return "Oracle DB에서 삭제";
	}
	
	
	
}
