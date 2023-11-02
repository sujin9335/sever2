<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	//인증받지 못한 사용자가 직접 접근하면 내쫓기 : 주소를 외워서 입력하면 로그인 안해도 들어와짐
	if(session.getAttribute("auth") == null) {
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>");
		out.println("alert('회원만 접근 가능합니다.');");
		out.println("location.href='../index.jsp';");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>"); 
		//알람이 뜨지만 소스보기로 아래에 html 회원페이지가 보인다
		//여기까지만 보이고 밑이 안보인다
		out.close();
		
		
		
		
		
		//response.sendRedirect("../index.jsp"); //쫒아내면되나 불친절해서 잘사용 x
		
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

	<h1>회원 전용 페이지</h1>

	<p>이 페이지는 회원만 접근이 가능합니다.</p>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>