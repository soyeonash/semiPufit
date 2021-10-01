package pufit.shoppingbag.model.vo;

public class ShoppingBag {
	private int shoppingBagCode;
	private String userId;
	private String productCode;
	private int shoppingBagProductPrice;
	private String shoppingBagProductName;
	private String shoppingBagProductContents;
	private String shoppingBagProductImageName;
	
	public ShoppingBag() {
		
	}

	public int getShoppingBagCode() {
		return shoppingBagCode;
	}

	public void setShoppingBagCode(int shoppingBagCode) {
		this.shoppingBagCode = shoppingBagCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getShoppingBagProductPrice() {
		return shoppingBagProductPrice;
	}

	public void setShoppingBagProductPrice(int shoppingBagProductPrice) {
		this.shoppingBagProductPrice = shoppingBagProductPrice;
	}

	public String getShoppingBagProductName() {
		return shoppingBagProductName;
	}

	public void setShoppingBagProductName(String shoppingBagProductName) {
		this.shoppingBagProductName = shoppingBagProductName;
	}

	public String getShoppingBagProductContents() {
		return shoppingBagProductContents;
	}

	public void setShoppingBagProductContents(String shoppingBagProductContents) {
		this.shoppingBagProductContents = shoppingBagProductContents;
	}

	public String getShoppingBagProductImageName() {
		return shoppingBagProductImageName;
	}

	public void setShoppingBagProductImageName(String shoppingBagProductImageName) {
		this.shoppingBagProductImageName = shoppingBagProductImageName;
	}

	@Override
	public String toString() {
		return "ShoppingBag [shoppingBagCode=" + shoppingBagCode + ", userId=" + userId + ", productCode=" + productCode
				+ ", shoppingBagProductPrice=" + shoppingBagProductPrice + ", shoppingBagProductName="
				+ shoppingBagProductName + ", shoppingBagProductContents=" + shoppingBagProductContents
				+ ", shoppingBagProductImageName=" + shoppingBagProductImageName + "]";
	}
	
	

	
}
