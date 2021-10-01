package qna.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import qna.model.vo.Qna;
import qna.model.vo.QnaReply;

public class QnaDao {

	public List<Qna> selectAllQna(Connection conn,int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT *FROM (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM ( SELECT * FROM QNA ORDER BY QNA.QNA_NO desc ) A ) WHERE RNUM >= ? AND RNUM <= ?";
		List<Qna> qList = null;
		try {
			pstmt = conn.prepareStatement(query); // 연결을 통해 statement 객체 생성
			int viewCountPerPage = 10;
			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
			int end = currentPage * viewCountPerPage;
			System.out.println("start ::: " +start );
			System.out.println("end ::: " +end );
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
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

	public int insertQnaReply(Connection conn, int qnaNo, String replyContents, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO QNA_REPLY VALUES(SEQ_QNA_REPLY.NEXTVAL,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			pstmt.setString(2, replyContents);
			pstmt.setString(3, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<QnaReply> selectAllQnaReply(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<QnaReply> qList = null;
		String query = "SELECT * FROM QNA_REPLY WHERE QNA_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			qList = new ArrayList<QnaReply>();
			rset = pstmt.executeQuery();
			while(rset.next()) {
				QnaReply reply = new QnaReply();
				reply.setQnaNo(rset.getInt("QNA_NO"));
				reply.setQnaReplyNo(rset.getInt("QNA_REPLY_NO"));
				reply.setReplyContents(rset.getString("QNA_REPLY_CONTENTS"));
				reply.setUserId(rset.getString("USER_ID"));
				
				
				qList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return qList;
	}

	public List<Qna> selectMyQna(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM QNA WHERE USER_ID = ?";
		List<Qna> qList = null;
		try {
			pstmt = conn.prepareStatement(query); // 연결을 통해 statement 객체 생성
//			int viewCountPerPage = 10;
//			int start = currentPage * viewCountPerPage - (viewCountPerPage - 1);
//			int end = currentPage * viewCountPerPage;
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
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

	public Boolean passwordCheck(Connection conn, String password, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna qnaOne = null;
		String query = "SELECT * FROM QNA WHERE QNA_NO = ? AND QNA_PWD = ?";
		Boolean bool = true;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			System.out.println(rset);
			if(rset.next()) {
				bool = true;
			}else {
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		

		return bool;
	}

	
	public int totalCount(Connection conn) {
		int totalValue = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNA";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		return totalValue;
	}
	
	public String getPageNavi(Connection conn, int currentPage) {
		int pageCountPerView = 5;
		int viewTotalCount = totalCount(conn);
		int viewCountPerPage = 10;
		int pageTotalCount = 0;
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if(pageTotalCountMod > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage +1;
		}else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		System.out.println("pageTotalCount :::"+pageTotalCount);
		System.out.println("viewTotalCount :::"+viewTotalCount);
		System.out.println("pageTotalCountMod :::"+pageTotalCountMod);
		int startNavi = ((currentPage -1 ) / pageCountPerView) * pageCountPerView + 1;
		int endNavi = startNavi + pageCountPerView - 1;
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		
		System.out.println("endNavi%5 :::"+endNavi%5);

		System.out.println("endNavi"+endNavi);
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		

		System.out.println("pageTotalCount2 :::"+pageTotalCount);
		System.out.println("endNavi2 :::"+endNavi);
		if(pageTotalCount == currentPage || endNavi - startNavi != 4 || endNavi*10>viewTotalCount) {
			needNext = false;
		}else {
			needNext = true;
		}
		System.out.println("endNavi"+endNavi);
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a title='이전 페이지' href='/qna/list?currentPage=" + (startNavi-1) + "'> ◀ </a>");
		}
		System.out.println("startNavi"+startNavi);
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<span>"+i+"</span>");
			}else {
				sb.append("<a href='/qna/list?currentPage=" + i +"'>" + i + " </a>");
			}
		}
		if(needNext) {
			sb.append("<a title='다음 페이지' href='/qna/list?currentPage=" + (endNavi+1) + "'> ▶ </a>");
		}
		return sb.toString();
	}

}
