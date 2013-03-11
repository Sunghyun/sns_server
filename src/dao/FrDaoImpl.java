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
		//현재 로그인 한 사람의 아이디를 가지고 친구정보 확인
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
		//소셜 그룹과 동일 그룹사람 가져오기
		Map map = new HashMap();
		map.put("id", id);
		map.put("sg", sg);
		ArrayList<Member> m = (ArrayList<Member>) sm.queryForList(
				"Friend.sgList", map);
		return m;
	}

	@Override
	public void reqFr(String id, String fr_id) {
		//친구 요청
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		sm.insert("Friend.reqFr1", map);
		sm.insert("Friend.reqFr2", map);
	}

	@Override
	public void addFr(String id, String fr_id) {
		//친구 수락 시 양쪽 info1을 yes 바꿈
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		sm.update("Friend.addFr1", map);
		sm.update("Friend.addFr2", map);
	}


	@Override
	public ArrayList getFrIdList(String id) {
		//로그인한 사람의 id 목록
		return (ArrayList<String>) sm.queryForList("Friend.getFrIdList", id);
	}

	@Override
	public ArrayList getFrYesIdList(String id) {
		//서로 수락한 친구들에 대한 아이디 목록
		return (ArrayList<String>) sm.queryForList("Friend.getFrYesIdList", id);
	}

	@Override
	public ArrayList getFrList(String id) {
		return (ArrayList<FrInfo>) sm.queryForList("Friend.getFrList", id);
	}

	@Override
	public void delFr(String id, String fr_id) {
		//친구 요청 취소, 친구 요청 거절
		Map map = new HashMap();
		map.put("id", id);
		map.put("fr_id", fr_id);
		sm.update("Friend.delFr1", map);
		sm.update("Friend.delFr2", map);
	}

}
