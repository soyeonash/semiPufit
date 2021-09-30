package pufit.product.model.vo;

import java.sql.Date;

public class ProductReply {
	private int productReplyNo;
	private String productCode;
	private String productReplyContents;
	private String writerId;
	private Date productReplyDate;
	private String productReplyScore;
	private String productReportCount;
	
	public ProductReply() {}

	public int getProductReplyNo() {
		return productReplyNo;
	}

	public void setProductReplyNo(int productReplyNo) {
		this.productReplyNo = productReplyNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductReplyContents() {
		return productReplyContents;
	}

	public void setProductReplyContents(String productReplyContents) {
		this.productReplyContents = productReplyContents;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getProductReplyDate() {
		return productReplyDate;
	}

	public void setProductReplyDate(Date productReplyDate) {
		this.productReplyDate = productReplyDate;
	}

	public String getProductReplyScore() {
		return productReplyScore;
	}

	public void setProductReplyScore(String productReplyScore) {
		this.productReplyScore = productReplyScore;
	}

	public String getProductReportCount() {
		return productReportCount;
	}

	public void setProductReportCount(String productReportCount) {
		this.productReportCount = productReportCount;
	}

	@Override
	public String toString() {
		return "ProductReply [productReplyNo=" + productReplyNo + ", productCode=" + productCode
				+ ", productReplyContents=" + productReplyContents + ", writerId=" + writerId + ", productReplyDate="
				+ productReplyDate + ", productReplyScore=" + productReplyScore + ", productReportCount="
				+ productReportCount + "]";
	}

	
}
