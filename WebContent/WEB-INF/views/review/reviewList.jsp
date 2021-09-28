<%@page import="review.model.vo.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Review> rList = (List<Review>)request.getAttribute("rList");
	String pageNavi = (String)request.getAttribute("pageNavi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>리뷰게시판 조회</title>
</head>
<body>
	<h1>리뷰게시판</h1>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
		</tr>
		<% for(Review rOne : rList) { %>
		<tr>
			<td><%= rOne.getReviewNo() %></td>
			<td><a href="/review/detail?reviewNo=<%= rOne.getReviewNo() %>"><%= rOne.getReviewSubject() %></a></td>
			<td><%= rOne.getWriterId() %></td>
			<td><%= rOne.getRegDate() %></td>
		</tr>
		<% } %>
	
		<tr>
			<td colspan="3" align="center">
				<form action="/review/search" method="get">
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</form>
			</td>
			<td>
				<form action="/review/write" method="get">
					<input type="submit" value="글쓰기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<%= pageNavi %>
			</td>
		</tr>
	</table>
</body>
</html>