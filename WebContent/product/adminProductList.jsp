<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트(관리자)</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.container{
                float: left;
                display: grid;
                grid-template-columns: repeat(4, 1fr);
                grid-template-rows: repeat(3, 1fr);
                column-gap: 30px;
                row-gap: 30px;
                background-color: cadetblue;
                margin: 30px;
            }
                .container-item:hover{
                    filter: brightness(50%);
                    cursor: pointer;
                }
                .container-item{
                    background-color: chartreuse;
                    margin: 10px;
                }
</style>
</head>
<body>
	<div>
		<button onclick="location.href='/product/productInsert.jsp'" 
		style="height: 50px; width: 100px; cursor: pointer;">등록</button>
	</div>
	<div class="container">
		<c:forEach items="${requestScope.productList }" var="list" varStatus="index">
			<div class="container-item" onclick="location.href='/product/detail?productCode=${list.productCode}'">
				<div class="productImg">
					<img src="../productImgFolder/${list.productImgName}" alt="test">
		        </div>
		        <div class="price">
		        	<strong>${list.productPrice}</strong>원
		        </div>
		     </div>
	   </c:forEach>
    </div>
</body>
</html>