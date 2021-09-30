package pufit.alarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import pufit.alarm.model.vo.Alarm;

public class AlarmDAO {

	public List<Alarm> selectAlarmList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Alarm> aList = null;
		Alarm alarm = null;
		String query  ="SELECT * FROM ALARM WHERE RECEIVE_USER = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			aList = new ArrayList<Alarm>();
			while(rset.next()) {
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

}
