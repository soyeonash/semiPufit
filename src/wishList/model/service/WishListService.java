package wishList.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import wishList.model.dao.WishListDAO;
import wishList.model.vo.WishList;

public class WishListService {
	
	private JDBCTemplate jdbcTemplate;
	
	public WishListService() {
		
		jdbcTemplate = new JDBCTemplate().getConnection();
		
	}
	

	public int insertWishList(String userId, String productCode) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new WishListDAO().insertWishList(userId, productCode, conn);
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


	public List<WishList> selectWishList(String userId) {
		
		Connection conn = null;
		List<WishList> wList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			wList = new WishListDAO().selectWishList(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return wList;
	}


	public int removeWishList(int wishListNo) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new WishListDAO().removeWishList(wishListNo, conn);
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
