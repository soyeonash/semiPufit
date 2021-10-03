<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/buyHistory.css">
    <title>구매내역</title>
</head>
<body>
    <script>
        $(document).ready(function(){
            

        })
    </script>
    <div id="content">
        <div class="mypage-main">
            <div class="sidebar">
                <div class="side">
                    <div class="menu" id="menu-bar">
                        <p>마이페이지</p>
                    </div>
                    <a href="/user/mypage?userId=${userId }">
                        <div class="menu">
                            <p>회원정보 조회 / 수정</p>
                        </div>
                    </a>
                    <a href="/buyhistory/select?userId=${userId }&userName=${userName }">
                        <div class="menu">
                            <p>구매 내역</p>
                        </div>
                    </a>
                    <a href="/wishlist/select?userId=${userId }&userName=${userName }">
                        <div class="menu">
                            <p>찜 목록</p>
                        </div>
                    </a>
                    <a href="/user/removePage?userId=${userId }&userName=${userName }">
                        <div class="menu">
                            <p>회원 탈퇴</p>
                        </div>
                    </a>
                </div>
            </div>
            <div class="page-content">
                <div class="main-content">
                    <div class="div-information">
                        <p>${userName }님의 구매내역</p>
                    </div>
                        <p style="text-align : center; margin-top : 30px;">최근 구매한 10건의 내역만 보여드립니다</p>
                        <table class="title">
                            <col width="25%">
                            <col width="25%">
                            <col width="15%">
                            <col width="20%">
                            <col width="15%">
                            <thead>
                                <tr>
                                    <th>주문번호</th>
                                    <th>상품이름</th>
                                    <th>금액</th>
                                    <th>구매날짜</th>
                                    <th>배송현황</th>
                                </tr>
                            </thead>
                            <c:forEach items="${bList }" var="buyHistory" varStatus="index">
                            <tbody>
                                <tr>
                                    <td>${buyHistory.orderNo }</td>
                                    <td>${buyHistory.productName }</td>
                                    <td>${buyHistory.price }</td>
                                    <td>${buyHistory.buyDate }</td>
                                    <td>${buyHistory.shippingStatus }</td>
                                </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>