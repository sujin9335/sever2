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

@WebServlet("/editok.do")
public class EditOk extends HttpServlet {

	@Override //Post 방식으로 보냈으니 doPost로 수정(인코딩도 해야됨)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(수정 데이터)
		//2. DB 작업 > updat > DAO 위임
		//3. 결과 > 피드백 > jsp 호출하기
		
		//POST 방식으로 한글보냈기 때문에 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		//1.
		String name=req.getParameter("name");
		String memo=req.getParameter("memo");
		String seq=req.getParameter("seq");
		String pw=req.getParameter("pw"); //권한 확인용
	
		//2.
		MemoDAO dao=new MemoDAO();
		
		MemoDTO dto=new MemoDTO();
		dto.setName(name);
		dto.setMemo(memo);
		dto.setSeq(seq);
		dto.setPw(pw);

		//비밀번호 맞는지 확인 메소드 check(dto) 
		boolean flag=dao.check(dto);
		
		
		
		//수정내용 보내서 수정하기
		int result=dao.edit(dto); //성공 1, 실패 0, 암호틀림 ?
		
		if(flag) { //비번체크 하고 틀릴시 2번으로 출력
			result=dao.edit(dto);
		}else {
			result=2;
		}
		
		
		
		//3.
		req.setAttribute("result", result);
		req.setAttribute("seq", seq);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/editok.jsp");
		dispatcher.forward(req, resp);

	}

}
