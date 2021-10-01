package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String loginId = request.getParameter("id-bar");
		String loginPw = request.getParameter("pw-bar");
		User user = new UserService().loginUser(loginId, loginPw);
		if(user != null) {
			if("FALSE".equals(user.getAdmin())) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUserId());
				System.out.println("일반유저 로그인");
				request.getRequestDispatcher("/").forward(request, response);
			}else {
				System.out.println("관리자 페이지 이동");
				// 관리자 페이지
			}
			
		}else {
			System.out.println("로그인 실패");
		}
	}

}
