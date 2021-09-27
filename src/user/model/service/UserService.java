package user.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import user.model.dao.UserDAO;
import user.model.vo.User;

public class UserService {
	
	private JDBCTemplate jdbcTemplate;
	
	public UserService() {
		jdbcTemplate = new JDBCTemplate().getConnection();
	}

	public int userEnroll(User user) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createStatement();
			result = new UserDAO().userEnroll(conn, user);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int userIdCheck(String userId) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createStatement();
			result = new UserDAO().userIdCheck(conn, userId);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

	public User loginUser(String loginId, String loginPw) {
		
		Connection conn = null;
		User user = null;
		
		try {
			conn = jdbcTemplate.createStatement();
			user = new UserDAO().loginUser(conn, loginId, loginPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return user;
	}

	public String selectForId(String userName, String userEmail) {
		
		Connection conn = null;
		String userId = null;
		
		try {
			conn = jdbcTemplate.createStatement();
			userId = new UserDAO().selectForId(conn, userName, userEmail);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return userId;
	}

}
