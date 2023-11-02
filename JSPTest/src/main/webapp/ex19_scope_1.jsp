<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//첫번쨰 페이지(데이터 전송) > (전달) > 두번째 페이지(데이터 사용)
	
	
	//1. 지역 변수
	int a=10;
	
	//자바 이동방법 : ?a=" + a 붙이기
	//response.sendRedirect("ex19_scope_2.jsp?a=" + a);
	//pageContext.forward("ex19_scope_2.jsp?a=" + a);
	
	
	//3. pageContext 객체
	pageContext.setAttribute("c", 30);
	
	//4. request d
	request.setAttribute("d", 40);
	
	//5. session 객체 : 이동방식 1, 2 ok
	session.setAttribute("e", 50);
	
	//6. application 객체 : 이동방식 1, 2 ok
	application.setAttribute("f", 60);
	
	
	
	
	//페이지 이동 
	//방식 1
	//response.sendRedirect("ex19_scope_2.jsp");
	//방식 2 : 이동방식을 pageContext.forward() 로바꾸니 request에서 (4.)data값이 받아짐
	//pageContext.forward("ex19_scope_2.jsp");
	
	
	//결론: request + forward 방식을 사용하기위해 구조 파악

%>
<%!
	
	//2. 멤버 변수 > 실패
	//얘도 전송은 할수있으나 다른페이지에서 쓸수있는 전역변수는 아님
	int b=20;

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>
	<h1>첫번째 페이지</h1>
	<!-- a태그 이동방법 : ?a=<%= a %> 붙이기 -->
	<a href="ex19_scope_2.jsp?a=<%= a %>">두번째 페이지</a>
	
	<hr>
	
	<!-- JS 이동방법 -->
	<input type="button" value="두번째 페이지" id="btn1">
	
	<hr>
	
	<!-- form태그 이동방법: value에 담아서 다른페이지로 이동가능함 -->
	<form method="GET" action="ex19_scope_2.jsp">
		<input type="hidden" name="a" value="<%= a %>">
		<input type="submit" value="두번째 페이지">
	</form>


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		//JS 이동방법 : 뒤에 ?a= a값 
		$('#btn1').click(function() {
			location.href='ex19_scope_2.jsp?a=<%= a %>';
		});
		
	
	</script>
	
</body>
</html>