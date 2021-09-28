package pufit.quotation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pufit.quotation.model.service.QuotationService;
import pufit.quotation.model.vo.Quotation;

/**
 * Servlet implementation class QuotationUserList
 */
@WebServlet("/quotation/quotationUserList")
public class QuotationUserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuotationUserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession session = request.getSession();
		// String userId = session.getAttribute(name);
		String userId = "khuser";
		QuotationService qService = new QuotationService();
		int result = qService.userCheck(userId);
		int result2 = qService.designerCheck(userId);
		if (result > 0 && result2 == 0) {
			List<Quotation> qList = qService.quotationUserList(userId);
			if (!qList.isEmpty()) {
				request.getRequestDispatcher("/WEB-INF/quotation/userQuotationList.jsp").forward(request, response);
				request.setAttribute("qList", qList);
				System.out.println("유저임!");
			} else {
				System.out.println("리스트없음!");
				request.setAttribute("qutationYN", "N");
				request.getRequestDispatcher("/WEB-INF/quotation/userQuotationCheck.jsp").forward(request, response);
			}

		} else if (result == 0 && result2 > 0) {
			List<Quotation> qList = qService.quotationDesignerList(userId);
			request.setAttribute("qList", qList);
			request.getRequestDispatcher("/WEB-INF/quotation/designerQuotationList.jsp").forward(request, response);
			System.out.println("디자이너임!");
		} else if (result == 0 && result2 == 0) {
			System.out.println("회원아님!");
			request.setAttribute("userYN", "N");
			request.getRequestDispatcher("/WEB-INF/quotation/error.jsp").forward(request, response);
			System.out.println((String)request.getAttribute("userYN"));
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
