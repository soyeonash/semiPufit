package pufit.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.product.model.service.ProductService;
import pufit.product.model.vo.Product;

/**
 * Servlet implementation class ProductReplyModifyServlet
 */
@WebServlet("/productReply/modify")
public class ProductReplyModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductReplyModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int productReplyNo = Integer.parseInt(request.getParameter("productReplyNo"));
		String productCode = request.getParameter("productCode");
		String productReplyContents = request.getParameter("productReplyContents");
		int result = new ProductService().productReplyModify(productReplyNo, productReplyContents);
		if(result>0) {
			response.sendRedirect("/notice/detail?productCode="+productCode);
		} else {
			request.getRequestDispatcher("/product/productError.html").forward(request, response);
		}

	}

}
