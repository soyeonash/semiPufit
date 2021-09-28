<%@page import="pufit.quotation.model.vo.Quotation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Quotation> qList = (List<Quotation>)request.getAttribute("qList");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>pufit</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/0ac2e127d2.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../../menu/menu.css" />
<script src="../../menu/menu.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../../footer/footer.css" />
<style>

 body{
      text-align: center;
    }
    body>h1,h4{
      position: relative;
      right: 250px;
    }
    body>h4{
      top:10px;
    }
    #insert{
      position: relative;
      bottom: 50px;
      left: 300px;
      width: 75px;
      height: 35px;
      background-color: rgba(230, 221, 221, 0.959);
      border-radius: 5px 5px 5px 5px;
      border-color: rgba(230, 221, 221, 0.959);
    }
    .card{
      width: 300px;
      height: 300px;
      border:1px solid black;
      float: left;
      position: relative;
      left: 100px;
      top: 100px;
    }
    img{
      width: 300px;
      height: 300px;
    }
    .subject{
      position:absolute;
      border: 1px solid black;
      width: 300px;
      height: 75px;
      top: 225px;
      background-color:rgba(2, 2, 2, 0.5);
      
    }
</style>
</head>
<body>
	<nav class="navbar fiexd-top">
		<div class="navbar_logo"></div>

		<ul class="navbar_menu">
			<li><a href="#">SHOP</a></li>
			<li><a href="#">메뉴</a></li>
			<li><a href="/quotation/userCheck" id="quotation">견적서</a></li>
			<li><a href="#">디자이너</a></li>
			<li><a href="#">리뷰게시판</a></li>
		</ul>

		<ul class="navbar_icons">
			<li><i class="fas fa-user"></i></li>
			<li><i class="fas fa-weight-hanging"></i></li>
			<li id="alarm_btn"><i class="fas fa-bell"></i></li>
			<li id="navbar_toogleBtn"><i class="fas fa-bars"></i></li>
		</ul>
	</nav>

	<navside class="navbar_side">
	<ul class="navbar_menu_side">
		<li><a href="#">SHOP</a></li>
		<li><a href="#">메뉴</a></li>
		<li><a href="/quotation/selectQuotationList">견적서</a></li>
		<li><a href="#">디자이너</a></li>
		<li><a href="#">리뷰게시판</a></li>
	</ul>
	</navside>
		<h1>견적서</h1>
	<h4>견적서목록</h4>
	<a href="/quotation/moveInsert"> <input type="button" value="작성"
		id="insert">
	</a>
	<c:forEach items="${requestScope.qList}" var="qOne" varStatus="index">
	<a href="/quotation/quotationDetail?quotationNo=${qOne.quotationNo}">
		<div class="card">
			<img src="${qOne.quotationImage}" alt="이미지없음">
			<div class="subject">
				<h3>${qOne.quotationSubject}</h3>
			</div>
		</div>
	</a>
	</c:forEach>
	<footer class="fixed-bottom">
		<div id="footer">
			<table id="footer_table">
				<tr>
					<td><label class="footer_table_title">고객센터</label></td>
				</tr>

				<tr>
					<td><label></label></td>
				</tr>
				<tr>
					<td><label> </label></td>
				</tr>
				<tr>
					<td><label> </label></td>
				</tr>
				<tr>
					<td><label></label></td>
				</tr>
			</table>
			<img class="footer_img" src="../../public/image/footer.png" alt="" />
		</div>
	</footer>
</body>
</html>
