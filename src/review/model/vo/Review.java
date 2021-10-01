package review.model.vo;

import java.sql.Date;
import java.util.List;

public class Review {
	private int reviewNo;
	private String reviewSubject;
	private String reviewContents;
	private int reviewRecommend;
	private String writerId;
	private String categoty;
	private int reportCount;
	private Date regDate;
	
	private List<ReviewReply> replies;
	
	public Review() {}


	
	
	
	public List<ReviewReply> getReplies() {
		return replies;
	}





	public void setReplies(List<ReviewReply> list) {
		this.replies = list;
	}





	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getReviewSubject() {
		return reviewSubject;
	}



	public void setReviewSubject(String reviewSubject) {
		this.reviewSubject = reviewSubject;
	}



	public String getReviewContents() {
		return reviewContents;
	}



	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}



	public int getReviewRecommend() {
		return reviewRecommend;
	}



	public void setReviewRecommend(int reviewRecommend) {
		this.reviewRecommend = reviewRecommend;
	}



	public String getWriterId() {
		return writerId;
	}



	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}



	public String getCategoty() {
		return categoty;
	}



	public void setCategoty(String categoty) {
		this.categoty = categoty;
	}



	public int getReportCount() {
		return reportCount;
	}



	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewSubject=" + reviewSubject + ", reviewContents="
				+ reviewContents + ", reviewRecommend=" + reviewRecommend + ", writerId=" + writerId + ", categoty="
				+ categoty + ", reportCount=" + reportCount + ", regDate=" + regDate + "]";
	}
	
}
