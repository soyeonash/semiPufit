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
 * Servlet implementation class QuotationCheck
 */
@WebServlet("/quotation/quotationCheck")
public class QuotationCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuotationCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session = request.getSession();
				// String userId = session.getAttribute(name);
				String userId = request.getParameter("userId");
				QuotationService qService = new QuotationService();
				PrintWriter writer = response.getWriter();
					List<Quotation> qList = qService.quotationUserList(userId);
					if (!qList.isEmpty()) {
						//request.setAttribute("quotationYN", "Y");
						writer.print("Y");
						request.getRequestDispatcher("/WEB-INF/quotation/userQuotationList.jsp").forward(request, response);
					
					} else {
						System.out.println("리스트없음!");
						//request.setAttribute("quotationYN", "N");
						writer.print("N");
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
