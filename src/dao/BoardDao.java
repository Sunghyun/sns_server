package dao;

import java.util.ArrayList;

import model.Article;

public interface BoardDao {
	void insert(Article a);
	void update(Article a);
	void delete(int num);
	ArrayList select(ArrayList idList);
	
	void delete_id(String writer_id);
}
