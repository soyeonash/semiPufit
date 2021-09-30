package pufit.alarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pufit.alarm.model.service.AlarmService;
import pufit.alarm.model.vo.Alarm;

/**
 * Servlet implementation class SelectAlarmList
 */
@WebServlet("/alarm/selectAlarm")
public class SelectAlarmList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAlarmList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//String userId = session.getAttribute("userId"); 나중에 세션아디로 할 코드
		String userId = "khuser";
		List<Alarm> aList = new AlarmService().selectAlarmList(userId);
		if(!aList.isEmpty()) {
			request.setAttribute("aList", aList);
			request.getRequestDispatcher("/WEB-INF/quotation/alarmList.jsp").forward(request, response);
		}else {
			System.out.println("실패했는데요?");
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
