package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest02 {

	public static void main(String[] args) {
		boolean result = insertDepartment("IT운영팀");
		System.out.println(result ? "성공" : "실패");
	}

	private static boolean insertDepartment(String name) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mariadb://192.168.0.178:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			//3. SQL 바인딩을 위한 준비
			String sql =
					" insert" +
							"   into dept" + 
							" values (null, ?)";
			pstmt = conn.prepareStatement(sql);
			
		
			//4. 값 binding
			pstmt.setString(1, name);
			
			//5. SQL 실행
			
			int count = pstmt.executeUpdate();  //여기에 파라미터로 sql을 주면 이상한 sql문을 주는 것임.
			
			//6. 결과 처리
			result = count == 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}