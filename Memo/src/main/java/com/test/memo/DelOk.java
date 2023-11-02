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

@WebServlet("/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seq, pw)
		//2. 암호 확인 > 권한?
		//3. DB작업 > delete > DAO 위임
		//4. 피드백 > JSP 호출하기
		
		//1.
		String seq=req.getParameter("seq");
		String pw=req.getParameter("pw");
		
		
		//2.
		MemoDAO dao=new MemoDAO();
		MemoDTO dto=new MemoDTO();
		dto.setSeq(seq);
		dto.setPw(pw);
		
		int result=0;
		
		//아까만든 check 에서 비번 맞는지 확인하기
		if(dao.check(dto)) {
			//비번이 맞을경우 del(seq)메소드로 삭제
			result=dao.del(seq);
		}else {
			result=2;
		}
	
		
		//3.
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/delok.jsp");
		dispatcher.forward(req, resp);

	}

}
