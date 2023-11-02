package com.text.ajax.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.text.ajax.repository.AjaxDAO;

@WebServlet("/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//1. 데이터 가져오기 (seq)
		//2. DB 작업 > delete
		//3. 피드백 > JSON
		
		//1.
		String seq=req.getParameter("seq");
		
		//2.
		AjaxDAO dao=new AjaxDAO();
		
		int result=dao.delAdderss(seq);
		
		//3.
		JSONObject obj = new JSONObject();
		obj.put("result", result);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		PrintWriter writer = resp.getWriter();
		writer.print(obj.toString());
		writer.close();
		
		
	}

}
