<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#list{
		display: grid;
		grid-template-columns: repeat(3, 1fr);
		gap: 10px
	}
	#list .item {
		border: 1px solid #CCC;
		cursor: pointer;
	}
	#list .item div {
		padding: 5px;
	}
	#list .item div:nth-child(2) {
		height: 30px;
	}
	#list .item div:nth-child(odd) {
		background-color: #EEE;
	}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	
	
	<div id="list">
		<c:forEach items='${list}' var="dto">
		
		<!-- 호출 할때는 dto.get메소드의 뒷이름  -->
		<!-- 클릭했을때 해당 seq번호를 담아서 view 쪽으로 보내기 -->
		<div class="item" onclick="location.href='/memo/view.do?seq=${dto.seq}';"> 
			<div>${dto.seq}. ${dto.name}</div>
			<!-- 
				memo 다 보이지 않고 내용 잘라서 보이게하기
				subString(0, 10) 이런식으로 써도 되지만 출력페이지라 여기서 자르기 비추
			-->
			<div>${dto.memo}</div>
			<div>${dto.regdate }</div>
		</div>
		</c:forEach>
	</div>
	
	<div>
		<input type="button" value="쓰기" onclick="location.href='/memo/add.do';">
	</div>
	
	<hr>
	<!-- 크롤링 -->
	<div id="result"></div>
	<div><input type="button" value="클릭" id="btn1">	</div>
	
	

	
	
	<script>
		
		//크롤링
		$('#btn1').click(function () {
	        $('#result').text('홍길동');
	    });

		
	
	
	</script>
	
</body>
</html>