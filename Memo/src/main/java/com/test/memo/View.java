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

@WebServlet("/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. 데이터 가져오기(seq)
		//2. DB작업 > select > DAO 위임
		//3. 결과값 반환 > JSP 호출하기(+전달)
		
		
		//1.
		String seq=req.getParameter("seq");
		
		//2.
		MemoDAO dao=new MemoDAO();
		
		//DAO에서 get메소드로 해당 seq 보내서 아이디, 메모, 날짜등 내용 가져오기
		MemoDTO dto=dao.get(seq);
		
		//개행 출력될때 처리하기
		dto.setName(dto.getMemo().replace("\r\n", "<br>"));
		
		
		//3.
		req.setAttribute("dto", dto);
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/view.jsp");
		dispatcher.forward(req, resp);

	}

}