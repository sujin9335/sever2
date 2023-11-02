package com.text.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.ajax.model.CatDTO;
import com.text.ajax.repository.AjaxDAO;

@WebServlet("/ex07.do")
public class Ex07 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AjaxDAO dao=new AjaxDAO();
		
		ArrayList<CatDTO> list=dao.listCat();
		
		req.setAttribute("list", list);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex07.jsp");
		dispatcher.forward(req, resp);

	}

}
