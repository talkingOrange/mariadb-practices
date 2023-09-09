package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderVo;

public class OrderDao {
	public List<OrderVo> findAll() {

		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "select * from orders";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String orderNumber = rs.getString(2);
				int orderPrice = rs.getInt(3);
				String address = rs.getString(4);
				Long memberNo = rs.getLong(5);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrderNumber(orderNumber);
				vo.setOrderPrice(orderPrice);
				vo.setAddress(address);
				vo.setMemberNo(memberNo);

				result.add(vo);
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
		return result;

	}

	public List<OrderVo> findOrderBookAll() {

		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "select * from order_book";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				int count = rs.getInt(3);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setBookNo(bookNo);
				vo.setCount(count);
				
				result.add(vo);
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
		return result;

	}
	
	public Long findMemberNoByNo(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long memberNo = 0L;
		try {
			conn = ConnectionUtil.getConnection();

			String sql = "select member_no from orders where order_no= ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Long.toString(no));

			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberNo = rs.getLong("member_no");
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
		return memberNo;
	}
	
	public void insert(OrderVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "INSERT INTO orders VALUES (null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrderNumber());
			pstmt.setInt(2, vo.getOrderPrice());
			pstmt.setString(3, vo.getAddress());
			pstmt.setLong(4, vo.getMemberNo());

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

	public void orderBookInsert(OrderVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "INSERT INTO order_book VALUES (?, ?,  ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getCount());

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

	public void delete(String orderNumber) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			String sql = "delete from orders where order_number=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, orderNumber);

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
	
	public void orderBookdelete(Long orderNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			String sql = "delete from order_book where order_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, orderNo);

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
