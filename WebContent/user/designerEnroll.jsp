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
    <link rel="stylesheet" type="text/css" href="../css/designerEnroll.css">
    <title>디자이너 회원가입</title>
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
		$("#license-feedback").hide();
		$("#account-feedback").hide();
		
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
		
		$(document).on("click", "#membership-submit", function(){
			
			var userId = $("#user-id").val();
			var userPw = $("#user-pw").val();
			var userPwre = $("#user-pwre").val();
			var userName = $("#user-name").val();
			var userEmail = $("#user-email").val();
			var userPhone = $("#user-phone").val();
			var designerLicense = $("#user-license").val();
			var designerAccount = $("#user-account").val();
			
			var userIdReg = /^[a-z0-9]{6,12}$/;
			var userPwReg = /^[A-Za-z0-9]{8,14}$/;
			var userNameReg = /^[가-힣]{1,7}$/;
			var userPhoneReg = /^01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}$/;
			var userEmailReg = /^([\w\.\_\-])*[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
			var userPhoneReg = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
			var designerLicenseReg = /^(\d{3,3})+[-]+(\d{2,2})+[-]+(\d{5,5})$/;

			
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
			}else {
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
			}else if(userNameReg.test(userName)){
				$("#user-name").css("border", "1px solid green");
			}
			
			if(userPhone == ""){
				$("#phone-feedback").show();
				$("#phone-feedback").css("color", "red");
				$("#phone-feedback").text("이름을 입력해주세요");
				$("#user-phone").css("border", "1px solid red");
				$("#user-phone").focus();
				return false;
			}else if(!userPhone == ""){
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
			}else{
				$("#user-phone").css("border", "1px solid green");
			}
			
			if(userEmail == ""){
				$("#email-feedback").show();
				$("#email-feedback").css("color", "red");
				$("#email-feedback").text("이메일을 입력해주세요");
				$("#user-email").css("border", "1px solid red");
				$("#user-email").focus();
				return false;
			}else{
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
			
			if(designerLicense == ""){
				$("#license-feedback").show();
				$("#license-feedback").css("color", "red");
				$("#license-feedback").text("사업자 등록번호를 입력해주세요");
				$("#user-license").css("border", "1px solid red");
				$("#user-license").focus();
				return false;
			}else{
				$("#license-feedback").hide();
				$("#user-license").css("border", "1px solid green");
			}
			
			if(!designerLicenseReg.test(designerLicense)){
				$("#license-feedback").show();
				$("#license-feedback").css("color", "red");
				$("#license-feedback").text("양식에 맞게 입력해주세요");
				$("#user-license").css("border", "1px solid red");
				$("#user-license").focus();
				return false;
			}else{
				$("#user-license").css("border", "1px solid green");
			}
			
			if(designerAccount == ""){
				$("#account-feedback").show();
				$("#account-feedback").css("color", "red");
				$("#account-feedback").text("계좌번호를 입력해주세요");
				$("#user-account").css("border", "1px solid red");
				$("#user-account").focus();
				return false;
			}
			

		})
	})
    </script>
    <div id="content">
        <h1>퍼핏에 오신것을 환영합니다</h1>
        <div id="login-box">
            <div>
                <form action="/designer/enroll" method="post">
                    <fieldset style ="border : 0px;">
                        <legend style="width:100%;" style="padding:0px;"><b>아이디</b>
                            <div class="membership-div">
                                <input type="text"  class="membership-input" placeholder="영문 + 숫자 조합 6~14자리로 입력해주세요" name="designer-id" id="user-id">
                                <div class="feedback" id="id-feedback">아이디를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>비밀번호</b>
                            <div class="membership-div">
                                <input type="password"  class="membership-input" placeholder="영문 + 숫자 조합 8~14자리 입력해주세요" name="designer-pw" id="user-pw">
                                <div class="feedback" id="pw-feedback">비밀번호를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>비밀번호 재입력</b>
                            <div class="membership-div">
                                <input type="password"  class="membership-input" placeholder="비밀번호를 재입력 해주세요" name="designer-pwre" id="user-pwre">
                                <div class="feedback" id="pwre-feedback">비밀번호를 재입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>이름</b>
                            <div class="membership-div">
                                <input type="text"  class="membership-input" placeholder="이름을 입력해주세요" name="designer-name" id="user-name">
                                <div class="feedback" id="name-feedback">이름을 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>전화번호</b>
                            <div class="membership-div">
                                <input type="text"  class="membership-input" placeholder="ex) 010-1234-5678 또는 01012345678" name="designer-phone" id="user-phone">
                                <div class="feedback" id="phone-feedback">전화번호를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>이메일</b>
                            <div class="membership-div">
                                    <input type="text" placeholder="example@pufit.com" class="user-bar" name="designer-email" id="user-email">
                                    <button id="membership-button">인증</button>
                                <div class="feedback" id="email-feedback">이메일을 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>사업자 등록번호</b>
                            <div class="membership-div">
                                    <input type="text"  placeholder="ex)110-11-11111" class="user-bar" name="designer-license" id="user-license">
                                    <button id="membership-button">등록</button>
                                <div class="feedback" id="license-feedback">등록완료</div>
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px; margin-top:25px;">
                        <legend style="width:100%;"><b>계좌번호</b>
                            <div class="membership-div">
                                    <input type="text" placeholder="계좌번호를 입력해주세요" class="user-account" name="designer-account" style="float:left" id="user-account">
                                    <div id="selected">
                                        <select name="designer-bank">
                                            <option value="신한은행">신한</option>
                                            <option value="국민은행">국민</option>
                                            <option value="농협은행">농협</option>
                                            <option value="우리은행">우리</option>
                                            <option value="기업은행">기업</option>
                                        </select>
                                    </div>
                                    <br>
                            </div>
                        </legend>
                        <div class="feedback" id="account-feedback">등록완료</div>
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