package designer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import designer.model.service.DesignerService;
import designer.model.vo.Designer;

/**
 * Servlet implementation class DesignerEnrollServlet
 */
@WebServlet("/designer/enroll")
public class DesignerEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesignerEnrollServlet() {
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
		String designerId = request.getParameter("designer-id");
		String designerPwd = request.getParameter("designer-pw");
		String designerName = request.getParameter("designer-name");
		String designerEmail = request.getParameter("designer-email");
		String designerPhone = request.getParameter("designer-phone");
		String licenseNo = request.getParameter("designer-license");
		String accountNo = request.getParameter("designer-account");
		String bankName = request.getParameter("designer-bank");
		Designer designer = new Designer(designerId, designerPwd, designerName, designerEmail, designerPhone, licenseNo, accountNo, bankName);
		int result = new DesignerService().designerEnroll(designer);
		if(result > 0) {
			System.out.println("회원가입 성공");
		}else {
			request.getRequestDispatcher("/user/error.html");
		}
		
	}

}
