<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>

</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<!-- /memo 는 꼭 써야 servlet이 불러지며, 처음 프로젝트 만들때 지정해준거임 -->
	<form method="POST" action="/memo/editok.do"> 
	<table>
		<tr>
			<th>이름</th>
			<!-- jstl로 값 불러오기 dto에 name,  memo값 -->
			<td><input type="text" name="name" required value=${dto.name }></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="pw" required></td>
		</tr>
		<tr>
			<th>메모</th>
			<td><textarea name="memo" required class="full" >${dto.memo }</textarea></td>
		</tr>
	</table>
	<div>
		<input type="button" value="돌아가기" onclick="location.href='/memo/list.do';">
		<input type="submit" value="수정하기" >
	</div>
	<!-- 수정할 seq가 몇번인지 보내기 위한 히든태그 -->
	<input type="hidden" name="seq" value="${dto.seq }">
	</form>
	
	
	<script>
		
	</script>
	
</body>
</html>