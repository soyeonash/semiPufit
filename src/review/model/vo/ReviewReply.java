package review.model.vo;

import java.sql.Date;

public class ReviewReply {

	private int replyNo;
	private int reviewNo;
	private String replyContents;
	private String replyWriterId;
	private Date replyDate;
	
	public ReviewReply() {}

	
	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public String getReplyWriterId() {
		return replyWriterId;
	}

	public void setReplyWriterId(String replyWriterId) {
		this.replyWriterId = replyWriterId;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}


	@Override
	public String toString() {
		return "ReviewReply [replyNo=" + replyNo + ", reviewNo=" + reviewNo + ", replyContents=" + replyContents
				+ ", replyWriterId=" + replyWriterId + ", replyDate=" + replyDate + "]";
	}
	
	
	
	
}
