package pufit.shoppingbag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import pufit.shoppingbag.model.vo.ShoppingBag;

public class ShoppingBagDAO {

	public int insertShoppingBag(Connection conn, ShoppingBag shoppingBag) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO SHOPPINGBAG VALUES(SEQ_SHOPPINGBAG.NEXTVAL, ?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, shoppingBag.getUserId());
			pstmt.setString(2, shoppingBag.getProductCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<ShoppingBag> selectShoppingBagList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ShoppingBag> sList = null;
		ShoppingBag shoppingBag = null;
		String query = "SELECT SHOP.SHOPPING_CODE AS SHOP_CODE, SHOP.USER_ID AS SHOP_ID, SHOP.PRODUCT_CODE AS SHOP_PR_CODE, PR.PRODUCT_NAME AS PR_NAME, PR.PRODUCT_CONTENTS AS PR_CONTENTS, PR.PRODUCT_PRICE AS PR_PRICE, PR.PRODUCT_IMG_NAME AS PR_IMG_NAME\r\n" + 
				"FROM SHOPPINGBAG SHOP JOIN PRODUCT PR \r\n" + 
				"ON SHOP.PRODUCT_CODE = PR.PRODUCT_CODE\r\n" + 
				"WHERE SHOP.USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			sList = new ArrayList<ShoppingBag>();
			while(rset.next()) {
				shoppingBag = new ShoppingBag();
				shoppingBag.setProductCode(rset.getString("SHOP_PR_CODE"));
				shoppingBag.setShoppingBagCode(rset.getInt("SHOP_CODE"));
				shoppingBag.setUserId(rset.getString("SHOP_ID"));
				shoppingBag.setShoppingBagProductContents(rset.getString("PR_CONTENTS"));
				shoppingBag.setShoppingBagProductPrice(rset.getInt("PR_PRICE"));
				shoppingBag.setShoppingBagProductName(rset.getString("PR_NAME"));
				shoppingBag.setShoppingBagProductImageName(rset.getString("PR_IMG_NAME"));
				sList.add(shoppingBag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return sList;
	}

	public int shoppingBagTotalPrice(Connection conn, String userId) {
		int shoppingBagTotalPrice = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT SUM(PR.PRODUCT_PRICE) AS TOTALPRICE FROM SHOPPINGBAG SHOP JOIN PRODUCT PR\r\n" + 
				"ON SHOP.PRODUCT_CODE = PR.PRODUCT_CODE\r\n" + 
				"WHERE SHOP.USER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				shoppingBagTotalPrice = rset.getInt("TOTALPRICE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return shoppingBagTotalPrice;
	}

}
