<%@page import="pufit.alarm.model.vo.Alarm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알람목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>보낸이</th>
			<th>내용</th>
		</tr>
		<c:forEach items = "${requestScope.aList}" var="aOne" varStatus="index">
		<tr>
			<td>${aOne.sendUser}</td>
			<td>${aOne.alarmContents}</td>
			<td><a href="/alarm/deleteAlarm?alarmNo=${aOne.alarmNo}"><button>삭제</button></a></td>
		</tr>		
		</c:forEach>
		<tr>
		<td colspan="4" align="center">
			${requestScope.alarmPageNavi}
		</td>
		</tr>
	</table>
</body>
</html>