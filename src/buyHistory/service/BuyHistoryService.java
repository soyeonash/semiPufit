package buyHistory.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import buyHistory.model.dao.BuyHistoryDAO;
import buyHistory.model.vo.BuyHistory;
import common.JDBCTemplate;

public class BuyHistoryService {
	
	private JDBCTemplate jdbcTemplate;
	
	public BuyHistoryService() {
		
		jdbcTemplate = new JDBCTemplate().getConnection();
		
	}

	public int insertHistory(BuyHistory buyHistory) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new BuyHistoryDAO().insertBuyHistory(conn, buyHistory);
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

	public List<BuyHistory> selectBuyHistoryList(String userId) {
		
		Connection conn = null;
		List<BuyHistory> bList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			bList = new BuyHistoryDAO().selectBuyHistoryList(userId, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return bList;
	}

}
