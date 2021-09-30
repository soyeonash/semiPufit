package pufit.quotation.model.vo;

import java.sql.Date;

public class Quotation {

	private int quotationNo;
	private String category;
	private Date registrationDate;
	private String quotationImage;
	private String quotationSubject;
	private String userId;
	private String designerId;
	private String contents;
	
	public Quotation() {
		
	}

	public int getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(int quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getQuotationImage() {
		return quotationImage;
	}

	public void setQuotationImage(String quotationImage) {
		this.quotationImage = quotationImage;
	}

	public String getQuotationSubject() {
		return quotationSubject;
	}

	public void setQuotationSubject(String quotationSubject) {
		this.quotationSubject = quotationSubject;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDesignerId() {
		return designerId;
	}

	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Quotation [quotationNo=" + quotationNo + ", category=" + category + ", registrationDate="
				+ registrationDate + ", quotationImage=" + quotationImage + ", quotationSubject=" + quotationSubject
				+ ", userId=" + userId + ", designerId=" + designerId + ", contents=" + contents + "]";
	}


	
	
}
