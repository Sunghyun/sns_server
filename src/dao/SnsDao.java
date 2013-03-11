package dao;

import model.Member;

public interface SnsDao {	
	int insert(Member m);					//회원가입
	int update(Member m);					//회원정보수정
	int delete(String id);					//탈퇴
	Member select(String id);				//회원검색
	boolean login(String id, String pwd);	//로그인
	boolean idCheck(String id);				//중복체크
}
