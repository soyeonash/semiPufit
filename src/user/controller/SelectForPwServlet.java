package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;

/**
 * Servlet implementation class SelectForPwServlet
 */
@WebServlet("/ajax/forPw")
public class SelectForPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectForPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		String userPw = new UserService().selectForPw(userId, userEmail);
		PrintWriter out = response.getWriter();
		int result = 3;
		System.out.println(userId + userEmail);
		
		if("NO".equals(userPw)) {
			out.print(userPw);
		}else {
			result = new UserService().modifyUserPassWord(userId);
			if(result > 0) {
				out.print(result);
			}else {
				result = new UserService().modifyDesignerPassWord(userId);
				out.print(result);
			}
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
