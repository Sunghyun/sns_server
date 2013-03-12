package service;

import java.util.List;

import model.FileModel;

public interface FileService {
	public void insert(FileModel m);
	public List selectfiles(String id);
	public void delete(String m);
}
