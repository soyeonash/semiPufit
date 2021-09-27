package designer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import designer.model.service.DesignerService;
import designer.model.vo.Designer;

/**
 * Servlet implementation class DesignerLoginServlet
 */
@WebServlet("/designer/login")
public class DesignerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesignerLoginServlet() {
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
		String designerId = request.getParameter("id-bar");
		String designerPwd = request.getParameter("pw-bar");
		Designer designer = new DesignerService().loginDesigner(designerId, designerPwd);
		
		if(designer != null) {
			System.out.println("로그인 성공");
			System.out.println(designer.toString());
//			HttpSession session = request.getSession();
//			session.setAttribute("designerId", designer.getDesignerId());
		}else {
			System.out.println("로그인 실패");
		}
		
	}

}
