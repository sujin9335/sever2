package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex03_Statement {

	public static void main(String[] args) {
		
		/*
			
			1. Connection
			- 연결/종류
			
			2. Statement
			- 모든 SQL을 실행하는 역할
			
			
			Statement 종류
			1. Statement
			- 기본형
			- 매개 변수 처리 귀찮음
			- 안정성 낮음, 가독성 낮음
			
			2. PreparedStatement
			- 개량형
			- 매개 변수 처리 특화
			- 안정성 높음, 가독성 높음
			
			3. CallableStatement
			- 개량형
			- 프로시저 호출 전용
			
			
		
		*/
		
//		Connection conn=null;
//		Statement stat=null;
//		ResultSet rs=null;
//		
//		try {
//			
//			conn=DBUtil.open();
//			stat=conn.createStatement();
//			
//			rs.close();
//			stat.close();
//			conn.close();
//		
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
		
		//select 
		//1. 단일값 반환 > 1행 1열
		//2. 다중값 반환 > 1행 N열
		//3. 다중값 반환 > N행 1열
		//4. 다중값 반환 > N행 N열
//		m6();
//		m7();
//		m8();
		m9();
		
	}

	private static void m9() {

		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="select * from tblAddress";
			
			rs=stat.executeQuery(sql);
			
			System.out.println("[번호]\t[이름]\t[나이]\t[주소]");
			
			while(rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\n"
								, rs.getString("seq")
								, rs.getString("name")
								, rs.getString("age")
								, rs.getString("address")
								);
			}
			
			
			
			rs.close();
			stat.close();
			conn.close();
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m8() {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="select name from tblAddress";
			
			rs=stat.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("Name"));
			}
			
//			rs.next();
//			System.out.println(rs.getString("Name"));
//			rs.next();
//			System.out.println(rs.getString("Name"));
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m7() {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			Scanner sc=new Scanner(System.in);
			
			System.out.print("번호: ");
			String seq=sc.nextLine();
			
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="select * from tblAddress where seq = "+seq;
			
			rs=stat.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("번호: "+rs.getString("seq")); 
				System.out.println("이름: "+rs.getString("name")); 
				System.out.println("나이: "+rs.getString("age")); 
				System.out.println("성별: "+rs.getString("gender")); 
				System.out.println("주소: "+rs.getString("address")); 
				System.out.println("날짜: "+rs.getString("regdate")); 
			}else {
				System.out.printf("입력한 %s번의 데이터가 없습니다\n", seq);
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m6() {
		
		//1. 단일값 반환 > 1행 1열
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="select count(*) as cnt from tblAddress";
			
			rs=stat.executeQuery(sql);
			
//			System.out.println(rs);
			
			//ResultSet < Iterator, 향상된 for, 스트림, 커서
			
			rs.next(); //커서 1줄 전진
			
			//현재 커서가 가르키고 있는 레코드의 원하는 컬럼을 접근 > 데이터
			//1부터 시작함
			//int count=rs.getInt(1); //컬럼 위치(index)
			int count=rs.getInt("cnt");
			
			System.out.println(count);
			
			
			
			//자원해제ㅐ
			rs.close();
			stat.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void m5() {

		//tblAddress > 새로운 사람 등록하기
		Scanner sc=new Scanner(System.in);
		String name="";
		String age="";
		String gender="";
		String address="";
		
		
		Connection conn=null;
		Statement stat=null;
		
		try {
			
			System.out.print("이름: ");
			name=sc.nextLine();
			System.out.print("나이: ");
			age=sc.nextLine();
			System.out.print("성별(m,f): ");
			gender=sc.nextLine();
			System.out.print("주소: ");
			address=sc.nextLine();
			
			conn=DBUtil.open();
			
			//연결됐을때만 동작하게 만드는 if
			if(!conn.isClosed()) {
				System.out.println("DB 접속 성공");
				
				String sql=String.format("insert into tblAddress (seq, name, age, gender, address, regdate)"
						+ "values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)", name, age, gender, address); 
				
				stat=conn.createStatement();
				
				int result=stat.executeUpdate(sql);
				
				if(result == 1) {
					System.out.println("삽입 성공");
				}else {
					System.out.println("삽입 실패");
				}

				
				stat.close();
				conn.close();
				
				
				
				
			}else {
				System.out.println("DB 접속 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void m4() {

		Connection conn=null;
		Statement stat=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="create table tblAddress (\r\n"
					+ "    seq number primary key,\r\n"
					+ "    name varchar2(30) not null,\r\n"
					+ "    age number not null,\r\n"
					+ "    gender char(1) not null,\r\n"
					+ "    address varchar2(300) not null,\r\n"
					+ "    regdate date default sysdate not null\r\n"
					+ ")";
			
			int result=stat.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void m3() {

		//반환값 x > delete 실행
		Connection conn=null;
		Statement stat=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="delete tblAddress where seq = 3";
			
			int result=stat.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {

		//반환값 x > update 실행
		Connection conn=null;
		Statement stat=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			String sql="update tblAddress set age = age + 1";
			
			int result=stat.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m1() {

		//1. Statement
		
		//반환값 X > insert 실행
		
		Connection conn=null;
		Statement stat=null;
		
		try {
			
			conn=DBUtil.open();
			
			//연결됐을때만 동작하게 만드는 if
			if(!conn.isClosed()) {
				System.out.println("DB 접속 성공");
				
				//SQL 실행 > 자바는 SQL을 모른다 > SQL을 문자로 취급한다
				
				//서블릿(자바) > HTML, CSS, JavaScript > "<html>"
				
				//오류 ORA-00911: invalid character 는 ;써서그럼 지우기
				//문자열로 작성할 문구를 편집기에서 먼저 편하게 작성하고 복붙한다
				String sql="insert into tblAddress (seq, name, age, gender, address, regdate)"
						+ "values (seqAddress.nextVal, '아무개', 22, 'm', '서울시 강남구 대치동', default)"; 
				
				//stat 만들기 > SQL 실행하는 역할
				stat=conn.createStatement();
				
				//1. 반환값이 없는 쿼리 > select 빼고 나머지 SQL
				//	- int stat.excuteUdate()
				
				//2. 반환값이 있는 쿼리 > select 
				//	- ResultSet stat.excuteQuery()
				
				//SQL Developer > Ctrl + Enter 동일
				//적용된 행의 개수 : 출력 '1 행 이(가) 삽입되었습니다.' 의 '1'값
				int result=stat.executeUpdate(sql);
				
				if(result == 1) {
					System.out.println("삽입 성공");
				}else {
					System.out.println("삽입 실패");
				}

				//자원해제
				stat.close();
				conn.close();
				
				
				
				
			}else {
				System.out.println("DB 접속 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}










