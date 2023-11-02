<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String a=request.getParameter("a");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>
	<h1>두번째 페이지</h1>
	
	<%-- <p>1. 지역변수 a: <%= a %></p> --%>
	
	<!-- 전송방법 submit 같은걸로는 됨 -->
	<p>1. 지역 변수 a: <%= a %></p>
	
	<!-- 안됨 -->
	<%-- <p>2. 멤버 변수 b: <%= b %></p> --%>
	
	<!-- 이동방식 1, 2 안됨 null표시 -->
	<p>3. pageContext c: <%= pageContext.getAttribute("c") %></p>

	<!-- 이동방식 1 안됨 null -->
	<!-- 이동방식 2 사용시 됨 -->
	<p>4. request d: <%= request.getAttribute("d") %></p>
	
	<!-- 이동방식 1, 2 다됨 -->
	<p>5. session e: <%= session.getAttribute("e") %></p>
	
	<!-- 이동방식 1, 2 다됨 -->
	<p>6. application f: <%= application.getAttribute("f") %></p>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>