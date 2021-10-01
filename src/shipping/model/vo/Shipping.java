package shipping.model.vo;

public class Shipping {
	
	private int shippingNo;
	private String shippingMain;
	private String shippingSub;
	private String shippingName;
	private String shippingPhone;
	private String userId;
	
	public Shipping() {}
	
	
	
	

	public Shipping(int shippingNo, String shippingMain, String shippingSub, String shippingName, String shippingPhone,
			String userId) {
		super();
		this.shippingNo = shippingNo;
		this.shippingMain = shippingMain;
		this.shippingSub = shippingSub;
		this.shippingName = shippingName;
		this.shippingPhone = shippingPhone;
		this.userId = userId;
	}


	



	public Shipping(String shippingMain, String shippingSub, String shippingName, String shippingPhone, String userId) {
		super();
		this.shippingMain = shippingMain;
		this.shippingSub = shippingSub;
		this.shippingName = shippingName;
		this.shippingPhone = shippingPhone;
		this.userId = userId;
	}





	public int getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(int shippingNo) {
		this.shippingNo = shippingNo;
	}

	public String getShippingMain() {
		return shippingMain;
	}

	public void setShippingMain(String shippingMain) {
		this.shippingMain = shippingMain;
	}

	public String getShippingSub() {
		return shippingSub;
	}

	public void setShippingSub(String shippingSub) {
		this.shippingSub = shippingSub;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Shipping [shippingNo=" + shippingNo + ", shippingMain=" + shippingMain + ", shippingSub=" + shippingSub
				+ ", shippingName=" + shippingName + ", shippingPhone=" + shippingPhone + ", userId=" + userId + "]";
	}
	
	
	
	
	

}
