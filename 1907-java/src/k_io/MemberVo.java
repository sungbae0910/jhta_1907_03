package k_io;

import java.io.Serializable;

public class MemberVo implements Serializable{ //implements Serializable 직렬화 인터페이스이지만 따로 재정의할 메소드가 없음
	public static long serialVersionUID = 1L; //서로 다른 컴퓨터에서 컴파일해도 번호가 같으면 동일한 컴퓨터에서 컴파일한 것으로 취급 
	private String mId;
	private String pwd;
	private String mName;
	private String phone;
	
	public MemberVo(String mId, String pwd, String mName, String phone){
		this.mId=mId;
		this.pwd=pwd;
		this.mName=mName;
		this.phone=phone;
	}

	@Override
	public int hashCode() {
		return mId.hashCode()+phone.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		String find = (String)obj;
		boolean result = false;
		
		if(mId.indexOf(find)>=0 && mName.indexOf(find)>=0 && phone.indexOf(find)>=0) {
			result = true;  
		}
		return result;
	}
	
	@Override
	public String toString() {
		String msg = mId + "\t" + pwd + "\t" + mName + "\t" + phone + "\n";
		return msg;
	}
	
	
	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
