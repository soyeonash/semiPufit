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
    <link rel="stylesheet" type="text/css" href="../css/wishList.css">
    <title>찜 목록</title>
</head>
<body>
    <div id="content">
        <div class="mypage-main">
            <div class="sidebar">
                <div class="side">
                    <div class="menu" id="menu-bar">
                        <p>마이페이지</p>
                    </div>
                    <a href="">
                        <div class="menu">
                            <p>회원정보 조회 / 수정</p>
                        </div>
                    </a>
                    <a href="">
                        <div class="menu">
                            <p>구매 내역</p>
                        </div>
                    </a>
                    <a href="">
                        <div class="menu">
                            <p>찜 목록</p>
                        </div>
                    </a>
                    <a href="">
                        <div class="menu">
                            <p>회원 탈퇴</p>
                        </div>
                    </a>
                </div>
            </div>
            <div class="page-content">
                <div class="main-content">
                    <div class="div-information">
                        <p>${userId }님의 찜목록</p>
                    </div>
                    <div id="div-wish">
                    	   <h2>찜목록이 비어있습니다.</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>