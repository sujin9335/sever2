<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#info img{
		border: 1px solid #AAA;
		padding: 3px;
		width: 150px;
		height: 180px;
		object-fit: cover;
	}
	#info tr:first-child td:first-child {
		width: 170px;
		text-align: center;
		
		/* 테이블에만 줄수있는 속성 */
		vertical-align: middle;
	}
	#info tr:nth-child(2) td:nth-child(4) {
		width: 90px;
	}
	#info tr:nth-child(3) td:nth-child(5) {
		width: 193px;
	}
	#info tr:last-child td {
		padding-top: 20px;
		padding-bottom: 20px;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>

	<main id="main">
		<h1>회원 <small>정보 보기</small></h1>
		
		<table id="info">
			<tr>
				<td rowspan="3"><img src="/toy/asset/pic/${dto.pic }"></td>
				<th>이름</th>
				<!-- name과 lv은 session에 있음 -->
				<td>${name }</td>
				<th>아이디</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${lv == 1 ? '일반회원' : '관리자'}</td>
				<th>이메일</th>
				<td>${dto.email }</td>
			</tr>
			<tr>
				<td colspan="4">${dto.intro }</td>
			</tr>
		</table>
		
		
	</main>

	
	<script>
		
	</script>
	
</body>
</html>