package buyHistory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyHistory.model.vo.BuyHistory;
import buyHistory.service.BuyHistoryService;

/**
 * Servlet implementation class SelectBuyHistoryServlet
 */
@WebServlet("/buyhistory/select")
public class SelectBuyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBuyHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		List<BuyHistory> bList = new BuyHistoryService().selectBuyHistoryList(userId);
		if(!bList.isEmpty()) {
			request.setAttribute("userId", userId);
			request.setAttribute("userName", userName);
			request.setAttribute("bList", bList);
			request.getRequestDispatcher("/WEB-INF/views/buyHistory/buyHistory.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/user/error.html").forward(request, response);
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
