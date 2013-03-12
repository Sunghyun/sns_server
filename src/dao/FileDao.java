package dao;

import java.util.List;

import model.FileModel;

public interface FileDao {
	public void insert(FileModel m);
	public List selectfiles(String id);
	public void delete(String m);
}
