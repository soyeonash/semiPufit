<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/remove.css">
    <title>회원탈퇴</title>
</head>
<body>
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
                        <p>회원탈퇴</p>
                    </div>
                    <form action="/user/remove" method="post">
                        <div id="content-bar">
                            <p>회원님의 탈퇴를 위해 </p> <p style="color:red;">&nbsp;비밀번호를 한번 더 입력</p> <p>해주시기 바랍니다</p>
                        </div>
                        <div id="pw-div">
                        	<input type="hidden" name="user-id" value="${userId }">
                            <input type="password" name="user-pw" id="user-pw" placeholder="비밀번호를 입력해주세요">
                        </div>
                        <input type="submit" value="회원탈퇴" class="remove-button">
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>