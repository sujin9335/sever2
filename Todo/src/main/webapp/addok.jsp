<%@page import="com.test.todo.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//addok.jsp
	
	//1. 데이터 가져오기
	//2. DB 연결 > insert 작업
	//3. 피드백 > list.jsp 이동
	
	//1.
	request.setCharacterEncoding("UTF-8");
	
	String todo=request.getParameter("todo");
	
	
	//2.
	Connection conn=null;
	PreparedStatement stat=null;
	int result=0;
	
	try{
		
		conn=DBUtil.open();
		
		String sql="insert into tblTodo (seq, todo, state, regdate) values (seqTodo.nextVal, ?, default, default)";
		
		stat=conn.prepareStatement(sql);
		stat.setString(1, todo);
				
		result=stat.executeUpdate();
		
		stat.close();
		conn.close();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- asset.jsp 기본 구조 가져오기 -->
<%@ include file="inc/asset.jsp" %> 

</head>
<body class="narrow">
	<!-- temp -->


	<%@ include file="inc/header.jsp" %>
	
	<div>
		<%= result %><!-- 결과 확인 -->
	</div>
	
	<% if(result == 1) {%>
	<div class="message">
		할일을 등록했습니다
	</div>
	<div><a href="list.jsp">목록보기</a></div>
	<% } else { %>
	<div class="message">
		할일 등록을 실패했습니다
	<div><a href="add.jsp">돌아가기</a></div>
	</div>
	<% } %>
	
	<script>
		
		<% if(result == 1) {%>
		//alert('할일 등록 성공'); //등록성공하면 바로넘어가고 목록보이는 창으로 가기 실패시에만 보임
		location.href = 'list.jsp';
		<% } else { %>
		alert('할일 등록 실패');
		location.href = 'add.jsp';
		<% } %>
	</script>
	
</body>
</html>