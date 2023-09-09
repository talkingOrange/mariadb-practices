package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import hr.dao.vo.EmployeesVo;


public class CartDao {
	public List<CartVo> findAll() {

		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "select * from cart";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				int count = rs.getInt(1);
				Long memberNo = rs.getLong(2);
				Long bookNo = rs.getLong(3);
		
				
				CartVo vo = new CartVo();
				
				vo.setCount(count);
				vo.setMemberNo(memberNo);
				vo.setBookNo(bookNo);

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
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "INSERT INTO cart VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getCount());
			pstmt.setLong(2, vo.getMemberNo());
			pstmt.setLong(3, vo.getBookNo());

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

	public void delete(Long memberNo, Long bookNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			String sql = "delete from cart where member_no=? and book_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, memberNo);
			pstmt.setLong(2, bookNo);

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
