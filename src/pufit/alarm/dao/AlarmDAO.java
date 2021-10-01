package pufit.alarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import common.JDBCTemplate;
import pufit.alarm.model.vo.Alarm;

public class AlarmDAO {

	public List<Alarm> selectAlarmList(Connection conn, String userId, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Alarm> aList = null;
		Alarm alarm = null;
		String query = "SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY AlARM_NO DESC) AS NUM, ALARM_NO, ALARM_CONTENTS, SEND_USER, RECEIVE_USER FROM ALARM WHERE RECEIVE_USER = ?) WHERE NUM BETWEEN ? AND ?";
		try {
			pstmt = conn.prepareStatement(query);
			int viewCountPerPage = 5;
			int end = currentPage * viewCountPerPage;
			int start = end - (viewCountPerPage - 1);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			aList = new ArrayList<Alarm>();
			while (rset.next()) {
				alarm = new Alarm();
				alarm.setAlarmNo(rset.getInt("ALARM_NO"));
				alarm.setAlarmContents(rset.getString("ALARM_CONTENTS"));
				alarm.setSendUser(rset.getString("SEND_USER"));
				alarm.setReceiveUser(rset.getString("RECEIVE_USER"));
				aList.add(alarm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return aList;
	}

	public int deleteAlarm(Connection conn, int alarmNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM ALARM WHERE ALARM_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, alarmNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String getAlarmPageNavi(Connection conn, int currentPage, String userId) {
		int pageCountPerView = 5;
		int viewTotalCount = alarmTotalCount(conn, userId);
		int viewCountPerPage = 5;
		int pageTotalCount = 0;
		
		int pageTotalCountMod = viewTotalCount % viewCountPerPage;
		if (pageTotalCountMod > 0) {
			pageTotalCount = viewTotalCount / viewCountPerPage + 1;
		} else {
			pageTotalCount = viewTotalCount / viewCountPerPage;
		}
		int startNavi = ((currentPage - 1) / pageCountPerView) * pageCountPerView + 1;
		int endNavi = startNavi + pageCountPerView - 1;
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<a href='/alarm/selectAlarm?currentPage=" + (startNavi - 1) + "'> [이전] </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append(i);
			}else {
				sb.append("<a href='/alarm/selectAlarm?currentPage=" + i + "'>"+ i + "</a>");
			}
		}
		if (needNext) {
			sb.append("<a href='/alarm/selectAlarm?currentPage=" + (endNavi + 1) + "'>[다음] </a>");
		}
		return sb.toString();
	}

	private int alarmTotalCount(Connection conn, String userId) {
		int totalValue = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM ALARM WHERE RECEIVE_USER = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {				
				totalValue = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(rset);
		}
		return totalValue;
	}

}
