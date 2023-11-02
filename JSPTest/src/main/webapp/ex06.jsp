<%@page import="com.test.jsp.MyMath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//무슨 변수 : 앞에 public 붙혀보기
	//1. 멤버 변수
	//2. 지역 변수
	int a=10; //지역 변수 > 어떤 메소드 영역
	
	//public void test() {} //오류 만들수없음
	
	
	
	//이거처럼 위에 import 하고 class를 새로 생성해서 MyMath에 있는 메소드를 사용한다
	MyMath m=new MyMath();
	

%>
<%!//지역변수로 쓸수있게 만든영역: 하지만 이렇게 잘 사용하지않음

	int b=20; //지역 변수(x), 클래스 멤버 변수(o)
	
	//이 메소드의 호출 영역 > 이 JPS페이지내에서만..
	public int sum(int a, int b) {
		return a+b;
	}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div><%= 10 + 20 %></div>
	<div><%= sum(10,20) %></div> 
	
	<!-- MyMath.java에서 불러온 m -->
	<div><%= m.sum(10,20) %></div> 



</body>
</html>




