package member.model.service;

import common.JDBCTemplate;
import member.model.vo.member;

public class memberService {

	private JDBCTemplate jdbcTemplate;
	
	public memberService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public member printOneLogin(String userId, String userPwd) {

		return null;
	}
	
	
	
	
	
}
