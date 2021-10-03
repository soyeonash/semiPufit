<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세 관리 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>관리자 상품관리</h1>
	<h2>상품 조회(삭제, 수정 가능)</h2>
	<div style="border: 1px solid black; float: left;">
	</div>
	<div style="float: left;">
		<form action="/product/modify" method="post">		
			(상품이름) : ${requestScope.productOne.productName}<br>
			(코드) : ${productOne.productCode} <br>
			(상위) : ${productOne.highKind}<br>
			(하위) : ${productOne.rowKind}<br>
			(사이즈) : ${productOne.productSize}
			<select style="width: 100px; height: 30px; font-size: 20px;" name="sizeOption">
				<option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
            </select><br>
			(가격) : ${productOne.productPrice}<br>
			(설명) : ${productOne.productContents}<br>
			<input type="submit" value="수정">
		</form>
		<button id="product-delete" onclick="location.href='/product/delete?productCode=${productOne.productCode}'">삭제</button>
	</div>
</body>
</html>