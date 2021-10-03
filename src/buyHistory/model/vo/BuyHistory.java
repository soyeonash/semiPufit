package buyHistory.model.vo;

import java.sql.Date;

public class BuyHistory {
	
	private String orderNo;
	private String shippingStatus;
	private int price;
	private String productName;
	private Date buyDate;
	private String userId;
	private String paymentMethod;
	
	public BuyHistory() {}
	
	
	

	public BuyHistory(String orderNo, String shippingStatus, int price, String productName, Date buyDate, String userId,
			String paymentMethod) {
		super();
		this.orderNo = orderNo;
		this.shippingStatus = shippingStatus;
		this.price = price;
		this.productName = productName;
		this.buyDate = buyDate;
		this.userId = userId;
		this.paymentMethod = paymentMethod;
	}

	

	public BuyHistory(String orderNo, int price, String productName, String userId, String paymentMethod) {
		super();
		this.orderNo = orderNo;
		this.price = price;
		this.productName = productName;
		this.userId = userId;
		this.paymentMethod = paymentMethod;
	}
	
	



	public BuyHistory(String orderNo, int price, String productName, String userId) {
		super();
		this.orderNo = orderNo;
		this.price = price;
		this.productName = productName;
		this.userId = userId;
	}




	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "BuyHistory [orderNo=" + orderNo + ", shippingStatus=" + shippingStatus + ", price=" + price
				+ ", productName=" + productName + ", buyDate=" + buyDate + ", userId=" + userId + ", paymentMethod="
				+ paymentMethod + "]";
	}
	
	
	

}
