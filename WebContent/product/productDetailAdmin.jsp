<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin product select</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>관리자 상품관리</h1>
	<h2>상품 조회(삭제, 수정 가능)</h2>
	<div style="border: 1px solid black; float: left;">
	</div>
	<div style="float: left;">
		<form action="">		
			(상품이름)<br>
			(코드) : ${reqeustScope.pOne.productCode} <br>
			(제목)<br>
			(상위)<br>
			(하위)<br>
			(사이즈)<br>
			(가격)<br>
			(설명)<br>
			<button>수정</button>
		</form>
		<button id="product-delete" onclick="location.href='/product/delete?productCode=${requestScope.pOne.productCode}'">삭제</button>
	</div>
</body>
</html>