package dao;

import model.Member;

public interface SnsDao {	
	int insert(Member m);					//ȸ������
	int update(Member m);					//ȸ����������
	int delete(String id);					//Ż��
	Member select(String id);				//ȸ���˻�
	boolean login(String id, String pwd);	//�α���
	boolean idCheck(String id);				//�ߺ�üũ
}
