package qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QnaService;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;

/**
 * Servlet implementation class QnaListServlet
 */
@WebServlet("/qna/list")
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int currentPage = 0;
//		String getCurrentPage = request.getParameter("currentPage");
//		if(getCurrentPage == null) {
//			currentPage = 1;
//		}else {
//			currentPage = Integer.parseInt(getCurrentPage);
//		}
//		PageData pageData = new NoticeService().printAllNotice(currentPage);
		QnaPageData qnaPageData = new QnaService().printAllQna();
		List<Qna> qList = qnaPageData.getQnaList();
//		if(!nList.isEmpty()) {
			request.setAttribute("qList", qList);
//			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.getRequestDispatcher("/WEB-INF/views/qna/qnaList.jsp").forward(request, response);
			System.out.println("qnalist들어옴");
//		}else {
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html");
//			view.forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
