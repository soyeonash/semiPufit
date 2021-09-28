package pufit.quotation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pufit.quotation.model.service.QuotationService;
import pufit.quotation.model.vo.Quotation;

/**
 * Servlet implementation class InsertQuotation
 */
@WebServlet("/quotation/insertQuotation")
public class InsertQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQuotation() {
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
		//HttpSession session = request.getSession();
		//String userId = session.getAttribute("userId");
		String userId = "khuser";
		String image = "image";
		String subject = request.getParameter("subject");
		String category = request.getParameter("category");
		String contents = request.getParameter("contents");
		//String image = request.getParameter("image");
		String designerId = "";
		Quotation quotation = new Quotation();
		quotation.setCategory(category);
		quotation.setQuotationSubject(subject);
		quotation.setContents(contents);
		quotation.setQuotationImage(image);
		quotation.setUserId(userId);
		quotation.setDesignerId(designerId);
		//System.out.println(quotation.getContents()); 확인용
		int result = new QuotationService().insertQuotation(quotation);
		if(result>0) {
			response.sendRedirect("/quotation/userCheck");
		}else {
			request.getRequestDispatcher("/quotation/error.jsp");
		}
	}

}
