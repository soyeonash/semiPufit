<%@page import="qna.model.vo.Qna"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%
	List<Qna> qList = (List<Qna>) request.getAttribute("qList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<style>
#qnaListMain {
	padding: 20px;
}

.qnaListTable {
	width: 100%;
	border: 1px solid #999;
	max-width: 700px;
	margin: 0px auto;
}
.qnsBtnDiv{
	margin: 30px auto 0px auto;
	max-width: 700px;
	width: 100%;
	display: flex;
}

.qnsBtnDiv > button:first-child{
margin-left:auto;
}
.qnsBtnDiv > button{
margin:10px;
}

.qnaListTable tr td {
	border: 1px solid #d4d4d4;
	text-align: center;
	cursor: pointer;
}

.qnaListTable thead tr td {
	height: 50px;
	background-color: #ceece5;
}

.qnaListTable tbody tr:hover {
	background-color: #efefef;
}

.qnaListTable tbody tr td {
	height: 30px;
}

.qnaListTable tr td:last-child {
	width: 70%;
}

.accordion-button:not(.collapsed){
	color: #000;
	background-color: #ceece5;
}

.accordion-button:focus {
	box-shadow: none;
}
</style>

<body>
	<jsp:include page="../common/top_include.jsp" flush="false" />

	<main id="qnaListMain">
		<h1>공지사항</h1>
		<br>
		<h2>자주하는 질문</h2>
		<div class="accordion" id="accordionExample">
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingOne">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseOne"
						aria-expanded="false" aria-controls="collapseOne">Q.
						[교환/반품] 주문한 상품이 아닌 다른 상품 또는 불량상품이 배송되었습니다.</button>
				</h2>
				<div id="collapseOne" class="accordion-collapse collapse"
					aria-labelledby="headingOne" data-bs-parent="#accordionExample">
					<div class="accordion-body">먼저, 하자/오배송으로 불편을 드려 죄송합니다. 퍼핏에서
						책임을 지고 정상제품으로 교환해 드리겠습니다! 잘못된 상품의 검품 및 재준비를 위해서 상품을 반드시 퍼핏 측으로
						보내주셔야 처리가 되니, 번거로우시더라도 부탁드리겠습니다.</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingTwo">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseTwo"
						aria-expanded="false" aria-controls="collapseTwo">Q.
						[구매]취소/반품했는데 언제 환불되나요?</button>
				</h2>
				<div id="collapseTwo" class="accordion-collapse collapse"
					aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
					<div class="accordion-body">상품을 취소/반품할 경우, 환불은 판매자가 '취소/반품완료'
						승인 후 처리됩니다. 또한, 환불 소요기간은 평일 기준으로 토/일/공휴일로 제외되며, 무통장입금, 편의점결제의 환불은
						해당일 오후 2시~6시 사이 입금확인이 가능합니다.</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingThree">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree">
						Accordion Item #3</button>
				</h2>
				<div id="collapseThree" class="accordion-collapse collapse"
					aria-labelledby="headingThree" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<strong>This is the third item's accordion body.</strong> It is
						hidden by default, until the collapse plugin adds the appropriate
						classes that we use to style each element. These classes control

					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingFour">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseFour"
						aria-expanded="false" aria-controls="collapseFour">
						Accordion Item #3</button>
				</h2>
				<div id="collapseFour" class="accordion-collapse collapse"
					aria-labelledby="headingFour" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<strong>This is the third item's accordion body.</strong> It is
						hidden by default, until the collapse plugin adds the appropriate
						classes that we use to style each element. These classes control

					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingFive">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseFive"
						aria-expanded="false" aria-controls="collapseFive">
						Accordion Item #3</button>
				</h2>
				<div id="collapseFive" class="accordion-collapse collapse"
					aria-labelledby="headingFive" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<strong>This is the third item's accordion body.</strong> It is
						hidden by default, until the collapse plugin adds the appropriate
						classes that we use to style each element. These classes control

					</div>
				</div>
			</div>
		</div>

	<div class="qnsBtnDiv">
	
		<button class="qnaInsertBtn" onclick="qnaInsertFunc()">내 글 보기</button>
	
	<button class="qnaInsertBtn" onclick="qnaInsertFunc()">글 작성하기</button>
	
	</div>
	


	
		<table class="qnaListTable">
			<thead>
				<tr>
					<td>NO.</td>
					<td>작성자</td>
					<td>제목</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (Qna qOne : qList) {
				%>
				<tr onclick="selectQna(<%=qOne.getQnaNo()%>)">
					<td><%=qOne.getQnaNo()%></td>
					<td><%=qOne.getUserId()%></td>
					<td><%=qOne.getQnaTitle()%></a></td>
					<!--href="/qna/detail?qnaNo=<%=qOne.getQnaNo()%>"  -->
				</tr>
				<%
					}
				%>
			</tbody>
		</table>



	

	</main>

	<jsp:include page="../common/bottom_include.jsp" flush="false" />
</body>
<script type="text/javascript">
function selectQna(no){
	location.href="/qna/detail?qnaNo="+no;
}
function qnaInsertFunc(){
	location.href="/qna/insert"
}

</script>
</html>