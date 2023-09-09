package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;


public class CategoryDao {public List<CategoryVo> findAll() {

	List<CategoryVo> result = new ArrayList<>();

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = ConnectionUtil.getConnection();

		// 3. SQL 준비
		String sql = "select name from category order by category_no asc";
		pstmt = conn.prepareStatement(sql);

		// 5. SQL 실행
		rs = pstmt.executeQuery();

		// 6. 결과 처리
		while (rs.next()) {
			String name = rs.getString(1);
			
			CategoryVo vo = new CategoryVo();
			vo.setName(name);

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

public void insert(CategoryVo vo) {

	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = ConnectionUtil.getConnection();

		// 3. SQL 준비
		String sql = "INSERT INTO category VALUES (null, ?)";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getName());

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

public void delete(String name) {

	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = ConnectionUtil.getConnection();

		String sql = "delete from category where name=?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, name);

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
