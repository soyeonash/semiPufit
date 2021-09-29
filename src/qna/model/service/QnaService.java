package qna.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import qna.model.dao.QnaDao;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;

public class QnaService {
	
	private JDBCTemplate jdbcTemplate;
	
	public QnaService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	
	public QnaPageData printAllQna() {
		QnaPageData qnaPageData = new QnaPageData();
		Connection conn = null;
		QnaDao qDAO = new QnaDao();
		try {
			conn = jdbcTemplate.createStatement();
			qnaPageData.setQnaList(qDAO.selectAllQna(conn)); 
//			pd.setPageNavi(nDAO.getPageNavi(conn, currentPage));
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
//		List<QnaReply> list = null;
		QnaDao qDao = new QnaDao();
		try {
			conn = jdbcTemplate.createStatement();
			qnaOne = new QnaDao().selectOneByNo(conn, qnaNo);
			// NoticeReply 불러옴
//			list = qDao.selectAllNoticeReply(conn, qnaeNo);
//			noticeOne.setReplies(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qnaOne;
	}
}
