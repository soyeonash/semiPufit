package qna.model.vo;

public class QnaReply {

	private int qnaNo;
	private int qnaReplyNo;
	private String replyContents;
	private String userId;
	
	public QnaReply() {}

	public int getQnaReplyNo() {
		return qnaReplyNo;
	}

	public void setQnaReplyNo(int qnaReplyNo) {
		this.qnaReplyNo = qnaReplyNo;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "QnaReply [qnaReplyNo=" + qnaReplyNo + ", qnaNo=" + qnaNo + ", replyContents=" + replyContents
				+ ", userId=" + userId + "]";
	}

	
}

