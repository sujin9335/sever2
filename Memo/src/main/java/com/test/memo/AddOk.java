package com.test.memo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.dto.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//AddOk.java
		//1. 데이터 가져오기(name, pw, memo)
		//2. DB작업 > insert
		//3. 피드백(X) > JSP 호출하기
		
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String name=req.getParameter("name");
		String pw=req.getParameter("pw");
		String memo=req.getParameter("memo");
		
		
		//2. DB
		//계층(AddOk) > 데이터(포장 - HashMap or 객체) > 계층(MemoDAO)
		MemoDAO dao=new MemoDAO();
		
		MemoDTO dto=new MemoDTO();
		dto.setName(name);
		dto.setPw(pw);
		dto.setMemo(memo);
		
		//dao.add(name, pw, memo); //이런식으로 안보내고 DTO를 만들고 담아서 보냄
		int result=dao.add(dto); //넘기는 데이터 2개 이상 > DTO 담아서 보냄
		
		
		//3.
		req.setAttribute("result", result);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addok.jsp");
		dispatcher.forward(req, resp);

	}

}
