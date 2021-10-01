package member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCTemplate;
import member.model.vo.member;

public class memberDAO {

	public member selectOneLogin(Connection conn, String userId, String userPwd) {
		Statement stmt = null;
		ResultSet rset = null;
		member member = null;
		String query = "SELECT * FROM CUSTOMER WHERE USER_ID ='" 
				+ userId + "' AND USER_PWD ='" + userPwd + "'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return member;
	}

}
