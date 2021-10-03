package product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import product.model.vo.Product;
import product.model.vo.ProductReply;

public class ProductDAO {
	public ProductDAO() {}

	public List<Product> productAllList(Connection conn, String item) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Product> pList = null;
		String query = "SELECT * FROM PRODUCT WHERE ROW_KIND=? ORDER BY PRODUCT_DATE DESC";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, item);
			rset = pstmt.executeQuery();
			
			pList = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setProductCode(rset.getString("PRODUCT_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductImage(rset.getString("PRODUCT_IMAGE"));
				product.setRegistrationDate(rset.getDate("PRODUCT_DATE"));
				product.setProductPrice(rset.getString("PRODUCT_PRICE"));
				product.setProductSize(rset.getString("PRODUCT_SIZE"));
				product.setSaleCount(rset.getInt("SALE_COUNT"));
				product.setHighKind(rset.getString("HIGH_KIND"));
				product.setRowKind(rset.getString("ROW_KIND"));
				product.setProductContents(rset.getString("PRODUCT_CONTENTS"));
				product.setProductImgName(rset.getString("PRODUCT_IMG_NAME"));
				pList.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return pList;
	}

	public List<Product> productSortSaleList(Connection conn, String item) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Product> pList = null;
//		System.out.println("아잍[ㅁ : "+item);
//		System.out.println("실행안되요..?(DAO)");
		String query = "SELECT * FROM PRODUCT WHERE ROW_KIND=? ORDER BY SALE_COUNT DESC";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, item);
			rset = pstmt.executeQuery();
			
			pList = new ArrayList<Product>();
			while(rset.next()) {
				Product product = new Product();
				product.setProductCode(rset.getString("PRODUCT_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductImage(rset.getString("PRODUCT_IMAGE"));
				product.setRegistrationDate(rset.getDate("PRODUCT_DATE"));
				product.setProductPrice(rset.getString("PRODUCT_PRICE"));
				product.setProductSize(rset.getString("PRODUCT_SIZE"));
				product.setSaleCount(rset.getInt("SALE_COUNT"));
				product.setHighKind(rset.getString("HIGH_KIND"));
				product.setRowKind(rset.getString("ROW_KIND"));
				product.setProductContents(rset.getString("PRODUCT_CONTENTS"));
				product.setProductImgName(rset.getString("PRODUCT_IMG_NAME"));
				pList.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return pList;
	}

	public int insertProduct(Connection conn, Product product) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO PRODUCT VALUES(?, ?, ?, SYSDATE, ?, ?, 0, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getProductCode());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getProductImage());
			pstmt.setString(4, product.getProductSize());
			pstmt.setString(5, product.getProductPrice());
			pstmt.setString(6, product.getHighKind());
			pstmt.setString(7, product.getRowKind());
			pstmt.setString(8, product.getProductContents());
			pstmt.setString(9, product.getProductImgName());
		
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteProduct(Connection conn, String productCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="DELETE FROM PRODUCT WHERE PRODUCT_CODE=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Product productDetail(Connection conn, String productCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product product = null;
		String query = "SELECT * FROM PRODUCT WHERE PRODUCT_CODE=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productCode);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				product = new Product();
				product.setProductCode(rset.getString("PRODUCT_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductImage(rset.getString("PRODUCT_IMAGE"));
				product.setRegistrationDate(rset.getDate("PRODUCT_DATE"));
				product.setProductPrice(rset.getString("PRODUCT_PRICE"));
				product.setProductSize(rset.getString("PRODUCT_SIZE"));
				product.setSaleCount(rset.getInt("SALE_COUNT"));
				product.setHighKind(rset.getString("HIGH_KIND"));
				product.setRowKind(rset.getString("ROW_KIND"));
				product.setProductContents(rset.getString("PRODUCT_CONTENTS"));
				product.setProductImgName(rset.getString("PRODUCT_IMG_NAME"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return product;
	}

//	public int productReplyWrite(Connection conn, String productCode, String replyComment, String writerId,
//			int replyScore) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String query="INSERT INTO PRODUCT_REPLY VALUES(SEQ_PRODUCT_REPLY.NEXTVAL, ?, ?, ?, SYSDATE, ?, DEFAULT)";
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, productCode);
//			pstmt.setString(2, replyComment);
//			pstmt.setString(3, writerId);
//			pstmt.setInt(4, replyScore);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return result;
//	}

	public int productReplyWrite(Connection conn, String productCode, String replyComment, String writerId, int replyScore) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="INSERT INTO PRODUCT_REPLY VALUES(SEQ_PRODUCT_REPLY.NEXTVAL, ?, ?, 'admin', SYSDATE, ?, DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productCode);
			pstmt.setString(2, replyComment);
			pstmt.setInt(3, replyScore);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int productReplyModify(Connection conn, int productReplyNo, String productReplyContents) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE PRODUCT_REPLY SET PRODUCT_REPLY_CONTENTS=? WHERE PRODUCT_REPLY_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productReplyContents);
			pstmt.setInt(2, productReplyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int productReplyDelete(Connection conn, int productReplyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM PRODUCT_REPLY WHERE PRODUCT_REPLY_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productReplyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<Product> productSearch(Connection conn, String searchKeyword) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		List<Product> pList = null;
		//System.out.println("서치 : "+searchKeyword);
		String query = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pList = new ArrayList<Product>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product product = new Product();
				product.setProductCode(rset.getString("PRODUCT_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductImage(rset.getString("PRODUCT_IMAGE"));
				product.setRegistrationDate(rset.getDate("PRODUCT_DATE"));
				product.setProductPrice(rset.getString("PRODUCT_PRICE"));
				product.setProductSize(rset.getString("PRODUCT_SIZE"));
				product.setSaleCount(rset.getInt("SALE_COUNT"));
				product.setHighKind(rset.getString("HIGH_KIND"));
				product.setRowKind(rset.getString("ROW_KIND"));
				product.setProductContents(rset.getString("PRODUCT_CONTENTS"));
				product.setProductImgName(rset.getString("PRODUCT_IMG_NAME"));
				pList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pList;
	}

	public List<ProductReply> selectAllProductReply(Connection conn, String productCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="SELECT * FROM PRODUCT_REPLY WHERE PRODUCT_CODE=?";
		List<ProductReply> replyList = null;
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, productCode);
			replyList = new ArrayList<ProductReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ProductReply reply = new ProductReply();
				reply.setProductReplyNo(rset.getInt("PRODUCT_REPLY_NO"));
				reply.setProductCode(rset.getString("PRODUCT_CODE"));
				reply.setProductReplyContents(rset.getString("PRODUCT_REPLY_CONTENTS"));
				reply.setWriterId(rset.getString("WRITER_ID"));
				reply.setProductReplyDate(rset.getDate("PRODUCT_REPLY_DATE"));
				reply.setProductReplyScore(rset.getInt("PRODUCT_REPLY_SCORE"));
				reply.setProductReportCount(rset.getInt("REPORT_COUNT"));
				
				replyList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return replyList;
	}

	public List<Product> productAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query="SELECT * FROM PRODUCT";
		List<Product> pList = null;
		try {
			pstmt =conn.prepareStatement(query);
			pList = new ArrayList<Product>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setProductCode(rset.getString("PRODUCT_CODE"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setProductImage(rset.getString("PRODUCT_IMAGE"));
				p.setRegistrationDate(rset.getDate("PRODUCT_DATE"));
				p.setProductPrice(rset.getString("PRODUCT_PRICE"));
				p.setProductSize(rset.getString("PRODUCT_SIZE"));
				p.setSaleCount(rset.getInt("SALE_COUNT"));
				p.setHighKind(rset.getString("HIGH_KIND"));
				p.setRowKind(rset.getString("ROW_KIND"));
				p.setProductContents(rset.getString("PRODUCT_CONTENTS"));
				p.setProductImgName(rset.getString("PRODUCT_IMG_NAME"));
				
				pList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pList;
	}
	
	

}
