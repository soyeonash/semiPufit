package user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import user.model.vo.User;

public class UserDAO {

	public int userEnroll(Connection conn, User user) {
		
		String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,DEFAULT,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int userIdCheck(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		String sql = "SELECT SUM(isCheck) AS isCheck FROM (SELECT COUNT(*) AS isCheck FROM CUSTOMER WHERE USER_ID = ? UNION SELECT COUNT(*) AS isCheck FROM DESIGNER WHERE DESIGNER_ID = ?)";
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getInt("isCheck");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return 0;
	}

	public User loginUser(Connection conn, String loginId, String loginPw) {
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM CUSTOMER WHERE USER_ID = ? AND USER_PWD = ?";
		ResultSet rset = null;
		User user = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				user.setUserId(rset.getString("USER_ID"));
				user.setUserPwd(rset.getString("USER_PWD"));
				user.setUserName(rset.getString("USER_NAME"));
				user.setUserEmail(rset.getString("USER_EMAIL"));
				user.setUserPhone(rset.getString("USER_PHONE"));
				user.setAdmin(rset.getString("ADMIN"));
				user.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return user;
	}

	public String selectForId(Connection conn, String userName, String userEmail) {
		
		String sql = "";
		PreparedStatement pstmt = null;
		String userId = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
