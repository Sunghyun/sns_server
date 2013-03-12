package model;

public class FileModel {
	private int num;
	private String id;
	private String fid;
	private String loc;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public FileModel(String id, String fid, String loc) {
		super();
		this.id = id;
		this.fid = fid;
		this.loc = loc;
	}
	public FileModel(){}

}
