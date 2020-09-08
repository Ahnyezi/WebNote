package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dbconn.DBConn;

public class DaoImpl implements Dao {
	private DBConn db;
	
	public DaoImpl(){
		db=DBConn.getInstance();
	}

	@Override
	public void insert(Article a) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnect();//db 연결
		String sql = "insert into guestbook values(seq_questbook.nextval,?,?,sysdate,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);//쿼리문 처리 객체
			pstm.setString(1, a.getWriter());
			pstm.setString(2, a.getPwd());
			pstm.setString(3, a.getContent());
			int rows = pstm.executeUpdate();//적용된 줄 수를 반환
			System.out.println(rows+" 줄이 추가되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Article select(int num) {//글 번호로 글 하나 검색해서 Article 객체로 반환
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> selectAll() {//글 전체 검색해서 Article 객체로 만들어서 ArrayList에 담아 반환
		// TODO Auto-generated method stub
		ArrayList<Article> list = new ArrayList<Article>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		String sql = "select * from guestbook order by num";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Article a) {//글 번호로 찾아서 글 내용을 수정
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int num) {//글 번호로 삭제
		// TODO Auto-generated method stub

	}

}
