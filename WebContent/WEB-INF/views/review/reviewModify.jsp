<%@ page import="review.model.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Review review = (Review)request.getAttribute("review");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>
</head>
<body>
	<h1>글수정</h1>
	<form action="/review/modify" method="post">
	<input type="text" name="review-subject" size="500" value="${reviewOne.reviewSubject }">
	<textarea rows="30" cols="100" name="review-contents">
			${reviewOne.reviewContents }
	</textarea>
	<input type="hidden" name="reviewNo" value="${reviewOne.reviewNo }">
		<input type="submit" value="수정완료">
		<input type="reset" value="취소">
	</form>
</body>
</html>