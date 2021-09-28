package review.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import review.model.dao.ReviewDAO;
import review.model.vo.PageData;
import review.model.vo.Review;

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
		ReviewDAO rDao =  new ReviewDAO();
		try {
			conn = jdbcTemplate.createConnection();
			reviewOne  = rDao.selectOneByNo(conn, reviewNo);
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
			rList  = rDAO.selectSearchPageNavi(conn, searchKeyword, currentPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}
}
