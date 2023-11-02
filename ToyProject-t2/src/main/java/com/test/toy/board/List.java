package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.model.BoardDTO;
import com.test.toy.board.repository.BoardDAO;

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// List.java

		// -----------------
		// 호출방법 : 검색이 추가되서 B가 생김
		// A. list.do 호출(목록보기)
		// B. list.do?column=subject&word=검색어 > 호출(검색하기)

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = "n"; // 검색중("y"), 목록보기("n")

		if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
			search = "n";
		} else {
			search = "y";
		}

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("column", column);
		map.put("word", word);
		map.put("search", search);

		// 페이징 추가
		// - list.do > 1페이지 간주 기본값
		// - list.do?page=1
		// - list.do?page=5

		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물수
		int pageSize = 10; // 한페이지에서 출력할 게시물 수
		int totalPage = 0; // 총 페이지수
		int begin = 0; // 페이징 시작 위치
		int end = 0; // 페이지 끝 위치
		int n = 0;
		int loop = 0;
		int blockSize = 10;

		String page = req.getParameter("page");

		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}

		// list.do?page=1 > where rnum between 1 and 10
		// list.do?page=2 > where rnum between 11 and 20
		// list.do?page=3 > where rnum between 21 and 30

		// 페이지 번호 나타내는 수식(공식)
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		map.put("begin", begin + "");
		map.put("end", end + "");

		// System.out.println(map.toString());

		// -----------------

		// 1. DB 작업 > select
		// 2. 반환 > JSP 호출하기

		HttpSession session = req.getSession();

		// 조회수 티켓
		session.setAttribute("read", "n");

		// 1.
		BoardDAO dao = new BoardDAO();

		ArrayList<BoardDTO> list = dao.list(map);

		// 1.5 데이터 가공
		for (BoardDTO dto : list) {

			// 날짜 자르기
			// String regdate = dto.getRegdate();
			// dto.setRegdate(regdate.substring(0, 10));

			// 제목 길이 자르기
			String subject = dto.getSubject();

			if (subject.length() > 20) {
				subject = subject.substring(0, 20) + "..";
			}

			// 태그 비활성화
			subject = subject.replace("<", "&lt;");
			subject = subject.replace(">", "&gt;");

			dto.setSubject(subject);

		}

		// 총 게시물 수
		totalCount = dao.getTotalCount(); // 261
		totalPage = (int) Math.ceil((double) totalCount / pageSize); // 27

		StringBuilder sb = new StringBuilder();

		/*
		 * for (int i=1; i<=totalPage; i++) {
		 * 
		 * if (i == nowPage) { //#!는 빈 링크 할때 주로사용
		 * sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a> ", i)); }
		 * else {
		 * sb.append(String.format(" <a href='/toy/board/list.do?page=%d'>%d</a> ", i,
		 * i)); } }
		 */

		loop = 1; // 루프 변수(10바퀴)
		// n=1; //출력 페이지 번호
		n = ((nowPage - 1) / blockSize) * blockSize + 1;

		// 이전 10페이지
		if (n == 1) {
			sb.append(String.format("<a href='#!'>[이전 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href='/toy/board/list.do?page=%d'>[이전 %d페이지]</a>", n - 1, blockSize));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a> ", n));
			} else {
				sb.append(String.format(" <a href='/toy/board/list.do?page=%d'>%d</a> ", n, n));
			}

			loop++;
			n++;
		}

		// 다음 10페이지
		if (n > totalPage) {
			sb.append(String.format("<a href='#!'>[다음 %d페이지]</a>", blockSize));
		} else {
			sb.append(String.format("<a href='/toy/board/list.do?page=%d'>[다음 %d페이지]</a>", n, blockSize));
		}

		// 2.
		req.setAttribute("list", list);
		req.setAttribute("map", map);

		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);

		req.setAttribute("pagebar", sb.toString());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}
