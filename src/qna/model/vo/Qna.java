package qna.model.vo;

public class Qna {
	private int qnaNo;
	private String qnaTitle;
	private String qnaComments;
	private String category;
	private String qnaImage;
	private String userId;
	private String qnaPwd;
	
	public Qna() {}
	
	
	public Qna(int qnaNo, String qnaTitle, String qnaComments, String category, String qnaImage, String userId,
			String qnaPwd) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaComments = qnaComments;
		this.category = category;
		this.qnaImage = qnaImage;
		this.userId = userId;
		this.qnaPwd = qnaPwd;
	}


	public int getQnaNo() {
		return qnaNo;
	}


	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}


	public String getQnaTitle() {
		return qnaTitle;
	}


	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}


	public String getQnaComments() {
		return qnaComments;
	}


	public void setQnaComments(String qnaComments) {
		this.qnaComments = qnaComments;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getQnaImage() {
		return qnaImage;
	}


	public void setQnaImage(String qnaImage) {
		this.qnaImage = qnaImage;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getQnaPwd() {
		return qnaPwd;
	}


	public void setQnaPwd(String qnaPwd) {
		this.qnaPwd = qnaPwd;
	}


	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaComments=" + qnaComments + ", category="
				+ category + ", qnaImage=" + qnaImage + ", userId=" + userId + ", qnaPwd=" + qnaPwd + "]";
	}
	
	
	
}
