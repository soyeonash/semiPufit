package review.model.vo;

import java.util.List;

import review.model.vo.Review;

public class PageData {
	private List<Review> reviewList;
	private String pageNavi;
	
	public PageData() {}

	

	public List<Review> getReviewList() {
		return reviewList;
	}



	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}



	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}


	@Override
	public String toString() {
		return "PageData [reviewList=" + reviewList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
