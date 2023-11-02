<%@page import="java.util.Calendar"%>
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

	<h1>세션, Session</h1>
	
	<div class="list">
		<div><a href="ex15_set.jsp">세션값 저장하기</a></div>
		<div><a href="ex15_del.jsp">세션값 삭제하기</a></div>
		<div><a href="ex15_reset.jsp">세션 초기화</a></div>
		<div><a href="ex15_interval.jsp">세션 만료 시간 설정하기</a></div>
	</div>
	<hr>
	
	<h2>(현재)세션 정보</h2>
	
	<div>
		<!-- 현재 세션 ID : 가끔 비교 확인차 씀 -->
		Session ID: <%= session.getId() %>
	</div>
	<div>
		<!-- 새션 만들어진 시간 : 보기편하게 calendar 처리-->
		Session Create Time:
		<%
			Calendar time=Calendar.getInstance();
			time.setTimeInMillis(session.getCreationTime());
			out.println(String.format("%tF %tT", time, time));
		%>
		<%=
			session.getCreationTime()
			
		%>
	</div>
	<div>
		<!-- 세션 유지시간 기본 30분 : 30분동안 동작 없으면 초기화 됨 -->
		Session Max Inactive Interval:
		<%= session.getMaxInactiveInterval() %>
	</div>
	<div>
		<!-- 처음 방문이면 truen / 두번쨰이상이면 false -->
		Session isNew: 
		<%= session.isNew() %>
	</div>
	<div>
		<!-- 현재 세션에 data가 있는지 출력 -->
		Session Data:
		
		<%
		
			if (session.getAttribute("data") != null) {
				out.println(session.getAttribute("data"));  
			}else {
				out.println("데이터없음");
			}
		
		%>
		
		<%-- <%= session.getAttribute("data") %> --%>
	</div>



	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>