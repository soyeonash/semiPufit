package pufit.alarm.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import pufit.alarm.dao.AlarmDAO;
import pufit.alarm.model.vo.Alarm;

public class AlarmService {	
	private JDBCTemplate jdbcTemplate;
	public AlarmService() {
		jdbcTemplate = JDBCTemplate.getConnection();
	}
	public List<Alarm> selectAlarmList(String userId) {
		Connection conn = null;
		List<Alarm> aList = null;
		
		try {
			conn = jdbcTemplate.createConnection();
			aList = new AlarmDAO().selectAlarmList(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return aList;
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
