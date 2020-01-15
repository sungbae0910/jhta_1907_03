package m_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class EmpInsert {

	public EmpInsert() {
		PreparedStatement pstmt = null;
		Connection conn = DBConn.getConn(); // 모듈화를 통해 반복작업 방지 ㅁㄴㅇㅁㅇㅇ
		
		try {
			String sql = "insert into emp1(employee_id, last_name, email, hire_date, job_id, salary) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 456);
			pstmt.setString(2, "hong");
			pstmt.setString(3, "leebae");
			pstmt.setDate(4, new Date(2020,01,15));
			pstmt.setInt(5, 123);
			pstmt.setInt(6, 10000);
			
			conn.setAutoCommit(false);
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				conn.commit();
				System.out.println("정상적으로 입력되었습니다.");
			}else {
				conn.rollback();
				System.out.println("입력값을 다시 확인해주세요");
			}
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EmpInsert();
	}
}
