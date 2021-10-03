<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 insert</title>
</head>
<body>
	<h1>상품 Insert</h1>
	<form action="/product/insert" method="post" enctype="multipart/form-data">
	
		상품 이미지 : <input type = "file" name="productImg"><br>
			 
		상품 코드 : <input type="text" name="productCode"><br>
		이름 : <input type="text" name="productName"><br>
		설명(내용) : <input type="text" name="productContents"><br>
		사이즈 : <input type="text" name="productSize"><br>
		가격 : <input type="text" name="productPrice"><br>
		상위 종류 : <input type="text" name="highKind"><br>
		하위 종류 : <input type="text" name="rowKind"><br>
		
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>