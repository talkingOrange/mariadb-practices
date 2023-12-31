package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;

public class BookDao {
	
	public List<BookVo> findAll() {

		List<BookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "select title, price from book order by book_no asc";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				String title = rs.getString(1);
				int price = rs.getInt(2);

				BookVo vo = new BookVo();
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

	public String findBookTitleByNo(Long i) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			conn = ConnectionUtil.getConnection();

			String sql = "select title from book where book_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Long.toString(i));

			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("title");
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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
		return name;
	}

	public int findBookPriceByNo(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int price = 0;
		try {
			conn = ConnectionUtil.getConnection();

			String sql = "select price from book where book_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Long.toString(no));

			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				price = rs.getInt("price");
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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
		return price;

	}

	public void insert(BookVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "INSERT INTO book VALUES (null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategoryNo());

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

	public void delete(String title) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			String sql = "delete from book where title=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);

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



}
