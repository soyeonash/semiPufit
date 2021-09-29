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


	public int updateQuotation(Quotation quotation) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new QuotationDAO().updateQuotation(conn,quotation);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public int sendAlarm(String userId, String designerId, String alarmContents) {
		int alarm = 0;
		Connection conn = null;
		
		try {
			conn= jdbcTemplate.createConnection();
			alarm = new QuotationDAO().sendAlarm(conn, userId, designerId, alarmContents);
			if(alarm > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return alarm;
	}


	public int sendQuotation(String designerId, int quotationNo) {
		int send = 0;
		Connection conn =null;
		
		try {
			conn = jdbcTemplate.createConnection();
			send = new QuotationDAO().sendQuotation(conn, designerId, quotationNo);
			if(send > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return send;
	}


	public Quotation quotationDesignerDetail(int quotationNo) {
		Connection conn = null;
		Quotation quotation = null;
		try {
			conn = jdbcTemplate.createConnection();
			quotation = new QuotationDAO().quotationDesignerDetail(conn,quotationNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return quotation;
	}


}
