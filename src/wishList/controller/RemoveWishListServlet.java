package wishList.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wishList.model.service.WishListService;

/**
 * Servlet implementation class RemoveWishListServlet
 */
@WebServlet("/wishlist/remove")
public class RemoveWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveWishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int wishListNo = Integer.parseInt(request.getParameter("wishListNo"));
		System.out.println(wishListNo);
		int result = new WishListService().removeWishList(wishListNo);
		System.out.println(result);
		if(result > 0) {
			response.sendRedirect("/wishlist/select?userId="+userId);
		}else {
			request.getRequestDispatcher("/user/error.html").forward(request, response);
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
