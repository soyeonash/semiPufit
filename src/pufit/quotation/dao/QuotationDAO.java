package pufit.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import common.JDBCTemplate;
import pufit.quotation.model.vo.Quotation;

public class QuotationDAO {

	public List<Quotation> userQuotationList(Connection conn, String userId) {
		PreparedStatement pstmt =null;
		List<Quotation> qList = null;
		ResultSet rset = null;
		Quotation quotation = null;
		String query = "SELECT*FROM QUOTATION WHERE USER_ID = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			qList = new ArrayList<Quotation>();
			while(rset.next()) {
				quotation = new Quotation();
				quotation.setUserId(rset.getString("USER_ID"));
				quotation.setDesignerId(rset.getString("DESIGNER_ID"));
				quotation.setCategory(rset.getString("CATEGORY"));
				quotation.setQuotationImage(rset.getNString("QUOTATION_IMAGE"));
				quotation.setRegistrationDate(rset.getDate("QUOTATION_DATE"));
				quotation.setQuotationSubject(rset.getString("QUOTATION_SUBJECT"));
				quotation.setQuotationNo(rset.getInt("QUOTATION_NO"));
				quotation.setContents(rset.getString("QUOTATION_CONTENTS"));
				qList.add(quotation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return qList;
	}
	public List<Quotation> designerQuotationList(Connection conn, String userId) {
		PreparedStatement pstmt =null;
		List<Quotation> qList = null;
		ResultSet rset = null;
		Quotation quotation = null;
		String query = "SELECT*FROM QUOTATION WHERE DESIGNER_ID = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			qList = new ArrayList<Quotation>();
			while(rset.next()) {
				quotation = new Quotation();
				quotation.setUserId(rset.getString("USER_ID"));
				quotation.setDesignerId(rset.getString("DESIGNER_ID"));
				quotation.setCategory(rset.getString("CATEGORY"));
				quotation.setQuotationImage(rset.getNString("QUOTATION_IMAGE"));
				quotation.setRegistrationDate(rset.getDate("QUOTATION_DATE"));
				quotation.setQuotationSubject(rset.getString("QUOTATION_SUBJECT"));
				quotation.setQuotationNo(rset.getInt("QUOTATION_NO"));
				quotation.setContents(rset.getString("QUOTATION_CONTENTS"));
				qList.add(quotation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return qList;
	}

	public int userCheck(Connection conn, String userId) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query ="SELECT COUNT(*) AS COUNT FROM CUSTOMER WHERE USER_ID = ?";
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {				
				result = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int designerCheck(Connection conn, String userId) {
		int result = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = "SELECT COUNT(*) AS COUNT FROM DESIGNER WHERE DESIGNER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {				
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return result;
	}
	public int insertQuotation(Connection conn,Quotation quotation) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO QUOTATION VALUES(SEQ_QUOTATION.NEXTVAL,?,?,?,DEFAULT,?,?,?)";		
		System.out.println("DAO" + quotation.getContents());
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, quotation.getQuotationSubject());
			pstmt.setString(2, quotation.getCategory());
			pstmt.setString(3, quotation.getQuotationImage());
			pstmt.setString(4, quotation.getDesignerId());
			pstmt.setString(5, quotation.getUserId());
			pstmt.setString(6, quotation.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	public Quotation selectQuotation(Connection conn, int quotationNo) {
		PreparedStatement pstmt= null;
		Quotation quotation =null;
		ResultSet rset = null;
		String query = "SELECT * FROM QUOTATION WHERE QUOTATION_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, quotationNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				quotation = new Quotation();
				quotation.setUserId(rset.getString("USER_ID"));
				quotation.setDesignerId(rset.getString("DESIGNER_ID"));
				quotation.setCategory(rset.getString("CATEGORY"));
				quotation.setQuotationImage(rset.getNString("QUOTATION_IMAGE"));
				quotation.setRegistrationDate(rset.getDate("QUOTATION_DATE"));
				quotation.setQuotationSubject(rset.getString("QUOTATION_SUBJECT"));
				quotation.setQuotationNo(rset.getInt("QUOTATION_NO"));
				quotation.setContents(rset.getString("QUOTATION_CONTENTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return quotation;
	}
	public int deleteQuotation(Connection conn, int quotationNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM QUOTATION WHERE QUOTATION_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, quotationNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
