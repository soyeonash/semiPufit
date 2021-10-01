package review.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import review.model.dao.ReviewDAO;
import review.model.vo.PageData;
import review.model.vo.Review;
import review.model.vo.ReviewReply;

public class ReviewService {
	
	private JDBCTemplate jdbcTemplate;
	
	public ReviewService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}

	public PageData printAllReview(int currentPage) {
		PageData pd = new PageData();
		Connection conn = null;
		ReviewDAO rDAO = new ReviewDAO();
		try {
			conn = jdbcTemplate.createConnection();
			List<Review> rList = rDAO.selectAllReview(conn, currentPage);
			String pageNavi = rDAO.getPageNavi(conn, currentPage);
			pd.setReviewList(rList);
			pd.setPageNavi(pageNavi); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public Review printOneByNo(int reviewNo) {
		Review reviewOne  = null;
		Connection conn = null;
		List<ReviewReply> list = null;
		ReviewDAO rDao = new ReviewDAO();
		try {
			conn = jdbcTemplate.createConnection();
			reviewOne  = rDao.selectOneByNo(conn, reviewNo);
			list = rDao.selectAllReviewReply(conn, reviewNo);
			reviewOne.setReplies(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return reviewOne;
	}

	public int modifyReview(Review review) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReviewDAO().updateReview(conn, review);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int removeReview(int reviewNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReviewDAO().deleteReview(conn, reviewNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

	public int registerReview(Review review) {
		int result  = 0;
		Connection conn = null;
		try {
			conn =  jdbcTemplate.createConnection();
			result = new ReviewDAO().insertReview(conn, review);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public PageData printSearchReview(String searchKeyword, int currentPage) {
		Connection conn = null;
		List<Review> rList = null;
		String searchPageNavi = null;
		PageData pd = new PageData();
		ReviewDAO rDAO  = new ReviewDAO();
		try {
			conn = jdbcTemplate.createConnection();
			rList  = rDAO.selectSearchReview(conn, searchKeyword, currentPage);
			searchPageNavi = rDAO.getSearchPageNavi(conn, searchKeyword, currentPage);
			pd.setReviewList(rList);
			pd.setPageNavi(searchPageNavi);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public int registerReviewReply(int reviewNo, String replyContents, String writerId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReviewDAO().insertReviewReply(conn, reviewNo, replyContents, writerId);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int modifyReplyOne(int replyNo, String replyContents) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result = new ReviewDAO().updateReviewReply(conn, replyNo, replyContents);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int removeReviewReply(int replyNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = jdbcTemplate.createConnection();
			result  = new ReviewDAO().deleteReviewReplyOne(conn, replyNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
