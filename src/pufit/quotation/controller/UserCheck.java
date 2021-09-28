package pufit.quotation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.quotation.model.service.QuotationService;
import pufit.quotation.model.vo.Quotation;

/**
 * Servlet implementation class UserCheck
 */
@WebServlet("/quotation/userCheck")
public class UserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session = request.getSession();
		// String userId = session.getAttribute(name);
		String userId = "khuser";
		QuotationService qService = new QuotationService();
//		PrintWriter writer = response.getWriter(); 한글깨짐 오류 원흉
		int result = qService.userCheck(userId);
		int result2 = qService.designerCheck(userId);
		if (result > 0 && result2 == 0) {
			//System.out.println("일반유저");
			//request.setAttribute("userYN", "Y");
			//writer.print("Y");
			List<Quotation> qList = qService.quotationUserList(userId);
			if(!qList.isEmpty()) {
				System.out.println("ㅇㅇ 제대로옴");
			}else {
				System.out.println("없는데?");
			}
			request.setAttribute("qList", qList);
			request.setAttribute("userTest", "test");
			request.setAttribute("userYN", "N");
			request.getRequestDispatcher("/WEB-INF/quotation/userQuotationList.jsp").forward(request, response);
			//System.out.println(request.getAttribute("userYN"));
		} else if (result == 0 && result2 > 0) {
			List<Quotation> qList = qService.quotationDesignerList(userId);
//			request.setAttribute("qList", qList);
//			request.setAttribute("userTest", "test");
//			request.setAttribute("userYN", "N");
			request.getRequestDispatcher("/WEB-INF/quotation/designerQuotationList.jsp").forward(request, response);
			System.out.println("디자이너임!");
			//System.out.println(request.getAttribute("userYN"));
		} else if (result == 0 && result2 == 0) {
			System.out.println("회원아님!");
			//request.setAttribute("userYN", "N");
			//writer.print("N");
			
		};
	
	}

}
