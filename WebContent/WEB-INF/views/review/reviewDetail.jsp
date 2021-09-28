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
	
	
</body>
</html>