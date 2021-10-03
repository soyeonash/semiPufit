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
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <title>로그인</title>
</head>
<body>
<script>
	$(document).ready(function(){
		
		$("#div-forid").hide();
		$("#div-forpw").hide();
		
		$("#sect01").click(function(){
            $("#id-bar").val("");
            $("#id-bar").focus();
        })
        $("#sect02").click(function(){
            $("#pw-bar").val("");
            $("#pw-bar").focus();
        })
        $("#sect03").click(function(){
            $("#forname-bar").val("");
            $("#forname-bar").focus();
        })
        $("#sect04").click(function(){
            $("#foremail-bar").val("");
            $("#foremail-bar").focus();
        })
        $("#sect05").click(function(){
            $("#forid-bar").val("");
            $("#forid-bar").focus();
        })
        $("#sect06").click(function(){
            $("#forpwemail-bar").val("");
            $("#forpwemail-bar").focus();
        })

        $("#page").click(function(event){
            event.preventDefault;
        })
        $(".for-id").click(function(event){
            event.preventDefault;
            $("#login-block").css("display", "none");
            $("#forid-block").css("display", "block");
            $("#forpw-block").css("display", "none");
        })
        $(".for-pw").click(function(event){
            event.preventDefault;
            $("#login-block").css("display", "none");
            $("#forid-block").css("display", "none");
            $("#forpw-block").css("display", "block");
        })
        $(".for-login").click(function(event){
            event.preventDefault;
            $("#login-block").css("display", "block");
            $("#forid-block").css("display", "none");
            $("#forpw-block").css("display", "none");
        })
        
        $(document).on("click", "#forid-button", function(){
        	$.ajax({
        		type : "GET",
        		url : "/ajax/forId",
        		data : {
        			"userName" : $("#forname-bar").val(),
        			"userEmail" : $("#foremail-bar").val()
        		},
        		success : function(response){
        			$("#div-forid").show();
        			if(response == 'NO'){
        				$("#div-forid").text("가입되지 않은 정보입니다");
        				$("#div-forid").css("color", "red");
        			}else{
        				$("#div-forid").text("사용자 ID : " + response);
        				$("#div-forid").css("font-weight", "bold");
        			}
        		},
        		error : function(xhr, status, err){
        			alert(err)
        		}
        	})
        })
        
        $(document).on("click", "#forpw-button", function(){
        	$.ajax({
        		type : "GET",
        		url : "/ajax/forPw",
        		data : {
        			"userId" : $("#forid-bar").val(),
        			"userEmail" : $("#forpwemail-bar").val()
        		},
        		success : function(response){
            			$("#div-forpw").show();
        			if(response == 'NO'){
            			$("#div-forpw").text("가입되지 않은 정보입니다");
        				$("#div-forpw").css("color", "red");
        			}else{
            			$("#div-forpw").text("비밀번호가 12345678로 초기화 되었습니다");
        				$("#div-forpw").css("font-weight", "bold");
        			}
        	
        		},
        		error : function(xhr, status, err){
        			alert(err)
        		}
        	})
        })
        
	})
</script>
    <div id="content">
        <div id="login-box">
            <div id="login-block">
                <h1>LOGIN</h1>
                <form action="/user/login" method="post">
                    <input type="text" name="id-bar" class="login-bar" placeholder="ID" id="id-bar">
                    <div id="sect01">
                        <div class="line-box">
                          <span class="line-01"></span>
                          <span class="line-02"></span>
                        </div>
                    </div>
                    <br>
                    <input type="password" name="pw-bar" class="login-bar" placeholder="PASSWORD" style="margin-top:0px" id="pw-bar">
                    <div id="sect02">
                        <div class="line-box">
                          <span class="line-01"></span>
                          <span class="line-02"></span>
                        </div>
                    </div>
                    <input type="submit" formaction="/user/login" id="login-button" value="일반회원 로그인">
                    <input type="submit" formaction="/designer/login" id="designer-button" value="디자이너 로그인">
                </form>
                <div class="forid">
                    <p><a href="/user/enroll.jsp" id="page">회원가입</a> | <a href="javascript:void(0)" class="for-id">아이디찾기</a> | <a href="javascript:void(0)" class="for-pw">비밀번호찾기</a></p>
                </div>
            </div>
            <div id="forid-block" style="display:none">
                <h1>아이디 찾기</h1>
                    <input type="text" name="forname-bar" class="login-bar" placeholder="이름" id="forname-bar">
                    <div id="sect03">
                        <div class="line-box">
                          <span class="line-01"></span>
                          <span class="line-02"></span>
                        </div>
                    </div>
                    <br>
                    <input type="text" name="foremail-bar" class="login-bar" placeholder="example@pufit.com" style="margin-top:0px" id="foremail-bar">
                    <div id="sect04">
                        <div class="line-box">
                          <span class="line-01"></span>
                          <span class="line-02"></span>
                        </div>
                    </div>
                    <div id="div-forid"></div>
                    <input type="button" name="" id="forid-button" value="찾기">
                <div class="forid">
                    <p><a href="javascript:void(0)" class="for-login">로그인</a> | <a href="javascript:void(0)" class="for-pw">비밀번호찾기</a></p>
                </div>
            </div>
            <div id="forpw-block" style="display:none">
                <h1>비밀번호 찾기</h1>
                    <input type="text" name="forid-bar" class="login-bar" placeholder="ID" id="forid-bar">
                    <div id="sect05">
                        <div class="line-box">
                          <span class="line-01"></span>
                          <span class="line-02"></span>
                        </div>
                    </div>
                    <br>
                    <input type="text" name="forpwemail-bar" class="login-bar" placeholder="example@pufit.com" style="margin-top:0px" id="forpwemail-bar">
                    <div id="sect06">
                        <div class="line-box">
                          <span class="line-01"></span>
                          <span class="line-02"></span>
                        </div>
                    </div>
                    <div id="div-forpw"></div>
                    <input type="submit" name="" id="forpw-button" value="찾기">
                <div class="forid">
                    <p><a href="javascript:void(0)" class="for-login">로그인 | <a href="javascript:void(0)" class="for-id">아이디찾기</a></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>