package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.OpenDTO;

public class OpenDAO {
	private String username = "root";
	private String password = "1111111";
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private Connection conn = null;
	
	public OpenDAO() {
		init();	
	}
	
	private void init() { // 드라이버 로드
		try {
			Class.forName(driverName);
			System.out.println("오라클 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private boolean conn() { // 커넥션 가져오는 공통 코드를 메서드로 정의
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("커넥션 자원 획득 성공");
			return true; // 커넥션 자원을 정상적으로 획득 할시
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 커넥션 자원을 획득하지 못한 경우.
	}
	public void add(OpenDTO odto) {
		if(conn()) {
			try {
				String sql ="insert into Opendata values (?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, odto.getName());
				psmt.setString(2, odto.getTitle());
				psmt.setString(3, odto.getIon());
				
				int resultInt = psmt.executeUpdate();
				if(resultInt > 0 ) {
					conn.commit();
				}else {
					conn.rollback();
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}else {
			System.out.println("커넥션 실패");
		}
	}
}
