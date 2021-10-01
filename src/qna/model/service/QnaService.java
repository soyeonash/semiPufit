package qna.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import qna.model.dao.QnaDao;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;
import qna.model.vo.QnaReply;

public class QnaService {
	
	private JDBCTemplate jdbcTemplate;
	
	public QnaService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public QnaPageData printAllQna(int currentPage) {
		QnaPageData qnaPageData = new QnaPageData();
		Connection conn = null;
		QnaDao qDAO = new QnaDao();
		try {
			conn = jdbcTemplate.createStatement();
			qnaPageData.setQnaList(qDAO.selectAllQna(conn,currentPage)); 
			qnaPageData.setPageNavi(qDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qnaPageData;
	}
	
	
	public int insertQna(Qna qna) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createStatement();
			result = new QnaDao().insertQna(conn, qna);
			if(result > 0) {
				// 커밋
				JDBCTemplate.commit(conn);
			}else {
				// 롤백
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;	
	}

	public Qna printOneByNo(int qnaNo) {
		Qna qnaOne = null;
		Connection conn = null;
		List<QnaReply> list = null;
		QnaDao qDao = new QnaDao();
		try {
			conn = jdbcTemplate.createStatement();
			qnaOne = new QnaDao().selectOneByNo(conn, qnaNo);
			
			list = qDao.selectAllQnaReply(conn, qnaNo);
			qnaOne.setReplies(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qnaOne;
	}

	public int insertQnaReply(int qnaNo, String replyContents, String userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createStatement();
			result = new QnaDao().insertQnaReply(conn, qnaNo, replyContents, userId);
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

	public QnaPageData printMyQna(String userId) {
		QnaPageData qnaPageData = new QnaPageData();
		Connection conn = null;
		QnaDao qDAO = new QnaDao();
		try {
			conn = jdbcTemplate.createStatement();
			qnaPageData.setQnaList(qDAO.selectMyQna(conn,userId)); 
//			pd.setPageNavi(nDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qnaPageData;
	}

	public Boolean passwordCheck(String password, int no) {
		Boolean bool = true;
		Connection conn = null;
		try {
			QnaDao qDAO = new QnaDao();
			conn = jdbcTemplate.createStatement();
		 bool = qDAO.passwordCheck(conn,password,no);
//			pd.setPageNavi(nDAO.getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return bool;
	}


}
