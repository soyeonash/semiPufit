package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipping.model.service.ShippingService;
import shipping.model.vo.Shipping;
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class SelectPracticeServlet
 */
@WebServlet("/user/practice")
public class SelectPracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPracticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = new UserService().printOneById(userId);
		List<Shipping> sList = new ShippingService().selectShippingList(userId);
		System.out.println("배송 사이즈 : " + sList.size());
		if(user != null) {
			request.setAttribute("user", user);
			request.setAttribute("sList", sList);
			request.getRequestDispatcher("/WEB-INF/views/payment/userPayment.jsp").forward(request, response);
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
