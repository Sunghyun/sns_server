package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import model.Article;
import model.Member;

public class BoardDaoImpl implements BoardDao {
	private SqlMapClientTemplate sm;

	public SqlMapClientTemplate getSm() {
		return sm;
	}

	public void setSm(SqlMapClientTemplate sm) {
		this.sm = sm;
	}

	@Override
	public void insert(Article a) {
		// TODO Auto-generated method stub
		sm.insert("Board.insert", a);
	}

	@Override
	public void update(Article a) {
		// TODO Auto-generated method stub
		sm.update("Board.update", a);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sm.delete("Board.delete", num);
	}

	@Override
	public ArrayList select(ArrayList idList) {
		// TODO Auto-generated method stub
		String id = (String)idList.get(idList.size()-1);
		System.out.println("id"+id);
		return (ArrayList<Article>)sm.queryForList("Board.select", id);
	}

	@Override
	public void delete_id(String writer_id) {
		sm.delete("Board.delete_id", writer_id);
		
	}

//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private DataSource dataSource;
//
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//
//	public void con() {
//		// TODO Auto-generated method stub
//		conn = DataSourceUtils.getConnection(dataSource);
//	}
//
//	public void discon() {
//		// TODO Auto-generated method stub
//		try {
//			DataSourceUtils.releaseConnection(conn, dataSource);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Override
//	public void insert(Article a) {
//		con();
//		String sql = "insert into sns_board values(sns_board_seq.nextval, ?, ?)";
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, a.getWriter_id());
//			pstmt.setString(2, a.getContent());
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			discon();
//		}
//	}
//
//	@Override
//	public void update(Article a) {
//		// TODO Auto-generated method stub
//		con();
//		String sql = "update sns_board set content=? where num=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, a.getContent());
//			pstmt.setInt(2, a.getNum());
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			discon();
//		}
//	}
//
//	@Override
//	public void delete(int num) {
//		// TODO Auto-generated method stub
//		con();
//		String sql = "delete sns_board where num=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			pstmt.executeUpdate();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			discon();
//		}
//	}
//
//	@Override
//	public ArrayList select(ArrayList idList) {
//		// TODO Auto-generated method stub
//		con();
//		ResultSet rs = null;
//		ArrayList<Article> data = new ArrayList<Article>();
//		String sql = "select * from sns_board where writer_id in(";
//		int i;
//		for (i = 0; i < idList.size() - 1; i++) {
//			sql += "'" + idList.get(i) + "', ";
//		}
//		sql += "'" + idList.get(i) + "') order by num";
//
//		System.out.println(sql);
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				Article a = new Article();
//				a.setNum(rs.getInt(1));
//				a.setWriter_id(rs.getString(2));
//				a.setContent(rs.getString(3));
//				data.add(a);
//			}
//			pstmt.close();
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			discon();
//		}
//		return data;
//	}

}
