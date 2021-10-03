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
    <link rel="stylesheet" type="text/css" href="../css/successPayment.css">
    <title>payment</title>
</head>
<body>
    <h1>결제가 완료되었습니다.</h1>
    <div class="div-success">
    <table class="title">
            <col width="30%">
            <col width="45%">
            <col width="10%">
            <col width="15%">
        <thead>
            <tr>
                <th>주문번호</th>
                <th>상품이름</th>
                <th>금액</th>
                <th>구매자 아이디</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${buyHistory.orderNo }</td>
                <td>${buyHistory.productName }</td>
                <td>${buyHistory.price }</td>
                <td>${buyHistory.userId }</td>
            </tr>
        </tbody>
    </table>
    </div>
</body>
</html>