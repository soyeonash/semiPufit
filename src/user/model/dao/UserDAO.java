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
		
		String sql = "SELECT USER_ID AS SELECT_ID FROM CUSTOMER WHERE USER_NAME = ? AND USER_EMAIL = ? UNION SELECT DESIGNER_ID AS SELECT_ID FROM DESIGNER WHERE DESIGNER_NAME = ? AND DESIGNER_EMAIL = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userName);
			pstmt.setString(4, userEmail);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getString("SELECT_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return "NO";
	}

	public String selectForPw(String userId, String userEmail, Connection conn) {
		
		String sql = "SELECT USER_PWD AS SELECT_PWD FROM CUSTOMER WHERE USER_ID = ? AND USER_EMAIL = ? UNION SELECT DESIGNER_PWD AS SELECT_PWD FROM DESIGNER WHERE DESIGNER_ID = ? AND DESIGNER_EMAIL = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userId);
			pstmt.setString(4, userEmail);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getString("SELECT_PWD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return "NO";
	}

	public int modifyUserPassWord(Connection conn, String userId) {
		
		String sql = "UPDATE CUSTOMER SET USER_PWD = ? WHERE USER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 12345678);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int modifyDesignerPassWord(Connection conn, String userId) {
		
		String sql = "UPDATE DESIGNER SET DESIGNER_PWD = ? WHERE DESIGNER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 12345678);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int removeUser(Connection conn, String userId, String userPwd) {
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) AS IDCHECK FROM CUSTOMER WHERE USER_ID = ? AND USER_PWD = ?";
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getInt("IDCHECK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return 0;
	}

	public int deleteUser(Connection conn, String userId, String userPwd) {
		
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE USER_ID = ? AND USER_PWD = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int modifyUser(Connection conn, User user) {
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET USER_PWD = ?, USER_EMAIL = ?, USER_PHONE = ? WHERE USER_ID = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserPwd());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserPhone());
			pstmt.setString(4, user.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public User printOneById(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM CUSTOMER WHERE USER_ID = ?";
		ResultSet rset = null;
		User user = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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

	public int UserModify(String userId, String userPwd, String userEmail, String userPhone, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "UPDATE CUSTOMER SET USER_PWD = ?, USER_EMAIL = ?, USER_PHONE = ? WHERE USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userPhone);
			pstmt.setString(4, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}


}
