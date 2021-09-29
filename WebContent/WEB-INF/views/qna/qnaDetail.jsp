<%@ page import="qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 상세보기</title>
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
<%-- 	<a href="/notice/modify?noticeNo=${requestScope.noticeOne.noticeNo }">수정</a>
	<a href="/notice/list">목록</a>
	<a href="/notice/remove?noticeNo=${noticeOne.noticeNo }">삭제</a> --%>
</body>
</html>