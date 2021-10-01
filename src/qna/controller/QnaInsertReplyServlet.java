package qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.model.service.QnaService;

/**
 * Servlet implementation class QnaInsertReplyServlet
 */
@WebServlet("/qnaReply/qnaInsertReply")
public class QnaInsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QnaInsertReplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/qna/qnaDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); // 로그인 한사람만 댓글 달 수 있게
		String replyContents = request.getParameter("replyContents");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String userId = (String) session.getAttribute("userId"); // 로그인 서블릿에서 userId로 저장을 했기때문에
		
		System.out.println(userId);
		System.out.println(replyContents);
		System.out.println(qnaNo);
		
		int result = new QnaService().insertQnaReply(qnaNo, replyContents, userId);
//		Notice noticeOne = new NoticeService().printOneByNo(noticeNo);
		if (result > 0) { // 결과값에 따라 view 선택
			// 상세페이지( 댓글 단 페이지로 이동
//			request.setAttribute("noticeOne", noticeOne);
//			request.getRequestDispatcher("WEB-INF/views/notice/noticeDetail.jsp").forward(request, response);
			response.sendRedirect("/qna/detail?qnaNo=" + qnaNo);
		} else {
			// 에러페이지
			request.setAttribute("errorMsg", "댓글 등록 에러입니다. 다시 해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/error/error.jsp").forward(request, response);
		}
	}
}
