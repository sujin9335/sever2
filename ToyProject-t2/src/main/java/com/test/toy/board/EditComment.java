package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.test.toy.board.repository.BoardDAO;
import com.test.toy.user.model.CommentDTO;

@WebServlet("/board/editcomment.do")
public class EditComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String content=req.getParameter("content");
		String seq=req.getParameter("seq");
		
		BoardDAO dao=new BoardDAO();
		
		CommentDTO dto=new CommentDTO();
		dto.setContent(content);
		dto.setSeq(seq);
		
		int result=dao.editComment(dto);
		
		resp.setContentType("application/json");
		
		JSONObject obj=new JSONObject();
		obj.put("result", result);
		
		PrintWriter writer=resp.getWriter();
		writer.write(obj.toString());
		writer.close();
		
		
	}

}