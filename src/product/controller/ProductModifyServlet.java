package product.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.model.service.ProductService;
import product.model.vo.Product;

/**
 * Servlet implementation class ProductModifyServlet
 */
@WebServlet("/product/modify")
public class ProductModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //화면을 보여주는 용도
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//나중에 session 추가(admin아이디)?

		//폴더(productImgFolder)에 저장
		String uploadFilePath = request.getServletContext().getRealPath("productImgFolder"); //경로
		System.out.println("업로드 리얼 패스  : "+uploadFilePath);
		int uploadFileLimit = 5*1024*1024;
		String encType = "UTF-8"; //인코딩
		//policy : 같은 이름의 파일이 올라갔을 때 자동으로 이름 변경
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileLimit, encType, new DefaultFileRenamePolicy());
		
		//String fileName = multi.getFilesystemName("productImg");
		File uploadFile = multi.getFile("productImg");
		System.out.println("파일이름 : " + multi.getFilesystemName("productImg")); //파일명 출력됨. ex) min2.jpeg
		String filePath = uploadFile.getPath();
		
		String productCode = multi.getParameter("productCode");
		String productSize = multi.getParameter("productSize");
		String productPrice = multi.getParameter("productPrice");
		String productContents = multi.getParameter("productContents");
		String productImgName = multi.getFilesystemName("productImg");
		
		System.out.println("파일 패스 스트링?(경로) : "+filePath);
		
		//String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productImage = request.getParameter("productImage");
		//String productSize = request.getParameter("productSize");
		//String productPrice = request.getParameter("productPrice");
		String highKind = request.getParameter("highKind");
		String rowKind = request.getParameter("rowKind");
		//String productContents = request.getParameter("productContents");
		//String productImgName;
		
		Product product = new Product(productCode, filePath, productSize, productPrice, productContents, productImgName);
		int result = new ProductService().modifyProduct();
		if(result>0) {
			request.getRequestDispatcher("/product/adminProductDetail.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/product/productError.html").forward(request, response);
		}
	}

}
