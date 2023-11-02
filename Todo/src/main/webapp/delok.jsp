<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.test.todo.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//delok.jsp
	
	//1. 데이터 가져오기(seq)
	//2. DB 작업 > delete
	//3. 피드백
	
	//1. 
	String seq=request.getParameter("seq");
	
	//2. 
	Connection conn=null;
	PreparedStatement stat=null;
	
	try {
		
		conn=DBUtil.open();
		
		String sql="delete from tblTodo where seq = ?";
		
		stat=conn.prepareStatement(sql);
		stat.setString(1, seq);
		
		int result=stat.executeUpdate();
		
		if(result == 1) {
			response.sendRedirect("list.jsp");
		}else {
			out.println("<script>"); //권장할만한 코드가 아님 : script 가 html 밖에 쓰여있지만 실행은 해줌
			out.println("alert('실패');");
			out.println("loaction.href = 'list.jsp';");
			out.println("</script>");
		}
				
		
		
		
		
	}catch (Exception e) {
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

	<%@ include file="inc/header.jsp" %>
	
	목록보기 or 글쓰기

	
	<script>
		
	</script>
	
</body>
</html>