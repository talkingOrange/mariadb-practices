package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.MemberVo;

public class MemberDao {
	public List<MemberVo> findAll() {

		List<MemberVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "select name, tel, email, passwd from member order by member_no";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			// 6. 결과 처리
			while (rs.next()) {
				String name = rs.getString(1);
				String tel = rs.getString(2);
				String email = rs.getString(3);
				String passwd = rs.getString(4);

				MemberVo vo = new MemberVo();
				vo.setName(name);
				vo.setTel(tel);
				vo.setEmail(email);
				vo.setPasswd(passwd);

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

	public void insert(MemberVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();

			// 3. SQL 준비
			String sql = "INSERT INTO member VALUES (null, ?, ?,?, ? )";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPasswd());

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

	public void delete(String passwd) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionUtil.getConnection();
			
			String sql = "delete from member where passwd=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, passwd);

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
	
	public String findMemberNameByNo(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			conn = ConnectionUtil.getConnection();

			String sql = "select name from member where member_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Long.toString(no));

			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
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

	public String findMemberEmailByNo(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String email = null;
		try {
			conn = ConnectionUtil.getConnection();

			String sql = "select email from member where member_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Long.toString(no));

			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				email = rs.getString("email");
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
		return email;
	}

}
