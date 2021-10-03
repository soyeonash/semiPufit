package designer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import designer.model.vo.Designer;

public class DesignerDAO {

	public int designerEnroll(Connection conn, Designer designer) {
		
		String sql = "INSERT INTO DESIGNER VALUES(?,?,?,?,?,?,?,?,DEFAULT,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, designer.getDesignerId());
			pstmt.setString(2, designer.getDesignerPwd());
			pstmt.setString(3, designer.getDesignerName());
			pstmt.setString(4, designer.getDesignerEmail());
			pstmt.setString(5, designer.getDesignerPhone());
			pstmt.setString(6, designer.getLicenseNo());
			pstmt.setString(7, designer.getAccountNo());
			pstmt.setString(8, designer.getBankName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Designer loginDesigner(String designerId, String designerPwd, Connection conn) {
		
		String sql = "SELECT * FROM DESIGNER WHERE DESIGNER_ID = ? AND DESIGNER_PWD = ?";
		PreparedStatement pstmt = null;
		Designer designer = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, designerId);
			pstmt.setString(2, designerPwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				designer = new Designer();
				designer.setDesignerId(rset.getString("DESIGNER_ID"));
				designer.setDesignerPwd(rset.getString("DESIGNER_PWD"));
				designer.setDesignerName(rset.getString("DESIGNER_NAME"));
				designer.setDesignerEmail(rset.getString("DESIGNER_EMAIL"));
				designer.setDesignerPhone(rset.getString("DESIGNER_PHONE"));
				designer.setLicenseNo(rset.getString("LICENSE_NO"));
				designer.setAccountNo(rset.getString("ACCOUNT_NO"));
				designer.setBankName(rset.getString("BANK_NAME"));
				designer.setSellCount(rset.getInt("SELL_COUNT"));
				designer.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return designer;
	}

}
