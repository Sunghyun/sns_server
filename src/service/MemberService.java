package service;

import model.Member;

public interface MemberService {
	int insert(Member m);
	int update(Member m);
	int delete(String id);
	Member select(String id);
	boolean login(String id, String pwd);
	boolean idCheck(String id);
}
