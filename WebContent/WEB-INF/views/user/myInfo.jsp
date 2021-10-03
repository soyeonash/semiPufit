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
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myInfo.css">
    <title>마이 페이지</title>
</head>
<body>
    <script>
        $(document).ready(function(){
            $("#pw-feedback").hide();
            $("#pwre-feedback").hide();
            $("#phone-feedback").hide();
            $("#email-feedback").hide();
            $("#user-emailCheck").hide();
            
            var emailCheck = null;
            
            // 비밀번호 재인증 유효성 검사
            
			$(document).on("keyup", "#user-pwre", function(){
				var userPw = $("#user-pw").val();
                var userPwre = $("#user-pwre").val();
                
                if(userPwre.length > 7){
                	if(userPwre != userPw){
                        $("#pwre-feedback").show();
                        $("#user-pwre").focus();
                        $("#pwre-feedback").text("위 비밀번호와 동일하게 작성해주세요");
                        $("#pwre-feedback").css("color", "red");
                        return false;
                    }else{
                        $("#pwre-feedback").hide();
                    }
                }
				
			})
			
			
			// 이메일 인증
			
			$(document).on("click", ".inquiry-button", function(e){
				e.preventDefault();
				
				var userEmail = $("#user-email").val();
				var userEmailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
				if(userEmail == ""){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("이메일을 입력해주세요");
					$("#user-email").focus();
					return false;
				}else if(!userEmail == ""){
					$("#email-feedback").hide();
				}
				
				
				if(!userEmailReg.test(userEmail)){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("이메일을 양식에 맞게 입력해주세요");
					$("#user-email").focus();
					return false;
				}else{
					$("#email-feedback").hide();
				}
				
				$.ajax({
					type : "get",
					url : "/ajax/emailCheck",
					async : false,
					data : {
						"userEmail" : userEmail
					},
					success : function(response){
						$("#user-emailCheck").show();
						emailCheck = response;
						return true;
					},
					error : function(xhr, status, arr){
						return false;
						alert(err);
					}
					
				})
				
			})
			
			
			// 수정 버튼 클릭 시 유효성 검사 

            $(document).on("click", ".inquiry-submit", function(){
                var userPw = $("#user-pw").val();
                var userPwre = $("#user-pwre").val();
                var userEmail = $("#user-email").val();
                var userPhone = $("#user-phone").val();

                var userPwReg = /^[A-Za-z0-9]{8,14}$/;
                var userEmailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
				var userPhoneReg = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

                if(userPw == ""){
                    $("#pw-feedback").show();
                    $("#user-pw").focus();
                    $("#pw-feedback").text("비밀번호를 입력해주세요");
                    $("#pw-feedback").css("color", "red");
                    return false;
                }else{
                    $("#pw-feedback").hide();
                }

                if(!userPwReg.test(userPw)){
                    $("#pw-feedback").show();
                    $("#user-pw").focus();
                    $("#pw-feedback").text("소문자, 대문자, 숫자 8 ~ 14자리로 작성해주세요");
                    $("#pw-feedback").css("color", "red");
                    return false;
                }else{
                    $("#pw-feedback").hide();
                }

                if(userPwre == ""){
                    $("#pwre-feedback").show();
                    $("#user-pwre").focus();
                    $("#pwre-feedback").text("비밀번호 재입력을 입력해주세요");
                    $("#pwre-feedback").css("color", "red");
                    return false;
                }else{
                    $("#pwre-feedback").hide();
                }
                if(userPwre.length > 7){
                	if(userPwre != userPw){
                        $("#pwre-feedback").show();
                        $("#user-pwre").focus();
                        $("#pwre-feedback").text("위 비밀번호와 동일하게 작성해주세요");
                        $("#pwre-feedback").css("color", "red");
                        return false;
                    }else{
                        $("#pwre-feedback").hide();
                    }
                }


                if(userEmail == ""){
                    $("#email-feedback").show();
                    $("#user-email").focus();
                    $("#email-feedback").text("이메일을 입력해주세요");
                    $("#email-feedback").css("color", "red");
                    return false;
                }else{
                    $("#email-feedback").hide();
                }

                if(!userEmailReg.test(userEmail)){
                    $("#email-feedback").show();
                    $("#user-email").focus();
                    $("#email-feedback").text("ex) pufit@pufit.com");
                    $("#email-feedback").css("color", "red");
                    return false;
                }else{
                    $("#email-feedback").hide();
                }
                
                if(emailCheck != $("#user-emailCheck").val()){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("인증번호가 틀렸습니다 인증번호를 다시 받아주시기 바랍니다");
					$("#user-email").focus();
					return false;
				}else{
					$("#email-feedback").hide();
				}
                
                

                if(userPhone == ""){
                    $("#phone-feedback").show();
                    $("#user-phone").focus();
                    $("#phone-feedback").text("번호를 입력해주세요");
                    $("#phone-feedback").css("color", "red");
                    return false;
                }else{
                    $("#phone-feedback").hide();
                }

                if(!userPhoneReg.test(userPhone)){
                    $("#phone-feedback").show();
                    $("#user-phone").focus();
                    $("#phone-feedback").text("ex) 01012341234 또는 010-1234-1234");
                    $("#phone-feedback").css("color", "red");
                    return false;
                }else{
                    $("#phone-feedback").hide();
                }


            })

        })
    </script>
    <div id="content">
        <div class="mypage-main">
            <div class="sidebar">
                <div class="side">
                    <div class="menu" id="menu-bar">
                        <p>마이페이지</p>
                    </div>
                    <a href="/user/mypage?userId=${user.userId }">
                        <div class="menu">
                            <p>회원정보 조회 / 수정</p>
                        </div>
                    </a>
                    <a href="/buyhistory/select?userId=${user.userId }&userName=${user.userName }">
                        <div class="menu">
                            <p>구매 내역</p>
                        </div>
                    </a>
                    <a href="/wishlist/select?userId=${user.userId }&userName=${user.userName }">
                        <div class="menu">
                            <p>찜 목록</p>
                        </div>
                    </a>
                    <a href="/user/removePage?userId=${user.userId }&userName=${user.userName }">
                        <div class="menu">
                            <p>회원 탈퇴</p>
                        </div>
                    </a>
                </div>
            </div>
            <div class="page-content">
                <div class="main-content">
                    <div class="div-information">
                        <p>${user.userName }님의 회원정보</p>
                    </div>
                    <form action="/user/modify" method="post">
                        <div>
                            <fieldset style ="border : 0px;">
                                <legend style="width:100%;" style="padding:0px;"><b>아이디</b>
                                    <div class="user-inquiry">
                                        <div class="no-modify">${user.userId}</div>
                                        <input type="hidden" name="user-id" value="${user.userId }">
                                    </div>
                                </legend>
                            </fieldset>
                            <fieldset style ="border : 0px;">
                                <legend style="width:100%;" style="padding:0px;"><b>비밀번호</b>
                                    <div class="user-inquiry">
                                        <input type="password"  class="inquiry-input" name="user-pw" id="user-pw">
                                        <div class="modify" id="pw-feedback">양식에 맞게 입력해주세요</div>
                                    </div>
                                </legend>
                            </fieldset>
                            <fieldset style ="border : 0px;">
                                <legend style="width:100%;" style="padding:0px;"><b>비밀번호 재입력</b>
                                    <div class="user-inquiry">
                                        <input type="password"  class="inquiry-input" name="user-pwre" id="user-pwre">
                                        <div class="modify" id="pwre-feedback">양식에 맞게 입력해주세요</div>
                                    </div>
                                </legend>
                            </fieldset>
                            <fieldset style ="border : 0px;">
                                <legend style="width:100%;" style="padding:0px;"><b>이름</b>
                                    <div class="user-inquiry">
                                        <div class="no-modify" name="user-id">${user.userName }</div>
                                    </div>
                                </legend>
                            </fieldset>
                            <fieldset style ="border : 0px;">
                                <legend style="width:100%;" style="padding:0px;"><b>이메일</b>
                                    <div class="user-inquiry">
                                        <input type="text"  class="inquiry-input" name="user-email" id="user-email" value="${user.userEmail }">
                                        <button class="inquiry-button">인증</button><br>
                                        <input type="text"  class="inquiry-input" name="user-email" id="user-emailCheck">
                                        <div class="modify" id="email-feedback">양식에 맞게 입력해주세요</div>
                                    </div>
                                </legend>
                            </fieldset>
                            <fieldset style ="border : 0px;">
                                <legend style="width:100%;" style="padding:0px;"><b>전화번호</b>
                                    <div class="user-inquiry">
                                        <input type="text"  class="inquiry-input" name="user-phone" id="user-phone" value="${user.userPhone }">
                                        <div class="modify" id="phone-feedback">양식에 맞게 입력해주세요</div>
                                    </div>
                                </legend>
                            </fieldset>
                            <input type="submit" value="수정하기" class="inquiry-submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>