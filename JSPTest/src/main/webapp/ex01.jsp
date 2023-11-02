<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% //자바영역
	
		Calendar now=Calendar.getInstance();
	
	%>
	
	<p>현재시간: <%= String.format("%tT, now") %></p>
	
	<!-- 여러 파일에 적용할때 이런식으로 객체 관리를 하면 됨 -->
	<%@ include file="inc/copyright.jsp" %>
</body>
</html>