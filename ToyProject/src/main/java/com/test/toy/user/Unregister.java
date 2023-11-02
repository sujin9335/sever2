package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/unregister.do")
public class Unregister extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/unregister.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//회원 탈퇴
		//- delete(x)
		//- update(o)
		
		//1.
		String id=req.getSession().getAttribute("id").toString();
		
		//2. 
		UserDAO dao=new UserDAO();
		
		int result=dao.unregister(id);
		
		//3. 
		if(result == 1) {
			resp.sendRedirect("/toy/index.do");
		}else {
			PrintWriter writer=resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
	
	
	}

}
