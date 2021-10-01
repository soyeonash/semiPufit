package pufit.shoppingbag.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.shoppingbag.model.service.ShoppingBagService;

/**
 * Servlet implementation class DeleteShoppingBag
 */
@WebServlet("/shoppingBag/deleteShoppingBag")
public class DeleteShoppingBag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShoppingBag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shoppingBagCode = Integer.parseInt(request.getParameter("shoppingBagCode"));
		
		int result = new ShoppingBagService().deleteShoppingBag(shoppingBagCode);
		if(result > 0) {
			response.sendRedirect("/shoppingBag/selectShoppingBag");
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
