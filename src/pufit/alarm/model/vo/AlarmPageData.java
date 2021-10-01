package pufit.alarm.model.vo;

import java.util.ArrayList;
import java.util.List;

public class AlarmPageData {
	private String alarmPageNavi;
	private List<Alarm> alarmList;
	
	public AlarmPageData(){
		
	}
	public String getAlarmPageNavi() {
		return alarmPageNavi;
	}
	public void setAlarmPageNavi(String alarmPageNavi) {
		this.alarmPageNavi = alarmPageNavi;
	}
	public List<Alarm> getAlarmList() {
		return alarmList;
	}
	public void setAlarmList(List<Alarm> alarmList) {
		this.alarmList = alarmList;
	}
	@Override
	public String toString() {
		return "PageData [currentPage=" + alarmPageNavi + ", aList=" + alarmList + "]";
	}
	
	
	
}
