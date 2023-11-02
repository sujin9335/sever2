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
	
	
	
	<script>
	
		/* 이런식으로 쓰는것보다 아래 JSTL 쓰는게 나음 */
		<%--
		<% if((int)request.getAttribute("result") == 1) { %>
		location.href = '/memo/list.do';
		<% } else {%>
		location.href = '/memo/add.do';
		<% } %>		
		--%>
		
		/* JSTL 방법 */
		<c:if test="${result == 1}">
			/* 삭제완료 됐을때는 모든 목록으로 가서 없어진거 보여주기 */
			location.href = '/memo/list.do';
		</c:if>
		<c:if test="${result == 0}">
			alert('실패');
			//location.href = '/memo/add.do'; > 페이지 새로 요청
			history.back(); //페이지 새로요청(x) > 이전 상태로 되돌리기
		</c:if>
		<c:if test="${result == 2}">
			alert('암호 틀림');
			//location.href = '/memo/add.do'; > 페이지 새로 요청
			history.back(); //페이지 새로요청(x) > 이전 상태로 되돌리기
		</c:if>
		
	</script>
	
</body>
</html>