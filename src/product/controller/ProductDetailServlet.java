package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import product.model.service.ProductService;
import product.model.vo.Product;
import product.model.vo.ProductReply;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/product/detail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		Product productOne = new ProductService().productDetail(productCode);
		String userId="admin";
		
		if(userId=="admin") {
			if(productOne!=null) {
				request.setAttribute("productOne", productOne);
				request.getRequestDispatcher("/product/adminProductDetail.jsp").forward(request, response);
			} else {
				response.sendRedirect("/product/productError.html");
			}
		} else {			
			if(productOne!=null) {
				request.setAttribute("productOne", productOne);
				request.getRequestDispatcher("/product/productDetail.jsp").forward(request, response);
			} else {
				response.sendRedirect("/product/productError.html");
			}
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
