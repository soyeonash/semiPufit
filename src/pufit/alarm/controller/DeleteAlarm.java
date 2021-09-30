package pufit.alarm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pufit.alarm.model.service.AlarmService;

/**
 * Servlet implementation class DeleteAlarm
 */
@WebServlet("/alarm/deleteAlarm")
public class DeleteAlarm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAlarm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int alarmNo = Integer.parseInt(request.getParameter("alarmNo"));
		int result = 0 ;
		result = new AlarmService().deleteAlarm(alarmNo);
		if(result > 0) {
			response.sendRedirect("/alarm/selectAlarm");
		}else {
			System.out.println("다시해");
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
