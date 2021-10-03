package designer.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import designer.model.dao.DesignerDAO;
import designer.model.vo.Designer;

public class DesignerService {
	
	private JDBCTemplate jdbcTemplate;
	
	public DesignerService() {
		jdbcTemplate = new JDBCTemplate().getConnection();
	}

	public int designerEnroll(Designer designer) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createStatement();
			result = new DesignerDAO().designerEnroll(conn, designer);
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

	public Designer loginDesigner(String designerId, String designerPwd) {
		
		Connection conn = null;
		Designer designer = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createStatement();
			designer = new DesignerDAO().loginDesigner(designerId, designerPwd, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return designer;
	}

}
