<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>

</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<table>
		<tr>
			<th>번호</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>메모</th>
			<td>${dto.memo }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate }</td>
		</tr>
	</table>
	<div>
		<input type="button" value="돌아가기" 
			onclick="location.href='/memo/list.do';">
			
		<!-- 수정하기 삭제하기는 해당 seq번호를 알아야 검색해서 변경할수 있다 -->
		<input type="button" value="수정하기" 
			onclick="location.href='/memo/edit.do?seq=${dto.seq}';">
		<input type="button" value="삭제하기" 
			onclick="location.href='/memo/del.do?seq=${dto.seq}';">
	</div>
	
	<script>
		
	</script>
	
</body>
</html>


