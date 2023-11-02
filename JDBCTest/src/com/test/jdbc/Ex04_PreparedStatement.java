package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex04_PreparedStatement {

	public static void main(String[] args) {
		
		
		
		m1();
		
		
		
		
	}

	private static void m1() {

		//Statement vs PreparedStatement
		//- Statement > 정적 SQL(매개변수 X)
		//- PreparedStatement > 동적 SQL(매개변수 O)
		
		//PreparedStatement
		//1. 매개변수 관리 용이
		//2. 매개변수 유효성 처리 
		
		
		
		//정적쿼리 : Statement로 하는게 편하다 (ex03 m1() sql)
		String sql="insert into tblAddress (seq, name, age, gender, address, regdate)"
				+ "values (seqAddress.nextVal, '아무개', 22, 'm', '서울시 강남구 대치동', default)";
		
		//얘도 정적쿼리 : %s 들어가있음
		sql="insert into tblAddress (seq, name, age, gender, address, regdate)"
				+ "values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)";
		
		//동적쿼리 : ?는 오라클 문구, 자바의 %s 역할을 함
		sql="insert into tblAddress (seq, name, age, gender, address, regdate)"
				+ "values (seqAddress.nextVal, ?, ?, ?, ?, default)";
		
		
		
		//insert + 사용자 입력 + Scanner
		String name="하하하";
		String age="20";
		String gender="m";
		//입력시  ' 가들어가면 sql 에서 '을 ''로 안바꾸면 인식을 잘못해서 오류나옴
		String address="서울시 강남구 역삼동's 아파트";
		
		//Stat 할시에 홑따옴표 처리 
//		name=name.replace("'","''");
//		address=address.replace("'","''");
		
		Connection conn=null;
		Statement stat=null;
		PreparedStatement pstat=null;
		
		try {
			
			conn=DBUtil.open();
			stat=conn.createStatement();
			
			
			
			//statement 방식
//			sql=String.format("insert into tblAddress (seq, name, age, gender, address, regdate)"
//					+ "values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)"
//					, name, age, gender, address);
//			
//			
//			int result=stat.executeUpdate(sql);
//			
//			System.out.println(result);
			
			
			//--------------------------
			
			
			//PreparedStatement 방식
			sql="insert into tblAddress (seq, name, age, gender, address, regdate)"
					+ "values (seqAddress.nextVal, ?, ?, ?, ?, default)";
			
			pstat=conn.prepareStatement(sql);
			
			//pstat > 매개변수를 관리하는 역할 겸함
			pstat.setString(1, name);//첫번째 ?에 name 을 넣어라
			pstat.setString(2, age);
			pstat.setString(3, gender);
			pstat.setString(4, address);
			
			int result=pstat.executeUpdate();
			
			System.out.println(result);
			
			
			pstat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
