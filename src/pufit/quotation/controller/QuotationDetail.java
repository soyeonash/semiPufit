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
 * Servlet implementation class QuotationDetail
 */
@WebServlet("/quotation/quotationDetail")
public class QuotationDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuotationDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("파싱전"+request.getParameter("quotationNo"));
		int quotationNo = Integer.parseInt(request.getParameter("quotationNo"));
		System.out.println("파싱후"+ quotationNo);
		Quotation quotationOne = new QuotationService().printQuotationDetail(quotationNo);		
		if(quotationOne != null) {
			request.setAttribute("quotation", quotationOne);
			request.getRequestDispatcher("/WEB-INF/quotation/quotationDetail.jsp").forward(request, response);;
		}else {
			request.getRequestDispatcher("/WEB-INF/quotation/error.jsp").forward(request, response);;
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
