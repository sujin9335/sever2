<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>

	<h1>JSTL</h1>
	
	<h2>변수 선언</h2>
	<%
	
		int a=10;//지역 변수
		pageContext.setAttribute("b", 20); //내장 객체 변수
	
	%>
	<!-- 구지 따지면 .xml 형식임 -->
	<!-- 단독태그시 /c:set 을하거나 끝에 / 붙이기 -->
	<!-- jstl은 내장객체처럼 사용 -->
	<c:set var="c" value="30" /> <!-- JSTL 변수 == pageContext 변수 -->
	
	<div>a: <%= a %></div>
	<div>a: ${a}</div>
	
	<div>b: <%= pageContext.getAttribute("b") %></div>
	<div>b: ${b}</div>
	
	<%-- <div>c: <%= c %></div> --%>
	<div>c: ${c}</div>
	<div>c: ${pageContext.getAttribute("c")}</div>
	
	<h2>변수 수정하기(값 바꾸기)</h2>
	
	<!-- 해쉬 맵처럼 value값을 새로지정하면 업데이트임 -->
	<c:set var="c" value="300" /> 
	<div>c: ${c}</div>
	
	<h2>변수 삭제하기(Map의 요소 삭제)</h2>
	<c:remove var="c" />
	<div>c: ${c}</div>
	<div>c: ${empty c}</div>
	
	<h2>조건문</h2>
	
	<c:set var="num" value="10" />
	<div>num: ${num}</div>
	
	<!-- jstl if / else절은 없다-->
	<c:if test="${num > 0}">
		<div>${num}은 양수입니다</div>
	</c:if>
	<c:if test="${num <= 0}">
		<div>${num}은 양수가 아닙니다</div>
	</c:if>
	
	<!-- 다중 조건문 -->
	<c:choose>
		<c:when test="${num > 0}">양수</c:when>
		<c:when test="${num < 0}">음수</c:when>
		<c:otherwise>영</c:otherwise>
	</c:choose>
	
	
	<h2>반복문(일반 for + 향상된 for )</h2>
	
	<% for(int i=0; i<10; i++) { %>
		<div>숫자: <%= i %></div>
	<% } %>
	
	<c:forEach var="i" begin="0" end="9" step="3">
		<div>숫자: ${i}</div>
	</c:forEach>

	<!-- 역순은 안된다 : step이 1이상의 정수만 사용가능 -->
	<%-- <c:forEach var="i" begin="10" end="0" step="-1">
		<div>숫자: ${i}</div>
	</c:forEach> --%>
	
	<hr>
	
	<%
		String[] names = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
		pageContext.setAttribute("names", names);
	%>

	<table>
		
		<!-- index 만드는 다른 방식 -->
		<c:set var="n" value="1" />
		
		<tr>
			<th>이름</th>
			<th>index</th> 
			<th>n</th>
			<th>count</th> 
			<th>current</th>
			<th>first</th> 
			<th>last</th> 
		</tr>
		<!-- for(String name : names) -->
		<!-- varStatus로 index 번호를 추출할수있다 -->
		<c:forEach var="name" items="${names}" varStatus="status">
		<tr>
			<td>${name}</td>
			<td>${status.index}</td> <!-- 0부터시작 -->
			<td>${n}</td>
			<td>${status.count}</td> <!-- 1부터시작 -->
			<td>${status.current}</td> <!-- 값 -->
			<td>${status.first}</td> <!-- 첫번째이면 true : 첫번째 값인지 확인 boolean 반환 -->
			<td>${status.last}</td> 
		</tr>
		<c:set var="n" value="${n+1}"/> <!-- n=n+1 -->
		</c:forEach>
	</table>



	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>