package shipping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipping.model.service.ShippingService;
import shipping.model.vo.Shipping;

/**
 * Servlet implementation class InsertShippingServlet
 */
@WebServlet("/shipping/insert")
public class InsertShippingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertShippingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shippingMain = request.getParameter("shippingMain");
		String shippingSub = request.getParameter("shippingSub");
		String shippingName = request.getParameter("shippingName");
		String shippingPhone = request.getParameter("shippingPhone");
		String userId = request.getParameter("shippingId");
		
		Shipping shipping = new Shipping(shippingMain, shippingSub, shippingName, shippingPhone, userId);
		PrintWriter out = response.getWriter();
		
		int result = 0;
		int count = new ShippingService().shippingCount(shipping);
		if(count < 3) {
			result = new ShippingService().insertShipping(shipping);
			if(result > 0) {
				out.print(result);
			}else {
				request.getRequestDispatcher("/user/error.html").forward(request, response);
			}
		}else {
			out.print(3);
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
