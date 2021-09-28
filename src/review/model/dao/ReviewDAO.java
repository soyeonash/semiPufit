package review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import review.model.vo.Review;

public class ReviewDAO {

	public List<Review> selectAllReview(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY REVIEW_NO DESC) AS NUM, REVIEW_NO,REVIEW_SUBJECT, REVIEW_CONTENTS, WRITER_ID, REVIEW_DATE FROM REVIEW) WHERE NUM BETWEEN ? AND ?";
		List<Review> rList = null;
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage*viewCountPerPage;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			rList = new ArrayList<Review>();
			while(rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setReviewSubject(rset.getString("REVIEW_SUBJECT"));
				review.setReviewContents(rset.getString("REVIEW_CONTENTS"));
				review.setWriterId(rset.getString("WRITER_ID"));
				review.setRegDate(rset.getDate("REVIEW_DATE"));
				rList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return rList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if(pageTotalCountMod > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		int startNavi = ((currentPage - 1) / pageCountPerView) * pageCountPerView + 1;
		int endNavi = startNavi + pageCountPerView - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/review/list?currentPage=" 
					+ (startNavi-1) + "'> [이전] </a>");
		}
		for(int i=startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i + " ");
			}else {
				sb.append("<a href='/review/list?currentPage=" + i +"'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/review/list?currentPage=" 
					+ (endNavi+1) + "'> [다음] </a>");
		}
		return sb.toString();
	}

	private int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM REVIEW";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return totalValue;
	}

	public Review selectOneByNo(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review reviewOne = null;
		String query = "SELECT* FROM REVIEW WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				reviewOne  = new Review();
				reviewOne.setReviewNo(rset.getInt("REVIEW_NO"));
				reviewOne.setReviewSubject(rset.getString("REVIEW_SUBJECT"));
				reviewOne.setReviewContents(rset.getString("REVIEW_CONTENTS"));
				reviewOne.setWriterId(rset.getString("WRITER_ID"));
				reviewOne.setReviewRecommend(rset.getInt("REVIEW_RECOMMEND"));
				reviewOne.setReportCount(rset.getInt("REPORT_COUNT"));
				reviewOne.setRegDate(rset.getDate("REVIEW_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return reviewOne;
	}

	public int updateReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE REVIEW SET REVIEW_SUBJECT = ?, REVIEW_CONTENTS = ? WHERE REVIEW_NO = ?";
		try {
			pstmt =  conn.prepareStatement(query);
			pstmt.setString(1, review.getReviewSubject());
			pstmt.setString(2, review.getReviewContents());
			pstmt.setInt(3, review.getReviewNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReview(Connection conn, int reviewNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM REVIEW WHERE REVIEW_NO = ?";
		try {
			pstmt =  conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO REVIEW VALUES(SEQ_REVIEW.NEXTVAL,?,?,?,DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getReviewSubject());
			pstmt.setString(2, review.getReviewContents());
			pstmt.setString(3, review.getWriterId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public List<Review> selectSearchPageNavi(Connection conn, String searchKeyword, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> rList  = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY REVIEW_NO DESC) AS NUM, REVIEW_NO, REVIEW_SUBJECT, RIVEW_CONTENTS, WRITER_ID, REG_DATE FROM REVIEW WHERE REVIEW_SUBJECT LIKE ?) WHERE NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			int viewCountPerPage = 10;
			int start = currentPage*viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage*viewCountPerPage;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rList = new ArrayList<Review>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
