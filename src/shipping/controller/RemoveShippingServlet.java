package shipping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipping.model.service.ShippingService;

/**
 * Servlet implementation class RemoveShippingServlet
 */
@WebServlet("/shipping/remove")
public class RemoveShippingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveShippingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shippingNo = Integer.parseInt(request.getParameter("shippingNo"));
		String userId = request.getParameter("userId");
		int result = new ShippingService().removeShipping(shippingNo);
		if(result > 0) {
			response.sendRedirect("/user/practice?userId=" + userId);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/user/error.html").forward(request, response);
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
