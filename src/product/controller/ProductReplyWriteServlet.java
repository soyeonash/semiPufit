package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.model.service.ProductService;

/**
 * Servlet implementation class ProductReplyWrite
 */
@WebServlet("/productReply/write")
public class ProductReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//session 추가 + 사용자 받아오기
		HttpSession session = request.getSession();
//		String writerId = (String)session.getAttribute("userId");
		String writerId = "admin";
		
		String productCode = request.getParameter("productCode");
//		System.out.println("productCode : "+productCode);
//		System.out.println("replyScore : "+ Integer.parseInt(request.getParameter("productReplyRadio")));
		int replyScore = Integer.parseInt(request.getParameter("productReplyRadio"));
		String replyComment = request.getParameter("productReplyComment");
		
		int result = new ProductService().productReplyWrite(productCode, replyComment, writerId, replyScore);
		//int result = new ProductService().productReplyWrite(productCode, replyComment, replyScore);
		if(result>0) {
			response.sendRedirect("/product/detail?productCode="+productCode);
		} else {
			request.getRequestDispatcher("/product/productError.html").forward(request, response);
		}
	}

}
