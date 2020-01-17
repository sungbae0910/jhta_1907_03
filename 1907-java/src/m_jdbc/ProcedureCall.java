package m_jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class ProcedureCall {

	public static void main(String[] args) throws Exception{
		Connection conn = DBConn.getConn();
		
		String sql = "{call BBB(?,?,?)}";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, 575);
		cs.setInt(2, 757);
		cs.registerOutParameter(3, Types.INTEGER);
		
		cs.executeQuery();
		
		String a = cs.getString(3);
		
		System.out.println(a);
		
		System.out.println("------------------");
		
		String sql2 = "{call AAA(?,?)}";
		cs=conn.prepareCall(sql2);
		cs.setString(1, "으핳");
		cs.registerOutParameter(2, Types.VARCHAR);
		
		cs.executeQuery();
		
		String a2 = cs.getString(2);
		System.out.println(a2);
	}
}
