package wishList.model.vo;

public class WishList {
	
	private int wishListNo;
	private String productCode;
	private String productImage;
	private String productName;
	private String userId;
	
	public WishList() {}
	
	
	
	

	public WishList(int wishListNo, String productCode, String productImage, String productName, String userId) {
		super();
		this.wishListNo = wishListNo;
		this.productCode = productCode;
		this.productImage = productImage;
		this.productName = productName;
		this.userId = userId;
	}





	public int getWishListNo() {
		return wishListNo;
	}

	public void setWishListNo(int wishListNo) {
		this.wishListNo = wishListNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "WishList [wishListNo=" + wishListNo + ", productCode=" + productCode + ", productImage=" + productImage
				+ ", productName=" + productName + ", userId=" + userId + "]";
	}
	
	

}
