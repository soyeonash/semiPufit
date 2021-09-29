<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 작성</title>
</head>
<body>
	<h1>QNA 작성</h1>
	<form action="/qna/insert" method="post" enctype="multipart/form-data">
		<select class="category" name="qna-category">
			<option value="교환/환불문의" selected>교환/환불문의</option>
			<option value="결제문의">결제문의</option>
			<option value="배송문의">배송문의</option>
			<option value="기타">기타</option>
		</select>
			
		<input type="text" size="70" placeholder="제목" name="qna-title">
		<input type="text" size="70" placeholder="비밀번호" name="qna-pwd">
		<textarea rows="30" cols="70" placeholder="" name="qna-comments"></textarea><br>
		파일 지정하기 : <input type="file" name="upFile">
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>