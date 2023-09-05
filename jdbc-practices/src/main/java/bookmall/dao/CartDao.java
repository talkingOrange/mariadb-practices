package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;


public class CartDao {
	public List<CartVo> findAll() {

		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select *"
					+ " from cart a, book b"
					+ " where a.book_no = b.book_no";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				int count = rs.getInt(1);
				int memberNo = rs.getInt(2);
				int bookNo = rs.getInt(3);
				String title = rs.getString(5);
				int price = rs.getInt(6);
				
				CartVo vo = new CartVo();
				
				vo.setCount(count);
				vo.setMemberNo(memberNo);
				vo.setBookNo(bookNo);
			    vo.setTitle(title);
			    vo.setPrice(price);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리
				if (rs != null) {
					rs.close();
				}
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

	public void insert(CartVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "INSERT INTO cart VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getCount());
			pstmt.setInt(2, vo.getMemberNo());
			pstmt.setInt(3, vo.getBookNo());

			// 5. SQL 실행
			pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 6. 자원정리

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
	}

	public void delete(int memberNo, int bookNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "delete from cart where member_no=? and book_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, bookNo);

			pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {

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
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.0.178:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;

	}

}
