package shipping.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import shipping.model.vo.Shipping;

public class ShippingDAO {

	public List<Shipping> selectShippingList(String userId, Connection conn) {
		
		PreparedStatement pstmt = null;
		List<Shipping> sList = null;
		String sql = "SELECT * FROM SHIPPING WHERE USER_ID = ? ORDER BY SHIPPING_NO";
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			sList = new ArrayList<Shipping>();
			while(rset.next()) {
				Shipping shipping = new Shipping();
				shipping.setShippingNo(rset.getInt("SHIPPING_NO"));
				shipping.setShippingMain(rset.getString("SHIPPING_MAIN"));
				shipping.setShippingSub(rset.getString("SHIPPING_SUB"));
				shipping.setShippingName(rset.getString("SHIPPING_NAME"));
				shipping.setShippingPhone(rset.getString("SHIPPING_PHONE"));
				shipping.setUserId(rset.getString("USER_ID"));
				sList.add(shipping);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return sList;
	}

	public int userCheckShipping(Connection conn, Shipping shipping) {
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) COUNTCHECK FROM SHIPPING WHERE USER_ID = ?";
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shipping.getUserId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getInt("COUNTCHECK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return 0;
	}

	public int insertShipping(Connection conn, Shipping shipping) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO SHIPPING VALUES(SEQ_SHIPPING.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shipping.getShippingMain());
			pstmt.setString(2, shipping.getShippingSub());
			pstmt.setString(3, shipping.getShippingName());
			pstmt.setString(4, shipping.getShippingPhone());
			pstmt.setString(5, shipping.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int removeShipping(int shippingNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM SHIPPING WHERE SHIPPING_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shippingNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt); 
		}
		
		return result;
	}

}