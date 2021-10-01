package pufit.alarm.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import pufit.alarm.dao.AlarmDAO;
import pufit.alarm.model.vo.Alarm;
import pufit.alarm.model.vo.AlarmPageData;

public class AlarmService {	
	private JDBCTemplate jdbcTemplate;
	public AlarmService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	public AlarmPageData selectAlarmList(String userId, int currentPage) {
		Connection conn = null;
		AlarmPageData aPd = new AlarmPageData();
		AlarmDAO aDAO = new AlarmDAO();
		try {
			conn = jdbcTemplate.createConnection();
			aPd.setAlarmList(aDAO.selectAlarmList(conn, userId, currentPage));
			aPd.setAlarmPageNavi(aDAO.getAlarmPageNavi(conn, currentPage, userId));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return aPd;
	}
	public int deleteAlarm(int alarmNo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = jdbcTemplate.createConnection();
			result = new AlarmDAO().deleteAlarm(conn, alarmNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
