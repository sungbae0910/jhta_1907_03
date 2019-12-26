package h_api;

public class SmartPhone {
	private String asd;
	private String zxc;

	public SmartPhone(String asd, String zxc) {
		this.asd = asd;
		this.zxc = zxc;
	}

	@Override
	public String toString() {
		return asd + "," + zxc;
	}

}
