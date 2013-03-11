package service;

import model.Member;
import dao.SnsDao;

public class MemberServiceImpl implements MemberService {
	private SnsDao dao;
	
	public SnsDao getDao() {
		return dao;
	}

	public void setDao(SnsDao dao) {
		this.dao = dao;
	}

	@Override
	public int insert(Member m) {
		// TODO Auto-generated method stub
		return dao.insert(m);
	}

	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		return dao.update(m);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return dao.idCheck(id);
	}

}