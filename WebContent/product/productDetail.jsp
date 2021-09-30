<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
</head>
<body>
	<h1>상품 Detail 페이지입니다!</h1>

	<img alt="test" src="../productImgFolder/${requestScope.productOne.productImgName}">
	<p>
		상위 : ${productOne.highKind } &nbsp;&nbsp;&nbsp;&nbsp; 하위 : ${productOne.rowKind }<br>
		가격 : ${productOne.productPrice }<br>
		사이즈 : ${productOne.productSize }<br>
	</p>
	<button>장바구니</button><img alt="하트(찜하기)" src=""><br>
	<button>결제하기</button>
	<p>
		설명 : ${productOne.productContents }
	</p>
	<div>
		<h2>댓글</h2><hr>
		<form action="/productReply/write" method="post">
			상품 이름 : ${productOne.productName } <br>
			별점 : <input type="radio" name="productReplyRadio" value="1" checked="checked">1
			<input type="radio" name="productReplyRadio" value="2">2
			<input type="radio" name="productReplyRadio" value="3">3
			<input type="radio" name="productReplyRadio" value="4">4
			<input type="radio" name="productReplyRadio" value="5">5 <br>
			<div id = "result"></div>
			<h4>댓글 입력</h4>
			<input type="text" name="productReplyComment" placeholder="댓글을 입력해주세요"><br>
			<input type="hidden" name="productCode" value="${productOne.productCode}">
			<input type="reset" value="취소">			
			<input type="submit" value="등록">
		</form><hr>
		
	</div>

	<table>
		<tr><th>별점</th><th>설명</th><th>작성자</th><th></th></tr>
		<c:forEach items="${requestScope.productOne.replies}" var="reply" varStatus="index">
			<tr>
				<td>${reply.productReplyScore }</td>
				<td>${reply.productReplyContents }</td>
				<td>${reply.writerId}</td>
				<td>
					<a href="javascript:void(0)" onclick="showModifyReply(this)">수정</a>&nbsp;&nbsp;
					<a href="/productReply/delete?productCode${reply.productCode}&productReplyNo=${reply.productReplyNo}">삭제</a>
				</td>
			</tr>
			<tr style="display:none;">
				<td><input type="text" size="40" value="${reply.replyContents }" id="modifyReply"></td>
				<td>
					<a href="javascript:void(0)" onclick="modifyReply(this,${reply.productReplyNo},${reply.productCode})">수정완료</a>&nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="hideModifyReply(this)">취소</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 전송용 폼태그, 보이지 않음 -->
	<form action="/productReply/modify" method="post" id="modifyForm">
		<input type="hidden" name="productReplyContents" id="modifyReplyContents">
		<input type="hidden" name="productReplyNo" id="modifyReplyNo">
		<input type="hidden" name="productCode" id="modifyNoticeNo">
	</form>
	
	<script type="text/javascript">
/* 	function modifyReply(obj, productReplyNo, productCode){
		var contents = $(obj).parent().prev().find("input").val();
//		var contents = $("#modifyReply").val();
		$("#modifyReplyContents").val(productReplyContents);
		$("#modifyReplyNo").val(productCode);
		$("#modifyNoticeNo").val(productReplyNo);
		$("#modifyForm").submit();
	}
 	function showModifyReply(obj){
		$(obj).parents("tr").next().show();
		$(obj).parents("tr").hide();			
	}
	function hideModifyReply(obj){
		$(obj).parents("tr").prev().show();
		$(obj).parents("tr").hide();
	} */
	</script>
</body>
</html>