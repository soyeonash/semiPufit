package pufit.quotation.model.vo;

public class Alarm {

	private int alarmNo;
	private String alarmContents;
	private String sendUser;
	private String receiveUser;
	
	public Alarm() {
		
	}
	
	
	
	public Alarm(int alarmNo, String alarmContents, String sendUser, String receiveUser) {
		super();
		this.alarmNo = alarmNo;
		this.alarmContents = alarmContents;
		this.sendUser = sendUser;
		this.receiveUser = receiveUser;
	}



	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getAlarmContents() {
		return alarmContents;
	}
	public void setAlarmContents(String alarmContents) {
		this.alarmContents = alarmContents;
	}
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public String getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}
	@Override
	public String toString() {
		return "Alarm [alarmNo=" + alarmNo + ", alarmContents=" + alarmContents + ", sendUser=" + sendUser
				+ ", receiveUser=" + receiveUser + "]";
	}
	
	
}
