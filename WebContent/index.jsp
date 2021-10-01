<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h1>로그인 페이지</h1>
		<form action="/member/login" method="post">
			ID : <input type="text" name="user-id"><br>
			PW : <input type="password" name="user-pwd"><br>
			<input type="submit" value="로그인">
		</form>
		<a href="/review/list">리뷰게시판</a>
</body>
</html>