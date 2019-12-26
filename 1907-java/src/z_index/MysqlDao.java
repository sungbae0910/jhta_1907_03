package z_index;

public class MysqlDao implements DataAccessObject{

	@Override
	public String select() {
		return "Mysql에서 검색";
	}

	@Override
	public String insert() {
		return "Mysql에서 삽입";
	}

	@Override
	public String update() {
		return "Mysql에서 수정";
	}

	@Override
	public String delete() {
		return "Mysql에서 삭제";
	}
	

}
