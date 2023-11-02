package com.text.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.ajax.repository.AjaxDAO;

@WebServlet("/ex01data.do")
public class Ex01Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//메모가 몇개인지?
		AjaxDAO dao=new AjaxDAO();
		
		//dao 클래스에서 DB count 값 가져오기
		int count=dao.getMemoCount();
		
		req.setAttribute("count", count);
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex01data.jsp");
		dispatcher.forward(req, resp);

	}

}
