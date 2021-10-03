package designer.model.vo;

import java.sql.Date;

public class Designer {
	
	private String designerId;
	private String designerPwd;
	private String designerName;
	private String designerEmail;
	private String designerPhone;
	private String licenseNo;
	private String accountNo;
	private String bankName;
	private int sellCount;
	private Date enrollDate;
	
	public Designer () {}
	
	
	public Designer(String designerId, String designerPwd, String designerName, String designerEmail,
			String designerPhone, String licenseNo, String accountNo, String bankName, int sellCount, Date enrollDate) {
		super();
		this.designerId = designerId;
		this.designerPwd = designerPwd;
		this.designerName = designerName;
		this.designerEmail = designerEmail;
		this.designerPhone = designerPhone;
		this.licenseNo = licenseNo;
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.sellCount = sellCount;
		this.enrollDate = enrollDate;
	}
	
	
	
	public Designer(String designerId, String designerPwd, String designerName, String designerEmail,
			String designerPhone, String licenseNo, String accountNo, String bankName) {
		super();
		this.designerId = designerId;
		this.designerPwd = designerPwd;
		this.designerName = designerName;
		this.designerEmail = designerEmail;
		this.designerPhone = designerPhone;
		this.licenseNo = licenseNo;
		this.accountNo = accountNo;
		this.bankName = bankName;
	}



	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	public String getDesignerPwd() {
		return designerPwd;
	}
	public void setDesignerPwd(String designerPwd) {
		this.designerPwd = designerPwd;
	}
	public String getDesignerName() {
		return designerName;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	public String getDesignerEmail() {
		return designerEmail;
	}
	public void setDesignerEmail(String designerEmail) {
		this.designerEmail = designerEmail;
	}
	public String getDesignerPhone() {
		return designerPhone;
	}
	public void setDesignerPhone(String designerPhone) {
		this.designerPhone = designerPhone;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	@Override
	public String toString() {
		return "Designer [designerId=" + designerId + ", designerPwd=" + designerPwd + ", designerName=" + designerName
				+ ", designerEmail=" + designerEmail + ", designerPhone=" + designerPhone + ", licenseNo=" + licenseNo
				+ ", accountNo=" + accountNo + ", bankName=" + bankName + ", sellCount=" + sellCount + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
	
}