package buyHistory.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buyHistory.model.vo.BuyHistory;
import common.JDBCTemplate;

public class BuyHistoryDAO {

	public int insertBuyHistory(Connection conn, BuyHistory buyHistory) {
		
		String sql = "INSERT INTO BUYHISTORY VALUES(?, DEFAULT, ?, ?, DEFAULT, ?, ?)";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buyHistory.getOrderNo());
			pstmt.setInt(2, buyHistory.getPrice());
			pstmt.setString(3, buyHistory.getProductName());
			pstmt.setString(4, buyHistory.getUserId());
			pstmt.setString(5, buyHistory.getPaymentMethod());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<BuyHistory> selectBuyHistoryList(String userId, Connection conn) {
		
		List<BuyHistory> bList = null;
		String sql = "SELECT ROWNUM, ORDER_NO, SHIPPING_STATUS, PRICE, PRODUCT_NAME, BUY_DATE FROM (SELECT ROWNUM, ORDER_NO, SHIPPING_STATUS, PRICE, PRODUCT_NAME, BUY_DATE FROM BUYHISTORY A WHERE USER_ID = ? ORDER BY BUY_DATE DESC) WHERE ROWNUM BETWEEN 1 AND 10";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			bList = new ArrayList<BuyHistory>();
			while(rset.next()) {
				BuyHistory buyHistory = new BuyHistory();
				buyHistory.setOrderNo(rset.getString("ORDER_NO"));
				buyHistory.setProductName(rset.getString("PRODUCT_NAME"));
				buyHistory.setPrice(rset.getInt("PRICE"));
				buyHistory.setBuyDate(rset.getDate("BUY_DATE"));
				buyHistory.setShippingStatus(rset.getString("SHIPPING_STATUS"));
				bList.add(buyHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bList;
	}

}
