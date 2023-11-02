package com.text.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.ajax.model.CatDTO;
import com.text.ajax.repository.AjaxDAO;

@WebServlet("/ex07data.do")
public class Ex07Data extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String x=req.getParameter("x");
		String y=req.getParameter("y");
		String catid=req.getParameter("catid");
		
		AjaxDAO dao=new AjaxDAO();
		
		CatDTO dto=new CatDTO();
		
		System.out.println(x + " " + y + catid);
		//dto에 x y id 저장
		dto.setX(x);
		dto.setY(y);
		dto.setCatid(catid);
		
		dao.updatePosition(dto);
		
		

	}

}
