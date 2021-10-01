package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserEnroll
 */
@WebServlet("/user/enroll")
public class UserEnroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEnroll() {
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
		String userName = request.getParameter("user-name");
		String userEmail = request.getParameter("user-email");
		String userPhone = request.getParameter("user-phone");
		User user = new User(userId, userPwd, userName, userEmail, userPhone);
		
		int result = new UserService().userEnroll(user);
		
		if(result > 0) {
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/user/error.html");
		}
		
		
	}

}
