package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02_send extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer=resp.getWriter();
		
		//form 의 action 속성 받을 주소로 설정'/servlet/receive.do'
		writer.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1>데이터 전송</h1>\r\n"
				+ "	\r\n"
				+ "	<form method=\"POST\" action='/servlet/receive.do'>\r\n"
				+ "		<div>\r\n"
				+ "			이름: <input type=\"text\" name=\"name\">\r\n"
				+ "		</div>\r\n"
				+ "		<div>\r\n"
				+ "			나이: <input type=\"text\" name=\"age\">\r\n"
				+ "		</div>\r\n"
				+ "		<input type=\"submit\" value=\"보내기\">\r\n"
				+ "	</form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");

		writer.close(); //서블릿 > 임시페이지 생성 (꼭 닫아야 실행됨)
	
	}

}
