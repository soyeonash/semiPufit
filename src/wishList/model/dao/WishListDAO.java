package wishList.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import wishList.model.vo.WishList;

public class WishListDAO {

	public int insertWishList(String userId, String productCode, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO WISHLIST VALUES(SEQ_WISHLIST.NEXTVAL, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<WishList> selectWishList(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		String sql = "SELECT WISHLIST_NO, PRODUCT_CODE, PRODUCT_IMAGE, PRODUCT_NAME, USER_ID FROM WISHLIST INNER JOIN PRODUCT USING(PRODUCT_CODE) WHERE USER_ID = ?";
		ResultSet rset = null;
		List<WishList> wList = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			wList = new ArrayList<WishList>();
			while(rset.next()) {
				WishList wishList = new WishList();
				wishList.setWishListNo(rset.getInt("WISHLIST_NO"));
				wishList.setProductCode(rset.getString("PRODUCT_CODE"));
				wishList.setProductImage(rset.getString("PRODUCT_IMAGE"));
				wishList.setProductName(rset.getString("PRODUCT_NAME"));
				wishList.setUserId(rset.getString("USER_ID"));
				wList.add(wishList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return wList;
	}

	public int removeWishList(int wishListNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM WISHLIST WHERE WISHLIST_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wishListNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
