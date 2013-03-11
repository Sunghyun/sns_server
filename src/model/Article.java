package model;

public class Article {
	private int num;
	private String writer_id;
	private String content;
	
	public Article(){}
	public Article(int num, String writer_id, String content) {
		this.num = num;
		this.writer_id = writer_id;
		this.content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Article [num=" + num + ", writer_id=" + writer_id
				+ ", content=" + content + "]";
	}
	
}
