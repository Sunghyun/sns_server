package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.FrInfo;
import model.Member;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class FrDaoImpl implements FrDao {

	private SqlMapClientTemplate sm;

	public SqlMapClientTemplate getSm() {
		return sm;
	}

	public void setSm(SqlMapClientTemplate sm) {
		this.sm = sm;
	}

	@Override
	public boolean getFr(String id, String fr_id) {
		//���� �α��� �� ����� ���̵� ������ ģ������ Ȯ��
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		FrInfo m = (FrInfo) sm.queryForObject("Friend.getFr", map);
		if (m != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ArrayList getFr_sgList(int sg, String id) {
		//�Ҽ� �׷�� ���� �׷��� ��������
		Map map = new HashMap();
		map.put("id", id);
		map.put("sg", sg);
		ArrayList<Member> m = (ArrayList<Member>) sm.queryForList(
				"Friend.sgList", map);
		return m;
	}

	@Override
	public void reqFr(String id, String fr_id) {
		//ģ�� ��û
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		sm.insert("Friend.reqFr1", map);
		sm.insert("Friend.reqFr2", map);
	}

	@Override
	public void addFr(String id, String fr_id) {
		//ģ�� ���� �� ���� info1�� yes �ٲ�
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		sm.update("Friend.addFr1", map);
		sm.update("Friend.addFr2", map);
	}


	@Override
	public ArrayList getFrIdList(String id) {
		//�α����� ����� id ���
		return (ArrayList<String>) sm.queryForList("Friend.getFrIdList", id);
	}

	@Override
	public ArrayList getFrYesIdList(String id) {
		//���� ������ ģ���鿡 ���� ���̵� ���
		return (ArrayList<String>) sm.queryForList("Friend.getFrYesIdList", id);
	}

	@Override
	public ArrayList getFrList(String id) {
		return (ArrayList<FrInfo>) sm.queryForList("Friend.getFrList", id);
	}

	@Override
	public void delFr(String id, String fr_id) {
		//ģ�� ��û ���, ģ�� ��û ����
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		sm.update("Friend.delFr1", map);
		sm.update("Friend.delFr2", map);
	}

}
