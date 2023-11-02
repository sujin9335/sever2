<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.todo.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//editok.jsp
	
	//1. 데이터 가져오기(seq)
	//2. DB 작업 > update
	//3. 피드백
	
	
	//1.
	String seq=request.getParameter("seq");
	
	
	//2.
	Connection conn=null;
	PreparedStatement stat=null;
	

	try {
		
		conn=DBUtil.open();
		
		String sql="";
		sql="select state from tblTodo where seq = ?";
		
		stat=conn.prepareStatement(sql);
		stat.setString(1, seq);
		
		ResultSet rs=stat.executeQuery();
		String state="";
		
		if(rs.next()){
			state=rs.getString("state");
		}
		
		
		if(state.equals("n")) {
			state="y";
		}else {
			state="n";
		}
		
		sql="update tblTodo set state = ? where seq = ?";
		
		stat=conn.prepareStatement(sql);
		stat.setString(1, state);
		stat.setString(2, seq);
		
		int result=stat.executeUpdate();
		
		
		
		
		
		if(result==1) {
			response.sendRedirect("list.jsp");
		}else {
			out.println("<script>"); //권장할만한 코드가 아님 : script 가 html 밖에 쓰여있지만 실행은 해줌
			out.println("alert('failed');");
			out.println("loaction.href = 'list.jsp';");
			out.println("</script>");
		} 
		
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

	<%@ include file="inc/header.jsp" %>
	
	목록보기 or 글쓰기

	
	<script>
		
	</script>
	
</body>
</html>