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
		Connection conn = db.getConnect();//db ����
		String sql = "insert into guestbook values(seq_questbook.nextval,?,?,sysdate,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);//������ ó�� ��ü
			pstm.setString(1, a.getWriter());
			pstm.setString(2, a.getPwd());
			pstm.setString(3, a.getContent());
			int rows = pstm.executeUpdate();//����� �� ���� ��ȯ
			System.out.println(rows+" ���� �߰��Ǿ����ϴ�.");
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
	public Article select(int num) {//�� ��ȣ�� �� �ϳ� �˻��ؼ� Article ��ü�� ��ȯ
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> selectAll() {//�� ��ü �˻��ؼ� Article ��ü�� ���� ArrayList�� ��� ��ȯ
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
	public void update(Article a) {//�� ��ȣ�� ã�Ƽ� �� ������ ����
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int num) {//�� ��ȣ�� ����
		// TODO Auto-generated method stub

	}

}
