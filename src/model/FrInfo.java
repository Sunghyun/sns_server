package model;

public class FrInfo {
	private int num;
	private String fr_id;
	private String info1;
	
	public FrInfo() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFr_id() {
		return fr_id;
	}

	public void setFr_id(String fr_id) {
		this.fr_id = fr_id;
	}

	public String getInfo1() {
		return info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	public FrInfo(int num, String fr_id, String info1) {
		super();
		this.num = num;
		this.fr_id = fr_id;
		this.info1 = info1;
	}

	@Override
	public String toString() {
		return "FrInfo [num=" + num + ", fr_id=" + fr_id + ", info1=" + info1
				+ "]";
	}
	
}
