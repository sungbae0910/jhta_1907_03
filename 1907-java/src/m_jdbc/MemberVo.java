package m_jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVo {
	String mId; //pk
	String mName; //nn
	Date rDate; //nn
	int grade; //check
	
	public MemberVo() {
		
	}
	
	public MemberVo(String mId, String mName, Date rDate, int grade) {
		this.mId=mId;
		this.mName=mName;
		this.rDate=rDate;
		this.grade=grade;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(rDate);
		String str = String.format("%10s\t%15s\t%15s\t%4d\n", mId, mName, d, grade);
	
		return str;
	}
	
	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}	
}
