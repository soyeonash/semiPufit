<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 로그인</title>
</head>
<body>
	<c:if test="${userId eq null }">
		<h1>로그인 페이지</h1>
		<form action="/member/login" method="post">
			ID : <input type="text" name="user-id"><br>
			PW : <input type="password" name="user-pwd"><br>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
			<a href="/member/enroll.html">회원가입</a>
		</form>
	</c:if>

	<c:if test="${userId ne null and userId ne '' }">
		<h1>${userId} 님 환영합니다.</h1>
		<a href="/member/logout">로그아웃</a><br>
		<a href="/member/myinfo?studentId=${usetId}">마이페이지</a><br>
		<a href="/member/listAll">전체 회원조회</a><br>
		<a href="/file/upload">파일 업로드</a><br>
		<a href="/file/list">파일 목록조회</a><br>
		<a href="/notice/list">공지사항</a>
	</c:if>
</body>
</html>