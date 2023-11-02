<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//POST > 한글 인코딩
	request.setCharacterEncoding("UTF-8");
	
	//텍스트 박스
	//1. 입력O > 입력값 반환
	//2. 컨트롤O + 입력X > 빈문자열 반환 ""
	//3. 컨트롤X (key 오류) > null 반환 : key는 HTML name 속성값 getParameter(값)
	String txt1=request.getParameter("txt1");
	
	// 2. 빈값 상황일경우 txt1값
	//System.out.println(txt1 == null); //false
	//System.out.println(txt1.equals("")); //true
	

	//암호박스
	String txt2=request.getParameter("txt2");
	
	
	//다중 텍스트
	String txt3=request.getParameter("txt3");
	//입력쪽의 엔터는 div태그 안에 쓰여서 한줄로 보이게되서 엔터표현 처리가 필요함 : replace
	
	if(txt3 == null) txt3=""; //링크 클릭시 에서 if처리해야 오류안남
	txt3=txt3.replace("\r\n", "<br>");
	
	
	
	//체크 박스 : value넣어서 처리하는게 좋다
	//1. value 없을 때 
	//	체크O > "on" 전송
	//	체크X > null 전송
	//2. value 있을 때
	//	체크O > value 전송
	//	체크X > null 전송
	String cb1=request.getParameter("cb1");
	
	//체크 박스들
	/* String cb2=request.getParameter("cb2");
	String cb3=request.getParameter("cb3");
	String cb4=request.getParameter("cb4");
	
	String temp="";
	temp += cb2+",";
	temp += cb3+",";
	temp += cb4+","; */
	
	//한번에 처리1 : 비추천 ex08 체크 박스2
	/* String temp="";
	for(int i=2; i<=4; i++) {
		temp+=request.getParameter("cb" + i)+",";
	} */
	
	//한번에 처리2 : ex08 체크 박스2-1
	//String cb5=request.getParameter("cb5"); //배열로 안받으면 맨처음 하나만 출력
	
	//동일한 name의 컨트롤이 여러개 전송될 때
	String[] cb5=request.getParameterValues("cb5");
	
	
	
	//라디오 버튼
	String rb=request.getParameter("rb");
	
	
	
	/* 10-18 -------------------- */
	
	
	//셀렉트 박스
	String sel1=request.getParameter("sel1");
	
	//셀렉트 박스 multiple
	String[] sel2=request.getParameterValues("sel1");
	
	
	//히든 태그
	String txt4=request.getParameter("txt4");
	//히든 태그-버튼 몇번클릭
	String count=request.getParameter("count");
	
	
	//날짜
	String regdate=request.getParameter("regdate");
	
	
	//범위
	String min=request.getParameter("min");

	
	//컬러
	String color=request.getParameter("color");
	
	
	
	//---------링크
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>
	
	<h1>결과</h1>
	
	<h2>텍스트 박스</h2>
	<div><%= txt1 %></div>

	<h2>암호 박스</h2>
	<div><%= txt2 %></div>

	<h2>다중 텍스트</h2>
	<div><%= txt3 %></div>

	<h2>체크 박스1</h2>
	<div><%= cb1 %></div>

	<%-- 
	<h2>체크 박스2</h2>
	<div><%= temp %></div> 
	--%>
	
	<h2>체크 박스2-1</h2>
	<div><%= Arrays.toString(cb5) %></div>
	
	<h2>라디오 버튼</h2>
	<div><%= rb %></div>
	
	<h2>셀렉트 박스</h2>
	<div><%= sel1 %></div>
	
	<h2>셀렉트 박스-multiple</h2>
	<div><%= Arrays.toString(sel2) %></div>
	
	<h2>히든 태그</h2>
	<div><%= txt4 %></div>
	
	<h2>히든 태그-몇번클릭</h2>
	<div><%= count %></div>
	
	<h2>날짜</h2>
	<div><%= regdate %></div>

	<h2>범위</h2>
	<div><%= min %></div>

	<h2>컬러</h2>
	<div style="background-color: <%= color %>;"><%= color %></div>

	
	<h2>링크</h2>
	<div><%= id %>, <%= pw %></div>


	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>