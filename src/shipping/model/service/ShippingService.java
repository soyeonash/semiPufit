package shipping.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import shipping.model.dao.ShippingDAO;
import shipping.model.vo.Shipping;

public class ShippingService {
	
	JDBCTemplate jdbcTemplate;
	
	public ShippingService() {
		jdbcTemplate = new JDBCTemplate().getConnection();
	}

	public List<Shipping> selectShippingList(String userId) {
		
		Connection conn = null;
		List<Shipping> shipping = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			shipping = new ShippingDAO().selectShippingList(userId, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(conn);
		}
		
		return shipping;
	}

	public int shippingCount(Shipping shipping) {
		
		Connection conn = null;
		int count = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			count = new ShippingDAO().userCheckShipping(conn, shipping);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		
		return count;
	}

	public int insertShipping(Shipping shipping) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ShippingDAO().insertShipping(conn, shipping);
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

	public int removeShipping(int shippingNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ShippingDAO().removeShipping(shippingNo, conn);
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

}
