package pufit.product.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import pufit.product.model.dao.ProductDAO;
import pufit.product.model.vo.Product;

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
				System.out.println("실행안되요ㅜㅠㅠㅠㅠ..?(인기순)");
			}else {				
				pList = new ProductDAO().productAllList(conn, item);
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
		try {
			conn = jdbcTemplate.createConnection();
			product = new ProductDAO().productDetail(conn, productCode);
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

	public int productReplyWrite(String productCode, String replyComment, int replyScore) {
		Connection conn = null;
		int result = 0;
		try {
			conn= jdbcTemplate.createConnection();
			result = new ProductDAO().productReplyWrite(conn, productCode, replyComment, replyScore);
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
			pList = new ProductDAO().productSearch(conn, searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pList;
	}

}
