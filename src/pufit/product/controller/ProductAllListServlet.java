package pufit.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.product.model.service.ProductService;
import pufit.product.model.vo.Product;

/**
 * Servlet implementation class ProductAllListServlet
 */
@WebServlet("/product/allList")
public class ProductAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> pList = new ProductService().productAllList();
		
		if(!pList.isEmpty()) {
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("/product/productAllList.jsp").forward(request, response);
		} else {
			request.setAttribute("pList", pList);
			request.getRequestDispatcher("/product/productAllList.jsp").forward(request, response);
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
