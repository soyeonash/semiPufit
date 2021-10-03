package wishList.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wishList.model.service.WishListService;
import wishList.model.vo.WishList;

/**
 * Servlet implementation class SelectWishListServlet
 */
@WebServlet("/wishlist/select")
public class SelectWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectWishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		System.out.println(userId);
		List<WishList> wList = new WishListService().selectWishList(userId);
//		for(WishList wistList : wList) {
//			System.out.println(wistList.toString());
//		}
//		System.out.println(wList.isEmpty());
		//if(!wList.isEmpty()) {
			request.setAttribute("userId", userId);
			request.setAttribute("userName", userName);
			request.setAttribute("wList", wList);
			request.getRequestDispatcher("/WEB-INF/views/wishList/wishList.jsp").forward(request, response);
		//}else {
			//request.getRequestDispatcher("/user/ErrorWishList.jsp").forward(request, response);
		//}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
