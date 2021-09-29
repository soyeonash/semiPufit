package pufit.quotation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.quotation.model.service.QuotationService;

/**
 * Servlet implementation class AnswerQuotation
 */
@WebServlet("/quotation/quotationAnswer")
public class AnswerQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerQuotation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("answer");
		String userId = request.getParameter("userId");
		int quotationNo = Integer.parseInt(request.getParameter("quotationNo"));
		String designerId = "khuser01";
		QuotationService qService = new QuotationService();
		if(answer.equals("수락")) {
			String alarm = "견적서를 수락했습니다 (채팅방링크)";
			int alarmResult = qService.answerAlarm(userId, alarm, designerId);
			response.sendRedirect("/quotation/userCheck");
		}else {
			String alarm = "견적서를 거절했습니다";
			int alarmResult = qService.answerAlarm(userId, alarm, designerId);
			int answerResult = qService.denyQuotation(quotationNo);
			response.sendRedirect("/quotation/userCheck");
			
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
