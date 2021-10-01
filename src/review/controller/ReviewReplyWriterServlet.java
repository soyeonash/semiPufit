package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewReplyWriterServlet
 */
@WebServlet("/reviewReply/write")
public class ReviewReplyWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReplyWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String replyContents =  request.getParameter("replyContents");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String writerId = (String)session.getAttribute("userId");
		int result = new ReviewService().registerReviewReply(reviewNo, replyContents, writerId);
		if(result > 0) {
			response.sendRedirect("/review/detail?reviewNo" + reviewNo);
		}else{
			System.out.println("댓글작성 실패");
		}
	}
}
