package qna.controller;

import java.io.File;
import java.io.IOException;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.model.service.QnaService;
import qna.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertServlet
 */
@WebServlet("/qna/insert")
public class QnaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QnaInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/views/qna/qnaInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");

		String uploadFilePath = request.getServletContext().getRealPath("upload"); // Context 정보를 가지고 있는 객체??맞나
		System.out.println("업로드 리얼 패스 : " + uploadFilePath);
		int uploadFileLimit = 5 * 1024 * 1024; // 5MB, M -> 10^6;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileLimit, encType,
				new DefaultFileRenamePolicy());

		// 2. upload 폴더에 저장한 파일에 대한 정보를 DB에 저장하는 작업
		File uploadFile = multi.getFile("upFile");

		System.out.println("null??? ::: " + uploadFile);
		String filePath = "";
		String fileName = "";
		if (uploadFile != null) {
			filePath = uploadFile.getPath();
			fileName = "/upload/" + multi.getFilesystemName("upFile");
		} else {
			filePath = null;
			fileName = null;
		}

		HttpSession session = request.getSession();
		String title = multi.getParameter("qna-title");
		String pwd = multi.getParameter("qna-pwd");
		String comments = multi.getParameter("qna-comments");
		String category = multi.getParameter("qna-category");
		System.out.println(category);
		String writerId = (String) session.getAttribute("userId"); // LoginServlet 확인
		System.out.println(filePath);
		System.out.println(writerId);
		// Qna 객체에 정보 셋팅
		Qna qna = new Qna();
		qna.setQnaTitle(title);
		qna.setQnaPwd(pwd);
		qna.setQnaComments(comments);
		qna.setCategory(category);
		qna.setQnaImage(fileName);
		qna.setUserId(writerId);
		// Service에 넘겨서
		int result = new QnaService().insertQna(qna);
		// 결과 여부에 따라서 페이지 이동
		if (result > 0) {
//			// 작성성공 후에 noticeList.jsp를 보고 싶음
//			// 그렇다고 noticeList.jsp로 이동하는 것이 아니라
//			// 이미 noticeList.jsp를 보여주도록 하는 서블릿을 요청해서 볼 수 있도록 함
			response.sendRedirect("/qna/list");
		} else {
			request.setAttribute("errorMsg", "게시글 등록 에러입니다. 다시 해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/error/error.jsp").forward(request, response);
		}
	}
}
