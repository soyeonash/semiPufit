package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;

/**
 * Servlet implementation class UserModify
 */
@WebServlet("/user/modify")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
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
		String userId = request.getParameter("user-id");
		String userPwd = request.getParameter("user-pw");
		String userEmail = request.getParameter("user-email");
		String userPhone = request.getParameter("user-phone");
		System.out.println(userId + " " + userPwd + " " + userEmail + " " + userPhone);
		int result = new UserService().UserModify(userId, userPwd, userEmail, userPhone);
		if(result > 0) {
			response.sendRedirect("/user/mypage"); // selectId 출력후 페이지 이동
		}else {
			request.getRequestDispatcher("/WEB-INF/views/user/error.html").forward(request, response);
		}
				
	}

}
