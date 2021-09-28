package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewModifyServlet
 */
@WebServlet("/review/modify")
public class ReviewModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		Review reviewOne = new ReviewService().printOneByNo(reviewNo);
		request.setAttribute("reviewOne", reviewOne);
		request.getRequestDispatcher("/WEB-INF/views/review/reviewModify.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subject = request.getParameter("review-subject");
		String contents = request.getParameter("review-contents");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		Review review = new Review();
		review.setReviewSubject(subject);
		review.setReviewContents(contents);
		review.setReviewNo(reviewNo);
		int result = new ReviewService().modifyReview(review);
		if(result  > 0) {
			response.sendRedirect("/review/list");
		}else {
			System.out.println("수정실패");
		}
	}

}
