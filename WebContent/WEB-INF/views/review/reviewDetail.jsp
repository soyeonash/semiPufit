<%@page import="review.model.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 게시판 상세정보</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- 글목록 -->
	<h2>제목 : ${reviewOne.reviewSubject }</h2>
	<h6>글번호 :${reviewOne.reviewNo }
	글쓴이 :  ${reviewOne.writerId }/ 작성일 : ${reviewOne.regDate }</h6>
	<h3>글내용</h3>
	<div>
		${reviewOne.reviewContents }
	</div>
	<h6>추천수: ${reviewOne.reviewRecommend }</h6>
	<br>
	<br>
	<a href="/review/modify?reviewNo=${reviewOne.reviewNo}">수정</a>
	<a href="/review/list">목록</a>
	<a href="/review/remove?reviewNo=${reviewOne.reviewNo}">삭제</a>
	
	
	<!-- 댓글부분 -->
	<form action="/reviewReply/write" method="post">
		comment: <input type="text" name="replyContents" placeholder="댓글">
		<input type="hidden" name="reviewNo" value="${reviewOne.reviewNo}">
		<input type="submit" value="작성">
	</form>
	

	<!-- 댓글출력 -->
	<table>
		<tr><th>댓글</th><th>아이디</th><th>작성날짜</th><th></th></tr>
		<c:forEach items="${reviewOne.replies }" var="reply">
		<tr>
			<td>${reply.replyContents }</td>
			<td>${reply.replyWriterId }</td>
			<td>${reply.replyDate }</td>
			<td><a href="javascript:void(0)"  onclick="showModifyReply(this)">수정</a>&nbsp;&nbsp;
			<a href="/reviewReply/delete?reviewNo=${reply.reviewNo }&replyNo=${reply.replyNo }">삭제</a></td>
		</tr>
		
		<tr style="display:none;">
			<td>
				<input type="text" size="40" value="${reply.replyContents }" id="modifyReply"></td>
			<td>
				<a href="javascript:void(0)" 
				onclick="modifyReply(this,${reply.replyNo},${reply.reviewNo })">수정완료</a>&nbsp;&nbsp;
				<a href="javascript:void(0)" onclick="hideModifyReply(this)">취소</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 댓글  전송 -->
	<form action="/reviewReply/modify"  method="post" id="modifyForm">
		<input type="hidden" name="replyContents" id="modifyReplyContents">
		<input type="hidden" name="replyNo" id="modifyReplyNo">
		<input type="hidden" name="reviewNo" id="modifyReviewNo">
	</form>
	
	<script>
		function modifyReply(obj, replyNo, reviewNo)  {
			var contents = $(obj).parent().prev().find("input").val();
			$("#modifyReplyContents").val(contents);
			$("#modifyReplyNo").val(replyNo);
			$("#modifyReviewNo").val(reviewNo);
			$("#modifyForm").submit();
		}
		function showModifyReply(obj){
			$(obj).parents("tr").next().show();
			$(obj).parents("tr").hide();
		}
		
		function hideModifyReply(obj){
			$(obj).parents("tr").prev().show();
			$(obj).parents("tr").hide();
		}
	</script>
	
</body>
</html>