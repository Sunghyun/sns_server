package model;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private int sg;			//현재 소속(현재 멤버가 속한 그룹)
	private String address;
	private String tel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSg() {
		return sg;
	}
	public void setSg(int sg) {
		this.sg = sg;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", sg="
				+ sg + ", address=" + address + ", tel=" + tel + "]";
	}
	
	
}
