package buyHistory.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyHistory.model.vo.BuyHistory;

/**
 * Servlet implementation class BuyHistorySuccessServlet
 */
@WebServlet("/buyhistory/success")
public class BuyHistorySuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyHistorySuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String orderNo = request.getParameter("orderNo");
		int price = Integer.parseInt(request.getParameter("price"));
		String productName = request.getParameter("productName");
		
		request.setAttribute("buyHistory", new BuyHistory(orderNo, price, productName, userId));
		request.getRequestDispatcher("/WEB-INF/views/payment/successPayment.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
