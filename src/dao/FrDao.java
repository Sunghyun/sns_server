package dao;

import java.util.ArrayList;

public interface FrDao {

	boolean getFr(String id, String fr_id);
	ArrayList getFr_sgList(int sg, String id);
	void reqFr(String id, String fr_id);
	void addFr(String id, String fr_id);
	ArrayList getFrIdList(String id); // 친구 아이디 값을 가져옴
	ArrayList getFrYesIdList(String id);
	ArrayList getFrList(String id);
	void delFr(String id, String fr_id);

}
