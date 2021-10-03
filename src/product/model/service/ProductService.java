package product.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import product.model.dao.ProductDAO;
import product.model.vo.Product;
import product.model.vo.ProductReply;

public class ProductService {
	private JDBCTemplate jdbcTemplate;
	
	public ProductService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public List<Product> productAllList(String item, String selectOne) {
		Connection conn = null;
		List<Product> pList = null;
		try {
			conn = jdbcTemplate.createConnection();
			if(selectOne.equals("인기순")) {
				pList = new ProductDAO().productSortSaleList(conn, item);
				//System.out.println("실행(인기순/판매순)");
			}else {				
				pList = new ProductDAO().productAllList(conn, item);
				//System.out.println("최신순인데..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pList;
	}

	public int insertProduct(Product product) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ProductDAO().insertProduct(conn, product);
			if(result>0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int deleteProduct(String productCode) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ProductDAO().deleteProduct(conn, productCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public Product productDetail(String productCode) {
		Product product = null;
		Connection conn = null;
		List<ProductReply> replyList = null;
		ProductDAO pDAO = new ProductDAO();
		try {
			conn = jdbcTemplate.createConnection();
			product = pDAO.productDetail(conn, productCode);
			replyList = pDAO.selectAllProductReply(conn, productCode);
			product.setReplyList(replyList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return product;
	}

//	public int productReplyWrite(String productCode, String replyComment, String writerId, int replyScore) {
//		Connection conn = null;
//		int result = 0;
//		try {
//			conn= jdbcTemplate.createConnection();
//			result = new ProductDAO().productReplyWrite(conn, productCode, replyComment, writerId, replyScore);
//			if(result>0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(conn);
//		}
//		return result;
//	}

	public int productReplyWrite(String productCode, String replyComment, String writerId, int replyScore) {
		Connection conn = null;
		int result = 0;
		try {
			conn= jdbcTemplate.createConnection();
			result = new ProductDAO().productReplyWrite(conn, productCode, replyComment, writerId, replyScore);
			if(result>0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int productReplyModify(int productReplyNo, String productReplyContents) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ProductDAO().productReplyModify(conn, productReplyNo, productReplyContents);
			if(result>0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int productReplyDelete(int productReplyNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ProductDAO().productReplyDelete(conn, productReplyNo);
			if(result>0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public List<Product> productSearch(String searchKeyword) {
		Connection conn = null;
		List<Product> pList = null;
		//String searchPageNavi =null;
		try {
			conn = jdbcTemplate.createConnection();
			//System.out.println("검ㅅ개:"+ searchKeyword);
			pList = new ProductDAO().productSearch(conn, searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pList;
	}

	public List<Product> productAll() {
		Connection conn = null;
		List<Product> pList = null;
		//String searchPageNavi =null;
		try {
			conn = jdbcTemplate.createConnection();
			pList = new ProductDAO().productAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pList;
	}

	public int modifyProduct(String productCode) {
		
		return 0;
	}



}
