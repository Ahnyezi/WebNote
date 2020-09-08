package jdbc.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static DBConn db = new DBConn();//클래스 밖에서도 사용할 수 있게 static으로
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private DBConn(){}//클래스 밖에서 생성자 호출 불가(private 클래스)
	
	public static DBConn getInstance(){//클래스 밖에서 객체 받는 메서드
		return db;
	}
	
	public Connection getConnect(){//db시스템에 연결
		Connection conn = null;
		try {
			Class.forName(driver);//jdbc 드라이버 로드
			conn = DriverManager.getConnection(url,"hr","hr");//db서버 주소, 계정, 비밀번호를 이용해서 세션수립
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;//연결이 된 세션을 반환
	}
}
