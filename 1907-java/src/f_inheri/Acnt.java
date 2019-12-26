package f_inheri;

public class Acnt {
	private String irum;
	private String ano;
	private long amount;

	public Acnt(String irum, String ano, long amount) {
		this.irum = irum;
		this.ano = ano;
		this.amount = amount;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
