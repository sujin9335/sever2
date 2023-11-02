 <%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	//<form enctype="multipart/form-data">을 적용하면, 인코딩 방식이 변경
	//1. request.getParameter() 동작 불능
	//2. request.getParameterValues() 동작 불능
	//cos.jar > MultipartRequest 클래스 > 객체가 request의 수신 기능 대신
	
	//String name=request.getParameter("name");
	//String age=request.getParameter("age");
	
	
	//업로드된 파일을 어디에 저장할 경로 > 로컬 경로(C:\..) : files폴더로 보내야됨
	//1. 이경로를 생각했지만 : 개발자가 관리하는 영역
	//C:\class\code\server\JSPTest\src\main\webapp\files
	//2. application.getRealPath("/files") 하면 다른경로가 나옴 : 실제 관리하는 실행영역
	//C:\class\code\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\files

	//절대 경로(상대 경로) > 로컬 경로 변환
	String path=application.getRealPath("/files");
	
	//System.out.println(path);
	
	//업로드 파일의 최대 크기 지정
	//- 바이트 단위
	int size=1024*1024*100; //100MB
	
	//변수 선언
	String name="";//이름
	String age="";//나이
	String filename="";//첨부파일명
	String orgfilename="";//첨부파일명
	
	//request(가 안되서) > MultipartRequest(이거로 대신 실행) > 객체 생성
	try{//예외처리
		
		//MultipartRequest 객체를 만드는 순간 > 이미 첨부파일은 files 복사가 완료된다
		MultipartRequest multi=new MultipartRequest(
								request,	//원래 request
								path,		//파일 업로드 위치
								size,		//최대 크기
								"UTF-8",	//인코딩
								new DefaultFileRenamePolicy()
									//파일명 관리(중복>넘버링) : 중복등록시 첨부파일명 뒤에 숫자붙이는 관리객체
								);
		
		//데이터 수신 
		//name=request.getParameter("name");
		name=multi.getParameter("name");
		age=multi.getParameter("age");
		
		//업로드 파일 정보 > 파일명
		//-<input type="file" name="attach"> //입력쪽 태그 name확인
		filename=multi.getFilesystemName("attach");//첨부 파일명 : 실제 파일명 (중복시 뒤에 숫자붙은 파일명)
		orgfilename=multi.getOriginalFileName("attach");//첨부 파일명 : 첨부시 중복된 파일의 오리지날파일명
		
		
	}catch (Exception e){
		e.printStackTrace();
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
	<h1>결과</h1>
	
	<div>
		이름: <%= name %>
	</div>
	<div>
		나이: <%= age %>
	</div>
	<div>
		파일명: <%= filename %>
	</div>
	<div>
		org파일명: <%= orgfilename %>
	</div>
	
	<h2>파일 다운로드</h2>
	
	<div>
		<!-- 링크는 파일 종류에 따라 다운이 아닌 웹에 켜질때있음(그림파일.jpg..) -->
		<!--  
			장점: 간단함
			단점: 파일 확장자에 다르다.(다운로드 or 뷰어)
		-->
		<a href="/jsp/files/<%= filename %>"><%= orgfilename %></a>
	</div>
	<div>
		<!-- 
			download 속성추가 
			장점: 간단함. 모든 파일을 무조건 다운로드 시키는 옵션
			단점: 파일명이 다를 수 있따.(넘버링이 된 파일로 다운로드)
		-->
		<a href="/jsp/files/<%= filename %>" download><%= orgfilename %></a>
	</div>
	
	<div><!-- 프로젝트떄는 이걸사용  -->
		<!-- download.jsp 파일에서 불러오기 (파일의 타입을 속이는 방식?임)-->
		<!--  
			장점: 무조건 다운로드 처리 , 원본 파일명으로 다운로드
			단점: 비용(download.jsp 만들어야됨)발생
		-->
		<a href="download.jsp?filename=<%= filename %>&orgfilename=<%= orgfilename %>"><%= orgfilename %></a>
	</div>
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
	</script>
	
</body>
</html>