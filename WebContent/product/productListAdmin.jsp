<%@page import="product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품관리 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2>상품관리</h2>
	<div class="container">
<%-- 	     <% for(Product p:pList) {%>
	     <%} %> --%>
	     
		<c:forEach items="${requestScope.pList }" var="pOne" varStatus="index">
			<div style="cursor: pointer;" onclick="location.href='/product/';">
				<div style="width: 150px; height: 200px; border: 1px solid black;">
					<%-- <%
		                        		String url = p.getProductImage();
		                        		String fileName = url.substring(url.lastIndexOf('\\')+1, url.length()); 
		                        	%>
		                        	<p><%=fileName %></p>
		                            <img src="../productImgFolder/<%=fileName%>" alt="test"> --%>
					<img alt="../productImgFolder/min1.jpeg" src="">
				</div>
				<div class="price"><%-- 
					<strong><%=p.getProductPrice() %></strong>원 --%> --%>
				</div>
			</div>			
	    </c:forEach>
	     

	</div>
</body>
</html>