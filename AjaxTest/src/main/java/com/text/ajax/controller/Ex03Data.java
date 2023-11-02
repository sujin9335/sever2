package com.text.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.ajax.repository.AjaxDAO;

@WebServlet("/ex03data.do")
public class Ex03Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String name=req.getParameter("name");
		
		
		AjaxDAO dao=new AjaxDAO();
		
		int count=dao.getMemoCount(name);
		
		
		
		try {
			
			//메모 갯수 > 시간 걸림.. (일부러 걸기)
			Thread.sleep(10000);

		} catch (Exception e) {
			System.out.println("Ex03Data.doGet");
			e.printStackTrace();
		}
		
		
		
		
		//Ajax용은 JSP안만들고 이런식으로 데이터만 보내는 PrintWriter를 써서 보낸다
		PrintWriter writer=resp.getWriter();
		writer.print(count);
		writer.close();
		
		
		//JSP는 필요없음
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex03data.jsp");
//		dispatcher.forward(req, resp);

	}

}
