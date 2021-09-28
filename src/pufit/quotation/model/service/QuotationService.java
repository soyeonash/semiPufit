package pufit.quotation.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import pufit.quotation.dao.QuotationDAO;
import pufit.quotation.model.vo.Quotation;

public class QuotationService {
	private JDBCTemplate jdbcTemplate;
	public QuotationService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	
	public List<Quotation> quotationUserList(String userId) {
		Connection conn = null;
		List<Quotation> qList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			qList = new QuotationDAO().userQuotationList(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return qList;
	}
	
	public List<Quotation> quotationDesignerList(String userId) {
		Connection conn = null;
		List<Quotation> qList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			qList = new QuotationDAO().designerQuotationList(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return qList;
	}



	public int userCheck(String userId) {
		Connection conn =null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new QuotationDAO().userCheck(conn, userId);					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}	
		return result;
	}


	public int designerCheck(String userId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new QuotationDAO().designerCheck(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}


	public int insertQuotation(Quotation quotation) {
		Connection conn = null;
		int result = 0;
		System.out.println("서비스" + quotation.getContents());
		try {
			conn = jdbcTemplate.createConnection();
			result = new QuotationDAO().insertQuotation(conn,quotation);
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


	public Quotation printQuotationDetail(int quotationNo) {
		Connection conn = null;
		Quotation quotation = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			quotation = new QuotationDAO().selectQuotation(conn, quotationNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return quotation;
	}


	public int deleteQuotation(int quotationNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new QuotationDAO().deleteQuotation(conn, quotationNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}				
		return result;
	}


}
