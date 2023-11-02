<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>

	<!-- 
		
		사용자가 클라이언트 작업 중에..
		서버와 통신을 해야 한다면..(서버에게 데이터를 전송 or 서버로부터 데이터 수신)
		기본의 페이지 > 새로고침 발생!!
	
	
		기존페이지 작업 유지 기술
		1. 프레임 //오래되서 쓰지않음 
		2. Ajax
	
	-->

	<div>
		<!-- 처음에는 count 값이 없어서 출력되지 않는다 -->
		<input type="text" id="txt1" value="${count }">
		<input type="button" value="버튼1" id="btn1">
	</div>

	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
		$('#btn1').click(function() {
			location.href='/ajax/ex01data.do';
		});
	
	
	</script>
	
</body>
</html>