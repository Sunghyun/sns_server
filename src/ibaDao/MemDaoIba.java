package ibaDao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import dao.SnsDao;
import model.Member;

public class MemDaoIba implements SnsDao {
	private SqlMapClientTemplate sm;

	public SqlMapClientTemplate getSm() {
		return sm;
	}

	public void setSm(SqlMapClientTemplate sm) {
		this.sm = sm;
	}

	@Override
	public int insert(Member m) {
		// TODO Auto-generated method stub
		sm.insert("Member.insert", m);
		sm.queryForObject("Member.createTab", m.getId());
		sm.queryForObject("Member.createSeq", m.getId());
		return 0;
	}
	
	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		sm.update("Member.update", m);
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		sm.delete("Member.delete", id);
		sm.queryForObject("Member.dropTab", id);
		sm.queryForObject("Member.dropSeq", id);
		return 0;
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		return (Member) sm.queryForObject("Member.getMember", id);
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		Member m2 = (Member) sm.queryForObject("Member.login", m);
		if (m2 != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		Member m = (Member) sm.queryForObject("Member.getMember", id);
		if (m != null) {
			return false;
		} else {
			return true;
		}
	}

}



