package pufit.alarm.model.vo;

import java.util.ArrayList;
import java.util.List;

public class PageData {
	int currentPage;
	private List<Alarm> aList;
	
	public PageData(){
		
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Alarm> getaList() {
		return aList;
	}
	public void setaList(List<Alarm> aList) {
		this.aList = aList;
	}
	@Override
	public String toString() {
		return "PageData [currentPage=" + currentPage + ", aList=" + aList + "]";
	}
	
	
	
}
