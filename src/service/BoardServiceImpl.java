package service;

import java.util.ArrayList;

import model.Article;
import dao.BoardDao;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao;
	
	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(Article a) {
		// TODO Auto-generated method stub
		dao.insert(a);
	}

	@Override
	public void update(Article a) {
		// TODO Auto-generated method stub
		dao.update(a);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

	@Override
	public ArrayList select(ArrayList idList) {
		// TODO Auto-generated method stub
		return dao.select(idList);
	}

	@Override
	public void delete_id(String writer_id) {
		dao.delete_id(writer_id);
	}

}
