package pufit.quotation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.quotation.model.service.QuotationService;

/**
 * Servlet implementation class SendQuotation
 */
@WebServlet("/quotation/quotationSend")
public class SendQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendQuotation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = "khuser"; //나중에 세션아디로 바꿔야함
		String designerId = "khuser01"; //디자이너 아디 어디서 받아와야 할까?
		String alarmContents = "견적서가 왔습니다"; //견적서 내용부분 
		int quotationNo = Integer.parseInt(request.getParameter("quotationNo")); //업뎃하는데 where조건 줄것
		QuotationService qService = new QuotationService();
		int alarm = qService.sendAlarm(userId, designerId, alarmContents); //알람등록하는데 필요한것 내용 아디
		if(alarm>0) {
			System.out.println("알림등록 성공");
		}else {
			System.out.println("안됬는데요?");
		}
		int send =  qService.sendQuotation(designerId, quotationNo);//견적서 보내기(업뎃)하는데 필요한건 업뎃내용 정보랑 no 근데 이건 디자이너 아디만 바뀌면댐 
		if(send>0) {
			response.sendRedirect("/quotation/userCheck");
		}else {
			request.getRequestDispatcher("/WEB-INF/quotation/error.jsp");
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
