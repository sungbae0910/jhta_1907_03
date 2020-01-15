package m_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class EmpInsert {

	public EmpInsert() {
		PreparedStatement pstmt = null;
		Connection conn = DBConn.getConn(); // ���ȭ�� ���� �ݺ��۾� ���� ������������
		
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
				System.out.println("���������� �ԷµǾ����ϴ�.");
			}else {
				conn.rollback();
				System.out.println("�Է°��� �ٽ� Ȯ�����ּ���");
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
