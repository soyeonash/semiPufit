package qna.model.vo;

import java.util.List;

public class QnaPageData {
	private List<Qna> qnaList;

	public QnaPageData() {}
	
	public List<Qna> getQnaList() {
		return qnaList;
	}

	public void setQnaList(List<Qna> qnaList) {
		this.qnaList = qnaList;
	}

	@Override
	public String toString() {
		return "PageData [qnaList=" + qnaList + "]";
	}
	
	
	
}
