package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import model.FileModel;
import dao.FileDao;

public class FileServiceImpl implements FileService{

	private HttpServletRequest req;
	
	private FileDao dao;

	public FileDao getDao() {
		return dao;
	}

	public void setDao(FileDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(FileModel m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}
	
	
	@Override
	public List selectfiles(String id){
		// TODO Auto-generated method stub	
		return dao.selectfiles(id);
	}

	@Override
	public void delete(String m) {
		// TODO Auto-generated method stub
		dao.delete(m);
	}
	

}
