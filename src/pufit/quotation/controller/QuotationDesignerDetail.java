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
 * Servlet implementation class QuotationDesignerDetail
 */
@WebServlet("/quotation/quotationDesignerDetail")
public class QuotationDesignerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuotationDesignerDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quotationNo = Integer.parseInt(request.getParameter("quotationNo"));
		Quotation quotation = new QuotationService().quotationDesignerDetail(quotationNo);
		if(quotation != null) {
			request.setAttribute("quotation", quotation);
			request.getRequestDispatcher("/WEB-INF/quotation/quotationDesignerDetail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/quotation/error.jsp");
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
