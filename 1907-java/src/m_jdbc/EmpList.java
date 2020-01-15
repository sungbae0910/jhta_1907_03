package m_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EmpList {

	public EmpList() throws Exception{
		PreparedStatement pstmt;
		ResultSet rs;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUesr = "hr";
		String dbPwd = "hr";
		
		Class.forName(driver).newInstance();
		Connection conn = DriverManager.getConnection(url, dbUesr, dbPwd);
		
		String sql = "select * from employees where to_char(hire_date,'rrrr')=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, 2005);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("first_name");
			int sal = rs.getInt("salary");
			Date nal = rs.getDate("hire_date");	
			
			System.out.println(name+"\n");
			System.out.println(sal+"\n");
			System.out.println(nal+"\n");
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		new EmpList();
	}
}
