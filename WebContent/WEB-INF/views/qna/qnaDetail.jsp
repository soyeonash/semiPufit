<%@ page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세보기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h2>제목 : ${requestScope.qnaOne.qnaTitle }</h2>
	<h6>글번호 : ${requestScope.qnaOne.qnaNo } / 
		글쓴이 : ${qnaOne.userId } </h6>
	<h3>글내용</h3>
	<div>
		${qnaOne.qnaComments }
	</div><br><br>
	<img alt="" width="300px" src="${qnaOne.qnaImage }">
	<a href="/qna/list">목록</a>
	
	
	<!-- 댓글 입력  -->
	<form action="/qnaReply/qnaInsertReply" method="post">
		댓글(답변): <input type="text" name="replyContents" placeholder="댓글을 작성해보세요">
		<input type="hidden" name="qnaNo" value="${qnaOne.qnaNo }">
		<input type="hidden" name="userId" value="${qnaOne.userId }">
		<input type="submit" value="작성">
	</form>
<!-- 댓글 출력 -->
 	<table>
		<tr><th>댓글</th><th>아이디</th></tr>
		<c:forEach items="${qnaOne.replies }" var="reply">
		<tr>
			<td>${reply.replyContents }</td>
			<td>${reply.userId }</td>
		</tr>
		</c:forEach>
	</table> 
	<!-- 전송용 폼태그, 사용자에게는 보이지 않음, jquery로 submit 메소드 실행 -->
<!--  	<form action="/qnaReply/modify" method="post" id="modifyForm">
		<input type="hidden" name="replyContents" id="modifyReplyContents">
		<input type="hidden" name="replyNo" id="modifyReplyNo">
		<input type="hidden" name="qnaNo" id="modifyNoticeNo">
	</form>  -->
<!-- 		<script>
		function modifyReply(obj, replyNo, noticeNo) {
			var contents =$(obj).parent().prev().find("input").val();
			$("#modifyReplyContents").val(contents);
			$("#modifyReplyNo").val(replyNo);
			$("#modifyNoticeNo").val(noticeNo);
			$("#modifyForm").submit();
		}
		function showModifyReply(obj) {
			$(obj).parents("tr").next().show();
			$(obj).parents("tr").hide();
		}
		function hideModifyReply(obj) {
			$(obj).parents("tr").prev().show();
			$(obj).parents("tr").hide();
		} -->
</body>
</html>