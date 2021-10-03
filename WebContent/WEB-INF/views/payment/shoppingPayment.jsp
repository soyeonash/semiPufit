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
    <link rel="stylesheet" type="text/css" href="../css/payment.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
    <title>shopping payment</title>
</head>
<body>
    <script>
    
    
    	$(document).ready(function(){
    		
    		$("#shipping-message").hide();
	    	$("#shipping-list").hide();
			    		
    		
    		// 배송지 저장하기
    		$(document).on("click", "#save", function(){
    			var main = $("#shipping-main").val();
    			var sub = $("#shipping-sub").val();
    			var name = $("#shipping-name").val();
    			var phone = $("#shipping-phone").val();
    			var id = $("#shipping-id").val();
    			
    			$.ajax({
    				type : "GET",
    				url : "/shipping/insert",
    				data : {
    					"shippingMain" : main,
    					"shippingSub" : sub,
    					"shippingName" : name,
    					"shippingPhone" : phone,
    					"shippingId" : id
    				},
    				success : function(response){
    					if(response < 3){
    						$("#shipping-message").show();
    						$("#shipping-message").text("저장되었습니다");
    						
    					}else{
    						$("#shipping-message").show();
    						$("#shipping-message").text("배송지는 최대 3개까지 저장됩니다");
    						$("#shipping-message").css("color", "red");
    					}
    				},
    				error : function(xhr, status, err){
    					alert(err)
    				}
    			})
    			
    		})
    		
    		var loadButton = $("#load-button");
    		
    		$.each(loadButton, function(index, item){
    			$(item).on("click", function(){
	    			$("#shipping-main").val($(".main-shipping").text());
	    			$("#shipping-sub").val($(".sub-shipping").text());
    			})
    		})
    		
    		
    		
    		// 배송지 불러오기
				$("#load").on("click", function(){
					if($("#shipping-list").css("display") == "none"){
						$("#shipping-list").show();
					}else{
						$("#shipping-list").hide();
					}
				})
			
				
				
			// 결제하기
			$("#pay-btn").on("click", function(){
				var method = $("#select").val();
				var email = $("#shipping-email").val();
				var name = $("#shipping-name").val();
				var phone = $("#shipping-phone").val();
				var mainAddr = $("#main-shipping").val();
				var subAddr = $("#sub-shipping").val();
				var IMP = window.IMP;
				IMP.init("imp53393678");
				IMP.request_pay({
					pg : "inicis",
					pay_method : method,
					merchant_uid : "merchant_" + new Date().getTime(),
					name : "주문명 : 결제테스트", // 상품이름
					amount : 1000, // 상품가격
					buyer_email : email,
					buyer_name : name,
					buyer_tel : phone,
					buyer_addr : "대표주소 : " + mainAddr + ",상세주소 : " + subAddr,
					buyer_postcode : "123-456",
				}, function(rsp){
					console.log(rsp);
					if(rsp.success){
						$.ajax({
							url : "/buyhistory/insert",
							type : "POST",
							data : {
								"userId" : $("#shipping-id").val(),
								"price" : rsp.paid_amount,
								"productName" : rsp.name,
								"paymentMethod" : rsp.pay_method
							},
							success : function(response){
								console.log(response.userId);
								location.href="/buyhistory/success?userId="+response.userId+"&price="+response.price+"&orderNo="+response.orderNo+"&productName="+response.productName;
							},
							error : function(xhr, status, err){
								console.log(err);
							}
						})
					}else{
						var msg = "결제를 실패하였습니다";
						msg += "에러내용 : " + rsp.error_msg;
				}	
				})
			})
    			
			
			
			
    		
    	})
    </script>
    <div id="content">
        <div id="payment-main">
            <h1>결제하기</h1>
            <div id="div-shipping">
                <div>
                    <h3>주문/배송 정보</h3>
                    <fieldset style ="border : 0px;">
                        <legend style="width:100%;" style="padding:0px;"><b>주문자</b>
                            <div class="user-inquiry">
                                <input type="text"  class="shipping-input" name="shipping-name" id="shipping-name" value="${user.userName }" readonly>
                                <input type="text"  class="shipping-input" name="shipping-phone" id="shipping-phone" value="${user.userPhone }" readonly>
                                <input type="text"  class="shipping-input" name="shipping-maininfo" id="shipping-email" value="${user.userEmail }" readonly>
                                <input type="hidden" name="shipping-id" id="shipping-id" value="${user.userId }">
                            </div>
                        </legend>
                    </fieldset>
                    <fieldset style ="border : 0px;">
                        <legend style="width:100%;" style="padding:0px;"><b>배송지 정보</b>
                            <div class="user-inquiry">
                                <input type="text"  class="shipping-input" name="shipping-name" id="shipping-name" value="${user.userName }">
                                <input type="text"  class="shipping-input" name="shipping-phone" id="shipping-phone" value="${user.userPhone }">
                                <input type="text"  class="shipping-input" name="shipping-main" id="shipping-main">
                                <input type="button" class="shipping-button" value="검색하기" id="search" onclick="goPopup();"><button class="shipping-button" id="load">불러오기</button>
                                <input type="text"  class="shipping-input" name="shipping-maininfo" id="shipping-sub">
                                <button class="shipping-button" id="save">저장하기</button><br>
                                <div class="feedback" id="shipping-message">비밀번호를 입력해주세요</div>
                            </div>
                        </legend>
                    </fieldset>
                    <div id="shipping-list">
                        <div>
                            <p><b>배송지 목록</b></p>
							<c:forEach items="${sList}" var="shipping" varStatus="index">
								<div class="shipping">
								<div id="shipping-content">
									<div class="main-shipping" id="main-shipping">${shipping.shippingMain }</div>
									<div class="sub-shipping" id="sub-shipping">${shipping.shippingSub}</div>
								</div>
								<div id="shipping-btn">
										<button id="load-button" class="inquiry-button">불러오기</button>
									<a href="/shipping/remove?shippingNo=${shipping.shippingNo }&userId=${shipping.userId}">
										<button id="remove-button" class="inquiry-button">삭제하기</button>
									</a>
								</div>
								</div>
							</c:forEach>
						</div>
                    </div>
                </div>
            </div>
            <div id="div-payment">
            	<div>
                    <h3>주문/배송 정보</h3>
                    <table class="title" id="jacket-size">
                        <thead>
                            <tr>
                                <th colspan="4">상품 이름</th>
                                <th>가격</th>
                            </tr>
                        </thead>
                        <c:forEach items="" var="" varStatus="">
                        <tbody>
                            <tr>
                                <th colspan="4">원피스 댕댕이 잠옷</th>
                                <td>10000</td>
                            </tr>
                        </tbody>
                        </c:forEach>
                    </table>
                    <div class="total-price">
                    	<p id="type">결제수단</p>
						<select id="select">
							<option value="card">신용카드</option>
							<option value="trans">계좌이체</option>
							<option value="phone">휴대폰</option>
							<option value="vbank">무퉁장입금</option>
						</select>
                    </div>
                    <div class="total-price" style="margin-top:0px;">
						<p id="payment-price">합계 금액 = 30000원</p>
                    </div>
                <button id="pay-btn" type="button">결제</button>
                </div>
            </div>
        </div>
    </div>
     <script language="javascript">
						function goPopup() {
							var pop = window.open("../user/jusoPopup1.jsp", "pop", "width=570,height=420, scrollbars=yes, resizable=yes");}
						function jusoCallBack(roadFullAddr, roadAddrPart1,
								addrDetail, roadAddrPart2, engAddr, jibunAddr,
								zipNo, admCd, rnMgtSn, bdMgtSn, detBdNmList,
								bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn,
								udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm,
								lnbrSlno, emdNo) {
							document.getElementById("shipping-main").value = roadAddrPart1;
							document.getElementById("shipping-sub").value = addrDetail;
						}
					</script>
</body>
</html>