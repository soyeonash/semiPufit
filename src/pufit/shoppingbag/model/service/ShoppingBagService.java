package pufit.shoppingbag.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import pufit.shoppingbag.dao.ShoppingBagDAO;
import pufit.shoppingbag.model.vo.ShoppingBag;
import pufit.shoppingbag.model.vo.ShoppingBagPageData;

public class ShoppingBagService {
	private JDBCTemplate jdbcTemplate;
	public ShoppingBagService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	public int insertShoppingBag(ShoppingBag shoppingBag) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new ShoppingBagDAO().insertShoppingBag(conn, shoppingBag);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public ShoppingBagPageData selectShoppingBag(String userId) {
		ShoppingBagPageData sbpd = new ShoppingBagPageData();
		Connection conn = null;
		ShoppingBagDAO sDAO = new ShoppingBagDAO();
		int totalPrice = 0;
		List<ShoppingBag> sList = null;
		try {
			conn= jdbcTemplate.createConnection();
			sList = sDAO.selectShoppingBagList(conn,userId);
			totalPrice = sDAO.shoppingBagTotalPrice(conn, userId);
			sbpd.setsList(sList);
			sbpd.setTotalPrice(totalPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return sbpd;
	}
	
}
