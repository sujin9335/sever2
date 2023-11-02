package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

public class Hello extends HttpServlet{ //1 상속
	
	//2 doGet만글기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//서블릿 호출
		//업무 처리
		
		//HTML 페이지 생산 > 불편;; > JSP 위임
//		resp.sendRedirect("/mvc/hello.jsp");
		
		//DB작업 > select count(*) : DB작업을해서 count 데이터를 가져왔다고 치고
		int count=100;
		
		//서블릿 > 자신의 업무 완료 > 산출물 일부 > 출력 > JSP 페이지 전달
		req.setAttribute("count", count); //리퀘스트에 저장
		
		//resp.sendRedirect("/mvc/hello.jsp"); //얘는 데이터(count) 전달이 불가능함
		//PageContext.forward() //얘는 데이터 전달 가능
		
		
		//JSP 위치로 데이터 보내주기
		RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/views/helo.jsp");
		
		dispatcher.forward(req, resp);//pageContext.forward()
				
		
		
		
	
	}
	

	
}
