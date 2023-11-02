<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//원하는 키=a, 벨류=10 저장 가능
	//세션 변수 > 사이트 전역 변수(페이지간에 주고 받을 필요가 없다) 
	//	: 다른 사이트에서도 불러올수있음(ex13에도 이어서 방문카운트가 됨)
	session.setAttribute("a", 10); //세션 객체에 a 변수 저장

	//어플리케이션 변수 : 공용 변수
	application.setAttribute("b", 20); //어플리케이션 객체에 b 변수 저장

	
	
	//방문카운트 session : 
	if(session.getAttribute("count") == null) {
		session.setAttribute("count", 1);
	}else {
		//count = count+1
		session.setAttribute("count", (int)session.getAttribute("count") + 1);
	}
	
	
	//방문카운트 application : 
	if(application.getAttribute("count") == null) {
		application.setAttribute("count", 1);
	}else {
		//count = count+1
		application.setAttribute("count", (int)application.getAttribute("count") + 1);
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>

	<h1>session</h1>
	<div>a: <%= session.getAttribute("a") %></div>
	
	
	
	<h1>application</h1>
	<div>b: <%= application.getAttribute("b") %></div>
	
	
	<h1>방문 카운트</h1>
	<div>count: <%= session.getAttribute("count") %></div>
	
	<h1>방문 카운트</h1>
	<div>count: <%= application.getAttribute("count") %></div>


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>