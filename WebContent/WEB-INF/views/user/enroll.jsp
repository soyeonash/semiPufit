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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pufitmembership.css">
    <title>퍼핏 회원가입</title>
</head>
<body>
	<script>
		$(document).ready(function(){
			
			$("#id-feedback").hide();
			$("#pw-feedback").hide();
			$("#pwre-feedback").hide();
			$("#name-feedback").hide();
			$("#email-feedback").hide();
			$("#phone-feedback").hide();
			$("#user-emailCheck").hide();
			
			var emailCheck = null;
			
			// 아이디 중복체크 ajax
			
			$(document).on("keyup", "#user-id", function(){
				
				var userId = $("#user-id").val();
				
				if(userId.length > 5 && userId.length < 11){
					$.ajax({
						type : "GET",
						url : "/ajax/idCheck",
						data : {
							"userId" : userId
						},
						success : function(response){
							$("#id-feedback").show();
							if(response == 1){
								$("#id-feedback").css("color", "red");
								$("#id-feedback").text("이미 가입된 아이디입니다");
								$("#user-id").css("border", "1px solid red")
							}else{
								$("#id-feedback").css("color", "green");
								$("#id-feedback").text("등록되지 않은 아이디입니다");
								$("#user-id").css("border", "1px solid green")
							}
						},
						error : function(xhr, status, err){
							alert(err)
						}
					})
				}else if(userId.length > 0){
					$("#id-feedback").show();
					$("#id-feedback").css("color", "red");
					$("#id-feedback").text("6자리 이상 적어주세요");
					$("#user-id").css("border", "1px solid red")
				}else{
					$("#id-feedback").show();
					$("#id-feedback").css("color", "red");
					$("#id-feedback").text("아이디는 필수정보 입니다");
					$("#user-id").css("border", "1px solid red")
				}
			})
			
			// 비밀번호 재확인 유효성 검사
			
			$(document).on("keyup", "#user-pwre", function(){
				var userPw = $("#user-pw").val();
				var userPwre = $("#user-pwre").val();
				
				if(userPwre.length > 7){
					if(userPwre != userPw){
						$("#pwre-feedback").show();
						$("#pwre-feedback").css("color", "red");
						$("#pwre-feedback").text("위 비밀번호와 동일하게 입력해주세요");
						$("#user-pwre").css("border", "1px solid red");
						$("#user-pwre").focus();
						return false;
					}else{
						$("#user-pwre").css("border", "1px solid green");
						$("#pwre-feedback").hide();
					}
				}
			})
			
			// 이메일 인증 
			
			$(document).on("click", "#membership-button", function(e){
				e.preventDefault();
				
				var userEmail = $("#user-email").val();
				var userEmailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
				if(userEmail == ""){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("이메일을 입력해주세요");
					$("#user-email").css("border", "1px solid red");
					$("#user-email").focus();
					return false;
				}else if(!userEmail == ""){
					$("#email-feedback").hide();
					$("#user-email").css("border", "1px solid green");
				}
				
				if(!userEmailReg.test(userEmail)){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("이메일을 양식에 맞게 입력해주세요");
					$("#user-email").css("border", "1px solid red");
					$("#user-email").focus();
					return false;
				}else{
					$("#user-email").css("border", "1px solid green");
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
			
			
			// 회원가입시 유효성 검사
			
			$(document).on("click", "#membership-submit", function(){
				
				var userId = $("#user-id").val();
				var userPw = $("#user-pw").val();
				var userPwre = $("#user-pwre").val();
				var userName = $("#user-name").val();
				var userEmail = $("#user-email").val();
				var userPhone = $("#user-phone").val();
				
				var userIdReg = /^[a-z0-9]{6,12}$/;
				var userPwReg = /^[A-Za-z0-9]{8,14}$/;
				var userNameReg = /^[가-힣]{1,7}$/;
				var userEmailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
				var userPhoneReg = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
				
				if(userId == ""){
					$("#id-feedback").show();
					$("#id-feedback").css("color", "red");
					$("#id-feedback").text("아이디를 입력해주세요");
					$("#user-id").css("border", "1px solid red");
					$("#user-id").focus();
					return false;
				}else if(!userId == ""){
					$("#id-feedback").hide();
					$("#user-id").css("border", "1px solid green");
				}
				
				if(!userIdReg.test(userId)){
					$("#id-feedback").show();
					$("#id-feedback").css("color", "red");
					$("#id-feedback").text("아이디를 양식에 맞게 입력해주세요");
					$("#user-id").css("border", "1px solid red");
					$("#user-id").focus();
					return false;
				}else{
					$("#user-id").css("border", "1px solid green");
				}
				
				if(userPw == ""){
					$("#pw-feedback").show();
					$("#pw-feedback").css("color", "red");
					$("#pw-feedback").text("비밀번호를 입력해주세요");
					$("#user-pw").css("border", "1px solid red");
					$("#user-pw").focus();
					return false;
				}else if(!userPw == ""){
					$("#pw-feedback").hide();
					$("#user-pw").css("border", "1px solid green");
				}
				
				if(!userPwReg.test(userPw)){
					$("#pw-feedback").show();
					$("#pw-feedback").css("color", "red");
					$("#pw-feedback").text("비밀번호를 양식에 맞게 입력해주세요");
					$("#user-pw").css("border", "1px solid red");
					$("#user-pw").focus();
					return false;
				}else{
					$("#user-pw").css("border", "1px solid green");
				}
				
				if(userPwre == ""){
					$("#pwre-feedback").show();
					$("#pwre-feedback").css("color", "red");
					$("#pwre-feedback").text("비밀번호 재입력을 입력해주세요");
					$("#user-pwre").css("border", "1px solid red");
					$("#user-pwre").focus();
					return false;
				}else if(!userPwre == ""){
					$("#pwre-feedback").hide();
					$("#user-pwre").css("border", "1px solid green");
				}
				
				if(userPwre != userPw){
					$("#pwre-feedback").show();
					$("#pwre-feedback").css("color", "red");
					$("#pwre-feedback").text("위 비밀번호와 동일하게 입력해주세요");
					$("#user-pwre").css("border", "1px solid red");
					$("#user-pwre").focus();
					return false;
				}else{
					$("#user-pwre").css("border", "1px solid green");
				}
				
				if(userName == ""){
					$("#name-feedback").show();
					$("#name-feedback").css("color", "red");
					$("#name-feedback").text("이름을 입력해주세요");
					$("#user-name").css("border", "1px solid red");
					$("#user-name").focus();
					return false;
				}else if(!userName == ""){
					$("#name-feedback").hide();
					$("#user-name").css("border", "1px solid green");
				}
				
				if(!userNameReg.test(userName)){
					$("#name-feedback").show();
					$("#name-feedback").css("color", "red");
					$("#name-feedback").text("이름은 한글로 입력해주세요");
					$("#user-name").css("border", "1px solid red");
					$("#user-name").focus();
					return false;
				}else{
					$("#user-name").css("border", "1px solid green");
				}
				
				if(userEmail == ""){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("이메일을 입력해주세요");
					$("#user-email").css("border", "1px solid red");
					$("#user-email").focus();
					return false;
				}else if(!userEmail == ""){
					$("#email-feedback").hide();
					$("#user-email").css("border", "1px solid green");
				}
				
				if(!userEmailReg.test(userEmail)){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("이메일을 양식에 맞게 입력해주세요");
					$("#user-email").css("border", "1px solid red");
					$("#user-email").focus();
					return false;
				}else{
					$("#user-email").css("border", "1px solid green");
				}
				
				if(emailCheck != $("#user-emailCheck").val()){
					$("#email-feedback").show();
					$("#email-feedback").css("color", "red");
					$("#email-feedback").text("인증번호가 틀렸습니다 인증번호를 다시 받아주시기 바랍니다");
					$("#user-email").css("border", "1px solid red");
					$("#user-email").focus();
					return false;
				}else{
					$("#user-email").css("border", "1px solid green");
				}
				
				if(userPhone == ""){
					$("#phone-feedback").show();
					$("#phone-feedback").css("color", "red");
					$("#phone-feedback").text("번호를 입력해주세요");
					$("#user-phone").css("border", "1px solid green");
					$("#user-phone").focus();
					return false;
				}else{
					$("#phone-feedback").hide();
					$("#user-phone").css("border", "1px solid green");
				}
				
				if(!userPhoneReg.test(userPhone)){
					$("#phone-feedback").show();
					$("#phone-feedback").css("color", "red");
					$("#phone-feedback").text("ex)010-1234-5678 양식으로 입력해주세요");
					$("#user-phone").css("border", "1px solid red");
					$("#user-phone").focus();
					return false;
				}
				
				
			})
		})
	</script>
    <div id="content">
        <h1>퍼핏에 오신것을 환영합니다</h1>
        <div id="login-box">
            <div>
                <form action="/user/enroll" method="post">
                    <fieldset style ="border : 0px;">
                        <legend style="width:100%;" style="padding:0px;"><b>아이디</b>
                            <div class="membership-div">
                                <input type="text"  class="membership-input" placeholder="소문자 + 숫자 조합 6~12자리로 입력해주세요" name="user-id" id="user-id">
                                <div class="feedback" id="id-feedback">아이디를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>비밀번호</b>
                            <div class="membership-div">
                                <input type="password"  class="membership-input" placeholder="대문자 + 소문자 + 숫자 조합 8~14자리 입력해주세요" name="user-pw" id="user-pw">
                                <div class="feedback" id="pw-feedback">비밀번호를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>비밀번호 재입력</b>
                            <div class="membership-div">
                                <input type="password"  class="membership-input" placeholder="비밀번호를 재입력 해주세요" name="user-pwre" id="user-pwre">
                                <div class="feedback" id="pwre-feedback">비밀번호를 재입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>이름</b>
                            <div class="membership-div">
                                <input type="text"  class="membership-input" placeholder="이름을 입력해주세요" name="user-name" id="user-name">
                                <div class="feedback" id="name-feedback">이름을 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>이메일</b>
                            <div class="membership-div">
                                    <input type="text"  class="membership-input" placeholder="example@pufit.com" id="user-email" name="user-email">
                                    <button id="membership-button">인증</button>
                                    <input type="text"  class="membership-input" placeholder="인증번호 10자리를 입력해주세요" name="user-emailCheck" id="user-emailCheck">
                                <div class="feedback" id="email-feedback">이메일을 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>전화번호</b>
                            <div class="membership-div">
                                <input type="text"  class="membership-input" placeholder="ex) 010-1234-5678 또는 01012345678" name="user-phone" id="user-phone">
                                <div class="feedback" id="phone-feedback">전화번호를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <div class="membership-box" id="membership-box">
                        <input type="submit" value="회원가입" id="membership-submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>