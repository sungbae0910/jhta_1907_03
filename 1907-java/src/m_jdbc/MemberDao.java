package m_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao() {
		conn=DBConn.getConn();
	}
	
	
	public int delete(String id) {
		int r = 0;
		String query="delete from member2 where mid=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			r=pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
		}
		return r;
	}
	
	public int insert(MemberVo mv) {
		int r = 0;
		String query="insert into member2 values(?,?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, mv.getmId());
			pstmt.setString(2, mv.getmName());
			pstmt.setString(3, sdf.format(mv.getrDate()));
			pstmt.setInt(4, mv.getGrade());
			
		
			r=pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public List<MemberVo> select(String find) {
		List<MemberVo> list= new ArrayList<MemberVo>();
		
		String query="select * from member2 where mid like ? or mName like ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+find+"%");
			pstmt.setString(2, "%"+find+"%");
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("mId");
				String pwd = rs.getString("mName");
				Date rdate = rs.getDate("rDate");
				int grade = rs.getInt("grade");
				
				MemberVo mv = new MemberVo(id, pwd, rdate, grade);
				list.add(mv);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberVo uSelect(String id) {
		MemberVo mv = new MemberVo();
		
		String query = "select * from member2 where mid=?";
		
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //1���̻��� �����ʹ� while���� �������� 1���� �����͸� ��ȸ�� ���� ���� if�� ���ش�
				mv.setmId(rs.getString("mid"));
				mv.setmName(rs.getString("mname"));
				mv.setrDate(rs.getDate("rDate"));
				mv.setGrade(rs.getInt("grade"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	public int update(MemberVo vo) {
		int r = 0;
		
		String query = "update member2 set mName=?, rDate=?, grade=? where mid=?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, vo.getmName());
			pstmt.setString(2, sdf.format(vo.getrDate()));
			pstmt.setInt(3, vo.getGrade());
			pstmt.setString(4, vo.getmId());
			
			r = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
