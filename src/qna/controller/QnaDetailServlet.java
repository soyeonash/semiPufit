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
@WebServlet("/qna/detail")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		Qna qnaOne = new QnaService().printOneByNo(qnaNo);
		if (qnaOne != null) {
			// 성공하면 디테일
			request.setAttribute("qnaOne", qnaOne);
			request.getRequestDispatcher("/WEB-INF/views/qna/qnaDetail.jsp").forward(request, response);
		}else {
//			// 실패하면 에러페이지
//			request.getRequestDispatcher("WEB-INF/views/qna/qnaError.html").forward(request, response);
			request.setAttribute("errorMsg", "게시글을 불러오다가 에러가 났습니다... 다시 해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/error/error.jsp").forward(request, response);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
