package pufit.shoppingbag.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pufit.shoppingbag.model.service.ShoppingBagService;
import pufit.shoppingbag.model.vo.ShoppingBag;

/**
 * Servlet implementation class InsertShoppingBag
 */
@WebServlet("/shoppingBag/insertShoppingBag")
public class InsertShoppingBag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertShoppingBag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//session.getAttribute("userId")
		//String productCode = request.getParameter("productCode");
		String productCode = "C100002"; //상품페이지랑 연결해보고 바꿔야함
		String userId = "khuser01"; //나중에 바꿔야함
		ShoppingBag shoppingBag = new ShoppingBag();
		shoppingBag.setProductCode(productCode);
		shoppingBag.setUserId(userId);
		int result = new ShoppingBagService().insertShoppingBag(shoppingBag);
		if(result > 0) {
			request.getRequestDispatcher("/WEB-INF/shoppingBag/selectShoppingBag.jsp").forward(request, response);
		}else {
			System.out.println("실패했는데요?");
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
