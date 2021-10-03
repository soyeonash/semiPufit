package shipping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipping.model.service.ShippingService;
import shipping.model.vo.Shipping;

/**
 * Servlet implementation class SelectShippingListServlet
 */
@WebServlet("/shipping/list")
public class SelectShippingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectShippingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		List<Shipping> sList = new ShippingService().selectShippingList(userId);
		PrintWriter out = response.getWriter();
		System.out.println(sList.size());
		// 장바구니 리스트 가져오기
		if(!sList.isEmpty()) {
			request.setAttribute("sList", sList);
			request.getRequestDispatcher("/WEB-INF/views/payment/userPayment.jsp").forward(request, response);
		}else {
			out.print("NULL");
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
