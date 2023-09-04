package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.BookVo;

public class BookDao {

	public List<BookVo> findAll() {
		// db는 arrayList가 최고임.
		List<BookVo> result = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.178:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statement 객체 생성
			stmt = conn.createStatement();

			// 4. SQL 실행 -- 띄어쓰기 조심, 뒤에 세미콜론(;) 안 붙이도록 조심.
			String sql = "  select a.no, a.title, a.rent, b.name\r\n"
					+ "  from book a, author b\r\n"
					+ "  where a.author_no = b.no;";

			rs = stmt.executeQuery(sql);

			// 5. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String rent = rs.getString(3);
				String name = rs.getString(4);

				
				System.out.println("책 번호: " + no + ", 책 제목: " + title + ", 작가: " + name + ", 대여 유무: " + rent);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static boolean updateRent(BookVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.178:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL 준비
			String sql = " update book set rent=?  where no=?";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setString(1, vo.getRent());
			pstmt.setLong(2, vo.getNo());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			// 6. 결과 처리
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 7. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
