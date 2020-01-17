package m_jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreVo {
	int se;
	String id;
	String mName;
	Date rd;
	String sub;
	int sc;
	
	public ScoreVo() {}
	public ScoreVo(int se, String id, String mName, Date rd, String sub, int sc) {
		this.se=se;
		this.id=id;
		this.mName=mName;
		this.rd=rd;
		this.sub=sub;
		this.sc=sc;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = null;
		if(rd==null) {
			d="";
		}else {
			d = sdf.format(rd);
		}
		String temp = String.format("%10d\t%15s\t%20s\t%10s\t%30s\t%7d", se, id, mName, d, sub, sc);
		
		return temp;
	}
	
	public int getSe() {
		return se;
	}
	public void setSe(int se) {
		this.se = se;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public Date getRd() {
		return rd;
	}
	public void setRd(Date rd) {
		this.rd = rd;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public int getSc() {
		return sc;
	}
	public void setSc(int sc) {
		this.sc = sc;
	}
	
}
