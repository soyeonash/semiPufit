package pufit.quotation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.quotation.model.service.QuotationService;
import pufit.quotation.model.vo.Quotation;

/**
 * Servlet implementation class QuotationUpdate
 */
@WebServlet("/quotation/quotationUpdate")
public class QuotationUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuotationUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quotationNo = Integer.parseInt(request.getParameter("quotationNo"));
		Quotation quotation = new QuotationService().printQuotationDetail(quotationNo);
		request.setAttribute("quotation", quotation);
		
		request.getRequestDispatcher("/WEB-INF/quotation/updateQuotation.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int quotationNo = Integer.parseInt(request.getParameter("quotationNo"));
		int result = 0;
		Quotation quotation = new Quotation();
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		String category = request.getParameter("category");
		//이미지경로 및 파일저장 추가해야함
		quotation.setCategory(category);
		quotation.setQuotationSubject(subject);
		quotation.setContents(contents);
		quotation.setQuotationNo(quotationNo);
		result = new QuotationService().updateQuotation(quotation);
		if(result > 0) {
			response.sendRedirect("/quotation/userCheck");
		}else {
			request.getRequestDispatcher("/WEB-INF/quotation/error.jsp").forward(request, response);
		}
		
	
	}
	

}
