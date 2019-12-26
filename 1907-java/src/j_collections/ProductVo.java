package j_collections;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {
	private String serial; //yyyy-MM-dd-serial
	private String code;
	private String pName; 
	private int ea; //수량
	private Date nal; //입고, 출고입자
	
	public ProductVo() {}
	
	public ProductVo(String serial, String code, String pName, int ea, Date nal) {
		this.serial=serial;
		this.code=code;
		this.pName=pName;
		this.ea=ea;
		this.nal=nal;
	}
	
	@Override
	public int hashCode() {
		return this.serial.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result =false;
		if(obj instanceof ProductVo) {
			ProductVo pv = (ProductVo)obj;
			result = serial.indexOf(pv.getSerial())>-1 || code.indexOf(pv.getCode())>-1 || 
					pName.indexOf(pv.getpName())>-1;
		}
		return result;
	}
	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		
		String tempEa = df.format(this.ea);
		String tempNal = sdf.format(this.nal);
		
		String mat = String.format("%s\t%s\t%s\t%s\t%s\n", this.serial, this.code, this.pName, tempEa, tempNal);
		return mat;
		/*return serial + "\t" + code + "\t" + pName + "\n" + ea + "\n" + nal + "\n";*/
	}
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public Date getNal() {
		return nal;
	}
	public void setNal(Date nal) {
		this.nal = nal;
	}
}
