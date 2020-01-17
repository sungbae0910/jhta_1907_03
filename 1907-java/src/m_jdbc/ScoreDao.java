package m_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreDao {
	Connection conn ;
	PreparedStatement pstmt;
	ResultSet set;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public ScoreDao() {
		conn = DBConn.getConn();
	}
	
	public int insert(ScoreVo sv) {
		int r = 0;
		
		String sql = "insert into score values(seq_score.nextVal, ?, ?, ?, ?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sv.getId());
			pstmt.setString(2, sdf.format(sv.getRd()));
			pstmt.setString(3, sv.getSub());
			pstmt.setInt(4, sv.getSc());
			
			conn.setAutoCommit(false);
			r = pstmt.executeUpdate();
			
			if(r>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(conn!=null) try { conn.close();} catch (Exception e2) {}
		}
		return r;
	}
	
	public int delete(int serial) {
		int r = 0;
		
		String sql = "delete from score where serial=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, serial);
			
			r = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(Exception e2) {}
			if(conn!=null) try {conn.close();} catch(Exception e2) {}
		}
		return r;
	}
	
	public ScoreVo search(int se) {
		ScoreVo sv = null;
		
		try {
			String sql = "select s.serial, s.mId, s.rDate, s.subject, s.score, m.mName from score s "
						+ " join member2 m on s.mId=m.mId where s.serial=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, se);
			
			set = pstmt.executeQuery();
			
			if(set.next()) {
				sv = new ScoreVo();
				sv.setId(set.getString("mId"));
				sv.setRd(set.getDate("rDate"));
				sv.setSub(set.getString("subject"));
				sv.setSc(set.getInt("score"));
				sv.setmName(set.getString("mName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(set!=null) try{set.close();}catch (Exception e) {}
			if(pstmt!=null) try{pstmt.close();}catch (Exception e) {}
			if(conn!=null) try{conn.close();}catch (Exception e) {}
		}
		return sv;
	}
	
	public int update(ScoreVo sv) {
		int r = 0;
		String sql = "update score set rDate=?, subject=?, score=? where serial=?";
		String sql2 = "update member2 set mName=?, mid=? where mid=(select mid from score where serial=?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sdf.format(sv.getRd()));
			pstmt.setString(2, sv.getSub());
			pstmt.setInt(3, sv.getSc());
			pstmt.setInt(4, sv.getSe());
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, sv.getmName());
			pstmt.setString(2, sv.getId());
			pstmt.setInt(3, sv.getSe());
			r = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return r;
	}
	
	public List<ScoreVo> select(String find){
		List<ScoreVo> list = new ArrayList<ScoreVo>();
		String sql ="select m.mid, m.mName, s.serial, s.rDate, s.subject, s.score from member2 m left outer join score s on m.mid=s.mid " 
		+ " where m.mid like ? or s.subject like ? or m.MNAME like ?";
		ResultSet set = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+find+"%");
			pstmt.setString(2, "%"+find+"%");
			pstmt.setString(3, "%"+find+"%");
			
			set = pstmt.executeQuery();
			
			while(set.next()) {
				String id = set.getString("mid");
				String name = set.getString("mName");
				int serial = set.getInt("serial");
				Date date = set.getDate("rDate");
				String sub = set.getString("subject");
				int score = set.getInt("score");
				ScoreVo sv = new ScoreVo(serial, id, name, date, sub, score);
				list.add(sv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}