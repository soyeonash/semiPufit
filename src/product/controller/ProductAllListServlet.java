package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.model.service.ProductService;
import product.model.vo.Product;

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
		//HttpSession session = request.getSession();
		//String userId=(String)session.getAttribute("userId");
		String userId = "admin";
		
		String item = request.getParameter("item");
		System.out.println("item : "+item);
		String selectOne = request.getParameter("selectOne");
		System.out.println("selectOne : "+ selectOne);
		//shop처음 이동했을시
		if(item==null&&selectOne==null) {
			item="민소매";
			selectOne="최신순";
		}
		List<Product> pList = new ProductService().productAllList(item, selectOne);
		List<Product> productList = new ProductService().productAll();
		if(userId=="admin") {
			if(!productList.isEmpty()) {
				request.setAttribute("productList", productList);
				request.getRequestDispatcher("/product/adminProductList.jsp").forward(request, response);
			} else {
				request.setAttribute("productList", productList);
				request.getRequestDispatcher("/product/adminProductList.jsp").forward(request, response);
			}
			
		} else {
			if(!pList.isEmpty()) {
				request.setAttribute("pList", pList);
				request.setAttribute("category", item); //ajax처리 위해서.
				request.setAttribute("select", selectOne); //ajax처리 위해서.
				request.getRequestDispatcher("/product/productAllList.jsp").forward(request, response);
				//System.out.println("성공??");
			} else {
				request.setAttribute("pList", pList);
				request.getRequestDispatcher("/product/productAllList.jsp").forward(request, response);
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
