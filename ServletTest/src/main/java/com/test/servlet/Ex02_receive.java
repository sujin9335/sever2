package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02_receive extends HttpServlet{
	
	//서블릿 요청 메소드
	//1. Get 방식 요청 > doGet() 호출
	//2. Post 방식 요청 > doPost() 호출
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신 (name 속성이 서버랑 연결하면 중요해짐)
		//- <input type="text" name="name">		-> name=홍길동
		//- <input type="text" name="age">		-> age=20
	
		//HttpSevletRequest req
		//- 데이터를 수신하는 담당자 역할 (무조건 문자열(String))
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		
		System.out.println(name);
		System.out.println(age);
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer=resp.getWriter();
		
		writer.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>데이터 수신</h1>\r\n"
				+ "	\r\n"
				+ "	<p>데이터 처리가 완료 되었습니다</p>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		writer.close();;
		
		
		
	}

	
}
