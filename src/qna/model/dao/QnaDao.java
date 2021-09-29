package qna.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import qna.model.vo.Qna;

public class QnaDao {

	public List<Qna> selectAllQna(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM QNA";
		List<Qna> qList = null;
		try {
			pstmt = conn.prepareStatement(query); // 연결을 통해 statement 객체 생성
//			int viewCountPerPage = 10;
//			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
//			int end = currentPage * viewCountPerPage;
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
			rset = pstmt.executeQuery(); // 쿼리문 실행 후 rset으로 결과값 받기
			qList = new ArrayList<Qna>();
			while(rset.next()) { // rset에 데이터가 없을때 까지 반복
				Qna qna = new Qna(); // notice 객체를 이용해서 list에 데이터 담기
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setQnaTitle(rset.getString("QNA_TITLE"));
				qna.setQnaComments(rset.getString("QNA_COMMENTS"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setQnaImage(rset.getString("QNA_IMAGE"));
				qna.setUserId(rset.getString("USER_ID"));
				qna.setQnaPwd(rset.getString("QNA_PWD"));
				qList.add(qna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return qList;
	}

	public int insertQna(Connection conn, Qna qna) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO QNA VALUES(SEQ_QNA.NEXTVAL,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getQnaTitle());
			pstmt.setString(2, qna.getQnaComments());
			pstmt.setString(3, qna.getCategory());
			pstmt.setString(4, qna.getQnaImage());
			pstmt.setString(5, qna.getUserId());
			pstmt.setString(6, qna.getQnaPwd());
			qna.toString();
			// 쿼리문 실행 ***
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Qna selectOneByNo(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna qnaOne = null;
		String query = "SELECT * FROM QNA WHERE QNA_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				qnaOne = new Qna();
				qnaOne.setQnaNo(rset.getInt("QNA_NO"));
				qnaOne.setQnaTitle(rset.getString("QNA_TITLE"));
				qnaOne.setQnaComments(rset.getString("QNA_COMMENTS"));
				qnaOne.setCategory(rset.getString("CATEGORY"));
				qnaOne.setQnaImage(rset.getString("QNA_IMAGE"));
				qnaOne.setUserId(rset.getString("USER_ID"));
				qnaOne.setQnaPwd(rset.getString("QNA_PWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return qnaOne;
	}

}
