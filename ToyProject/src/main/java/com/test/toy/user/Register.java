package com.test.toy.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.toy.user.model.UserDTO;
import com.test.toy.user.repository.UserDAO;

@WebServlet("/user/register.do")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/register.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//RegisterOk.java 역할
		//1. 데이터 가져오기
		//2. DB 작업 > insert
		//3. 피드백
		
		//req.getParameter() 동작안함 : enctype="multipart/form-data 으로 함 
		
		try {
			
			MultipartRequest multi=new MultipartRequest(
										req,
										req.getRealPath("/asset/pic"),
										1024*1024*10, //10MByte
										"UTF-8",
										new DefaultFileRenamePolicy()
										);
			//System.out.println(req.getRealPath("/asset/pic"));//pic폴더에 저장되는지 확인 파일저장소 위치 조금다름
			
			String id=multi.getParameter("id");
			String pw=multi.getParameter("pw");
			String name=multi.getParameter("name");
			String email=multi.getParameter("email");
			String pic=multi.getFilesystemName("pic");//파일이라 다름
			String intro=multi.getParameter("intro");
			
			UserDTO dto=new UserDTO();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setEmail(email);
			
			if(pic != null && !pic.equals("") ) {
				dto.setPic(pic);
			}else {
				dto.setPic("pic.png");
			}
			
			dto.setIntro(intro);
			
			UserDAO dao=new UserDAO();
			
			int result=dao.register(dto);
			
			if(result == 1) {
				
				req.getSession().removeAttribute("id");
				req.getSession().removeAttribute("name");
				req.getSession().removeAttribute("lv");
				
				resp.sendRedirect("/toy/index.do");
			}else {
				PrintWriter writer=resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
				writer.close();
			}
			

		} catch (Exception e) {
			System.out.println("Register.doPost");
			e.printStackTrace();
		}
		
		//0 또는 에러
		
	}

}
