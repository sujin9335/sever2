package com.text.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.ajax.model.MemoDTO;
import com.text.ajax.repository.AjaxDAO;

@WebServlet("/ex04data.do")
public class Ex04Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//ex04data.do?type=1
		
		String type=req.getParameter("type");
		
		if(type.equals("1")) {
			m1(req, resp);
		}else if(type.equals("2")) {
			m2(req, resp);
		}else if(type.equals("3")) {
			m3(req, resp);
		}else if(type.equals("4")) {
			m4(req, resp);
		}else if(type.equals("5")) {
			m5(req, resp);
		}else if(type.equals("6")) {
			m6(req, resp);
		}
		
		
		
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex04data.jsp");
//		dispatcher.forward(req, resp);

	}
	
	private void m6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		AjaxDAO dao=new AjaxDAO();
		ArrayList<MemoDTO> list=dao.listMemo();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); //MIME

		PrintWriter writer=resp.getWriter();
		
		/*
		 		
			배열로 만든다 : [] 만들고 중간에 ,으로 구분자 만듬
			{
				"seq": "5",
				"name": "홍길동",
				"pw": "1111",
				"memo": "메모입니다",
				"regdate": "2023-10-26 09:40:00"
				
			}
			,
			{
			"seq": "5",
			"name": "홍길동",
			"pw": "1111",
			"memo": "메모입니다",
			"regdate": "2023-10-26 09:40:00"
			
			}
		*/
		
		String temp="";
		
		temp+="[";
		
		for(MemoDTO dto : list) {
			temp+="{";
			temp+=String.format("\"seq\": \"%s\",", dto.getSeq());
			temp+=String.format("\"name\": \"%s\",", dto.getName());
			temp+=String.format("\"pw\": \"%s\",", dto.getPw());
			//memo 안에있는 엔터 처리방법
			temp+=String.format("\"memo\": \"%s\",", dto.getMemo()
									.replace("\r\n", "\\r\\n"));
			temp+=String.format("\"regdate\": \"%s\"", dto.getRegdate());
			temp+="}";
			temp+=",";
		}
		
		//마지막에 , 찍히는거 지워줘야됨
		temp=temp.substring(0, temp.length()-1);

		temp+="]";
		
		
		writer.println(temp);
		
		writer.close();
		
	}
	
	private void m5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		/*
			JSON, JavaScript Object Notation
			- 객체 표기법
			- 키와 값을 문자열("")로 표기
			- 단, 숫자 값은 "" 생략 가능
			- 쌍따옴표만 가능, 홑따옴표 불가능
			- 메소드 멤버 추가 불가능 
			- 자바의 DTO와 동일한 역할
			
			{
				키: "값",
				키: "값",
				키: "값"
			}


			2 > MemoDTO 반환 > JSON 형태 반환
			
			{
				"seq": "5",
				"name": "홍길동",
				"pw": "1111",
				"memo": "메모입니다",
				"regdate": "2023-10-26 09:40:00"
				
			}


		 */
		
		AjaxDAO dao=new AjaxDAO();
		MemoDTO dto=dao.get(22);
		
		resp.setContentType("application/json"); //MIME
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer=resp.getWriter();
		
		writer.println("{");
		writer.printf("\"seq\": \"%s\",", dto.getSeq());
		writer.printf("\"name\": \"%s\",", dto.getName());
		writer.printf("\"pw\": \"%s\",", dto.getPw());
		writer.printf("\"memo\": \"%s\",", dto.getMemo());
		writer.printf("\"regdate\": \"%s\"", dto.getRegdate());
		writer.println("}");

		writer.close();
		
	}
	
	private void m4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		//XML > 여러개의 메모 > MemoDTO x N개
		AjaxDAO dao=new AjaxDAO();
		
		ArrayList<MemoDTO> list=dao.listMemo();
		
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer=resp.getWriter();
		
		//ML > 최상위 태그 유일
		
		//list > XML형식의 문자열로 출력
		writer.println("<?xml version='1.0' encoding='UTF-8'?>");
		writer.println("<list>");//여러 데이터를 출력할떄는 <list>태그(유일태그)로 감싸서 만든다
		for(MemoDTO dto : list) {
			writer.print("<memo>");
			writer.printf("<seq>%s</seq>",dto.getSeq());
			writer.printf("<name>%s</name>",dto.getName());
			writer.printf("<pw>%s</pw>",dto.getPw());
			writer.printf("<memo>%s</memo>",dto.getMemo());
			writer.printf("<regdate>%s</regdate>",dto.getRegdate());
			writer.print("</memo>");
		}
		writer.println("</list>");
		
		writer.close();
		
		
	}

	private void m3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AjaxDAO dao=new AjaxDAO();
		
		MemoDTO dto=dao.get(21);
		
		//MemoDTO > (XML형식) > ajax
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml");
//		resp.setContentType("text/plain");
		
		
		PrintWriter writer=resp.getWriter();
		
		writer.print("<?xml version='1.0' encoding='UTF-8'?>");
		writer.print("<memo>");
		writer.printf("<seq>%s</seq>",dto.getSeq());
		writer.printf("<name>%s</name>",dto.getName());
		writer.printf("<pw>%s</pw>",dto.getPw());
		writer.printf("<memo>%s</memo>",dto.getMemo());
		writer.printf("<regdate>%s</regdate>",dto.getRegdate());
		writer.print("</memo>");
		
		writer.close();
		
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AjaxDAO dao=new AjaxDAO();
		
		ArrayList<MemoDTO> list=dao.listMemo();
		
		//CSV로 만들기
		String temp="";
		for(MemoDTO dto : list) {
			temp+=String.format("%s,%s,%s,%s,%s\r\n" 
								, dto.getSeq()
								, dto.getName()
								, dto.getPw()
								, dto.getMemo().replace("\r\n", "\n")
								, dto.getRegdate()
								);
		}
//		System.out.println(temp);
		
		resp.setContentType("Text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer=resp.getWriter();
		writer.print(temp);
		writer.close();
		
		
	}

	private void m1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//텍스트 반환(단일값)
		AjaxDAO dao=new AjaxDAO();
		int count=dao.getMemoCount();
		
		//MIME > 브라우저(or ajax객체)에게 네가 돌려받는 데이터가 이런 형식의 데이터다
		//	라고 알려주는 표시
		resp.setContentType("text/plain");//순수 텍스트 데이터
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer=resp.getWriter();
		writer.print(count);
		writer.close();
		
		
		
	}

}








