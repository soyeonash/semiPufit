package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.dao.memberDAO;
import member.model.vo.member;

public class memberService {

	private JDBCTemplate jdbcTemplate;
	
	public memberService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public member printOneLogin(String userId, String userPwd) {
		member member  = null;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			member = new memberDAO().selectOneLogin(conn, userId, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	
	
	
}
