package z_index;

public class OracleDao implements DataAccessObject{

	@Override
	public String select() {
		String m = "Oracle DB���� �˻�";
		return m;
	}

	@Override
	public String insert() {
		return "Oracle DB�� ����";
	}

	@Override
	public String update() {
		return "Oracle DB�� ����";
	}

	@Override
	public String delete() {
		return "Oracle DB���� ����";
	}
	
	
	
}
