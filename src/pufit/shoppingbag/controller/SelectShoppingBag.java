package pufit.shoppingbag.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pufit.shoppingbag.model.service.ShoppingBagService;
import pufit.shoppingbag.model.vo.ShoppingBag;
import pufit.shoppingbag.model.vo.ShoppingBagPageData;

/**
 * Servlet implementation class SelectShoppingBag
 */
@WebServlet("/shoppingBag/selectShoppingBag")
public class SelectShoppingBag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectShoppingBag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		String userId = "khuser"; //나중에 세션아디로		
		ShoppingBagPageData sbpd = new ShoppingBagService().selectShoppingBag(userId);
		if(sbpd != null) {
			System.out.println("성공");
			request.setAttribute("sList", sbpd.getsList());
			request.setAttribute("shoppingBagTotalPrice", sbpd.getTotalPrice());
			request.getRequestDispatcher("/WEB-INF/shoppingBag/selectShoppingBag.jsp").forward(request, response);
		}else {
			System.out.println("아닌데요?");
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
