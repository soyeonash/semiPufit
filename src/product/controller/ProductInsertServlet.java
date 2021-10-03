package product.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.activation.FileDataSource;
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
 * Servlet implementation class ProductInsertServlet
 */
@WebServlet("/product/insert")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/product/productInsert.html");
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
		String productName = multi.getParameter("productName");
		String productSize = multi.getParameter("productSize");
		String productPrice = multi.getParameter("productPrice");
		String highKind = multi.getParameter("highKind");
		String rowKind = multi.getParameter("rowKind");
		String productContents = multi.getParameter("productContents");
		String productImgName = multi.getFilesystemName("productImg");
		
		System.out.println("파일 패스 스트링?(경로) : "+filePath);
		
		//long fileSize = uploadFile.length();
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		
		//Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
		//정보들을 담을 클래스
		Product product = new Product(productCode, productName, filePath, productSize, productPrice, highKind, rowKind, productContents, productImgName);
		/*
		 * product.setProductCode(productCode); product.setProductName(productName);
		 * product.setProductImage(filePath); product.setProductPrice(productPrice);
		 * product.setProductSize(productSize); product.setHighKind(highKind);
		 * product.setRowKind(rowKind); product.setProductContents(productContents);
		 * fileData.setFilePath(filePath);
		 */
		int result = new ProductService().insertProduct(product);
		if(result>0) {
			response.sendRedirect("/product/allList");
		} else {
			response.sendRedirect("/product/productError.html");
		}
		
		
		
	}

}
