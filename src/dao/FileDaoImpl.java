package dao;

import java.util.List;

import model.FileModel;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class FileDaoImpl implements FileDao{

	private SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@Override
	public void insert(FileModel m) {
		// TODO Auto-generated method stub		
		sqlMapClientTemplate.insert("FileModel.insertMember", m);

	}

	@Override
	public List selectfiles(String id) {
		// TODO Auto-generated method stub
		List a = sqlMapClientTemplate.queryForList("FileModel.selectfiles",id); 
		return 	a;
	}

	@Override
	public void delete(String m) {
		sqlMapClientTemplate.delete("FileModel.deleteMember",m);
		// TODO Auto-generated method stub
		
	}
	
	
}
