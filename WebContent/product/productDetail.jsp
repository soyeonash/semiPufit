<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./productDetail.css" />
</head>
<body>
	<header>
	
	</header>
	<main>
		<h1>상품 Detail 페이지입니다!</h1>
	
		<img alt="test" src="../productImgFolder/${requestScope.productOne.productImgName}">
		<p>
			상위 : ${productOne.highKind } &nbsp;&nbsp;&nbsp;&nbsp; 하위 : ${productOne.rowKind }<br>
			가격 : ${productOne.productPrice }<br>
			사이즈 : ${productOne.productSize }<br>
			<select style="width: 100px; height: 30px; font-size: 20px;" name="sizeOption">
				<option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
            </select>
		</p>
		<button>장바구니</button>
		<div>
			<img id="heartImg" alt="하트(찜하기)" src="./wishListHeartImg/heart.png"><br>
		</div>
		<button>결제하기</button>
		<p>
			설명 : ${productOne.productContents }
		</p>
		<div id="insertRe">
			<h2>댓글</h2><hr>
			<div><button id="popupBtn">댓글 등록</button></div>
			<div id="popup1">
					<form action="/productReply/write" method="post">
						상품 이름 : ${productOne.productName } <br>
						별점 : <input type="radio" name="productReplyRadio" value="1" checked="checked">1
						<input type="radio" name="productReplyRadio" value="2">2
						<input type="radio" name="productReplyRadio" value="3">3
						<input type="radio" name="productReplyRadio" value="4">4
						<input type="radio" name="productReplyRadio" value="5">5 <br>
						<div id = "result"></div>
						<input type="text" name="productReplyComment" placeholder="댓글을 입력해주세요"><br>
						<input type="hidden" name="productCode" value="${productOne.productCode}">
						<!-- <input type="reset" value="취소">		 -->	
						<input type="submit" value="등록">
					</form>
			</div>
			<hr>
		</div>
	
		<div>
			<c:forEach items="${productOne.replyList}" var="reply" varStatus="index">
				<div style="border: 1px solid black">
				
				별점 : ${reply.productReplyScore }
				설명 : ${reply.productReplyContents }
				작성자 : ${reply.writerId}
				넘버 : ${reply.productReplyNo }
				<button id="modifyReply" value="${reply.productReplyNo }">수정</button>&nbsp;&nbsp;
				<a href="/productReply/delete?productCode${reply.productCode}&productReplyNo=${reply.productReplyNo}">삭제</a>
				<div class="modifyRe">
						<div id="popup2">
								넘버 : ${reply.productReplyNo }
								<h2>댓글 수정</h2><hr>
								<form action="/productReply/modify" method="post">
									상품 이름 : ${productOne.productName } <br>
									<%-- 별점 : <input type="radio" name="productReplyRadio" value="1">1
									<input type="radio" name="productReplyRadio" value="2">2
									<input type="radio" name="productReplyRadio" value="3">3
									<input type="radio" name="productReplyRadio" value="4">4
									<input type="radio" name="productReplyRadio" value="5">5 <br>
									별점2 : ${productReply.productReplyScore }<br> --%>
									<input type="text" name="productReplyComment" placeholder="수정할 댓글을 입력해주세요."><br>
									<input type="hidden" name="productReplyComment" value="${reply.productReplyContents}" >
									<input type="hidden" name="productReplyNo" value="${reply.productReplyNo}" >
									<input type="hidden" name="productCode" value="${reply.productCode}">
									<input type="submit" value="수정">
								</form>
						</div>
				</div>
				</div>
				<hr>
			</c:forEach>
		</div>
		
		<!-- 전송용 폼태그, 보이지 않음 -->
<!-- 		<form action="/productReply/modify" method="post" id="modifyForm">
			<input type="hidden" name="productReplyContents" id="modifyReplyContents">
			<input type="hidden" name="productReplyNo" id="modifyReplyNo">
			<input type="hidden" name="productCode" id="modifyNoticeNo">
		</form>  -->
	</main>
	
</body>
	<script type="text/javascript">
		
		$(function() {
			$("#heartImg").click(function() {
				$("#heartImg").attr("src", "./wishListHeartImg/heart2.png");
				//var src = $("#heartImg").attr("src");
				alert("찜목록에 추가되었습니다.");
				//if문을 줘서 누르면 찜목록에 있는지 조회(select)한 다음에 없으면 insert, 있으면 추가안되게..
			});
			$("#popupBtn").click(function() {
				$("#popup1").fadeIn();
			});
			$("#modifyReply").click(function() {
				$("#popup2").fadeIn();
				alert("클릭이벤트!");
			});
			/* $("#insertRe").mouseup(function() {
				if(
				$("#popup").fadeOut();
			}); */
			$(document).mouseup(function (e){
				  var LayerPopup = $("#insertRe");
				  var LayerPopup2 = $("#modifyRe");
				  if(LayerPopup.has(e.target).length === 0){
					  $("#popup1").fadeOut();
				  }
				  if(LayerPopup2.has(e.target).length === 0){
					  $("#popup2").fadeOut();
				  } 
			});
			
/* 	        $("select[name=sizeOption]").change(function() {
				//var selectOne=$("select[name=productOption] option:selected").text();
				//var item = $("#category").val();
				var selectOne = $(this).val();
				
				location.href="/product/detail?productCode="+productCode;
				$(this).val().prop("selected", true);

			});  */
	        
		});
	</script>
</html>