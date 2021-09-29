<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${requestScope.errorMsg} :(</h1>
</body>
<script type="text/javascript">
setTimeout(() => {
	window.history.back();
}, 3000);
</script>
</html>