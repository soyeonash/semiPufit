package buyHistory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import buyHistory.model.vo.BuyHistory;
import buyHistory.service.BuyHistoryService;
import buyHistory.util.BuyHistoryUtil;

/**
 * Servlet implementation class InsertBuyHistoryServlet
 */
@WebServlet("/buyhistory/insert")
public class InsertBuyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBuyHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		String orderNo = BuyHistoryUtil.getUUIDorderNo();
		String userId = request.getParameter("userId");
		int price = Integer.parseInt(request.getParameter("price"));
		String productName = request.getParameter("productName");
		String paymentMethod = request.getParameter("paymentMethod");
		BuyHistory buyHistory = new BuyHistory(orderNo, price, productName, userId, paymentMethod);
		System.out.println(orderNo + " " + userId + " " + price + " " + productName + " " + paymentMethod);
		
		int result = new BuyHistoryService().insertHistory(buyHistory);
		
		response.getWriter().write(gson.toJson(buyHistory));
	
	}

}
