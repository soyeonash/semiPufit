package pufit.shoppingbag.model.vo;

import java.util.List;

public class ShoppingBagPageData {

	private List<ShoppingBag> sList;
	private long totalPrice;
	
	public ShoppingBagPageData(){
	
		
	}
	
	public List<ShoppingBag> getsList() {
		return sList;
	}
	public void setsList(List<ShoppingBag> sList) {
		this.sList = sList;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ShoppingBagPageData [sList=" + sList + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
