package product.model.vo;

import java.sql.Date;
import java.util.List;

public class Product {
	private String productCode;
	private String productName;
	private String productImage;
	private Date registrationDate;
	private String productSize;
	private String productPrice;
	private int saleCount;
	private String highKind;
	private String rowKind;
	private String productContents;
	private String productImgName;
	
	//댓글
	private List<ProductReply> replyList;
	
	public Product() {}
	//매개변수 있는 생성자
	public Product(String productCode, String productName, String productImage, String productSize, 
			String productPrice, String highKind, String rowKind, String productContents, String productImgName) {
		this.productCode = productCode;
		this.productName = productName;
		this.productImage = productImage;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.highKind = highKind;
		this.rowKind = rowKind;
		this.productContents = productContents;
		this.productImgName = productImgName;
	}
	
	public List<ProductReply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ProductReply> replyList) {
		this.replyList = replyList;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductContents() {
		return productContents;
	}
	public void setProductContents(String productContents) {
		this.productContents = productContents;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public String getHighKind() {
		return highKind;
	}
	public void setHighKind(String highKind) {
		this.highKind = highKind;
	}
	public String getRowKind() {
		return rowKind;
	}
	public void setRowKind(String rowKind) {
		this.rowKind = rowKind;
	}
	public String getProductImgName() {
		return productImgName;
	}
	public void setProductImgName(String productImgName) {
		this.productImgName = productImgName;
	}
	
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productImage=" + productImage
				+ ", registrationDate=" + registrationDate + ", productSize=" + productSize + ", productPrice="
				+ productPrice + ", saleCount=" + saleCount + ", highKind=" + highKind + ", rowKind=" + rowKind
				+ ", productContents=" + productContents + ", productImgName=" + productImgName + "]";
	}
	
	
}
