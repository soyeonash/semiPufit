package user.model.vo;

import java.sql.Date;

public class User {
	
	public User() {}
	
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String admin;
	private Date enrollDate;
	
	public User(String userId, String userPwd, String userName, String userEmail, String userPhone, String admin,
			Date enrollDate) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.admin = admin;
		this.enrollDate = enrollDate;
	}
	
	
	
	
	public User(String userId, String userPwd, String userName, String userEmail, String userPhone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}


	


	public User(String userId, String userPwd, String userEmail, String userPhone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}




	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", admin=" + admin + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
}
