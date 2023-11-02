package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Ex05_CallableStatement {

	public static void main(String[] args) {
		
		//프로시저용
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
		
	}
	private static void m5() {
		
		Connection conn=null;
		CallableStatement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			
			String sql= "{ call procM5(?) }";
			
			stat=conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			
			//오라클 커서 == 결과 테이블 탐색하는 참조 객체 == 결과 테이블
			//ResultSet == 결과 테이블 탐색하는 참조 객체 == 결과 테이블
			//오라클 커서 == ResultSet//동일한 구조
			//커서라는 타입은 없어서 Object로 가져와서 형변환
			rs=(ResultSet)stat.getObject(1);
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("age"));
				System.out.println(rs.getString("gender"));
				System.out.println();
			}
			
			
			rs.close();
			stat.close();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void m4() {
		
		Connection conn=null;
		CallableStatement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			
			String sql="{ call procM4(?,?,?) }";
			
			stat=conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.VARCHAR);
			stat.registerOutParameter(2, OracleTypes.NUMBER);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			
			//쿼리 실행
			stat.executeQuery();
			
			System.out.println(stat.getString(1));
			System.out.println(stat.getInt(2));
			System.out.println(stat.getString(3));
			
			
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void m3() {
		
		Connection conn=null;
		CallableStatement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			
			//out도 매개변수로 있는거라 ? 처리해줘야됨
			String sql= "{ call procM3(?) }";
			
			stat=conn.prepareCall(sql);
			
			//out 매개변수 처리
			stat.registerOutParameter(1, OracleTypes.NUMBER);
			
			//결과값과 out파라미터 값은 받는 방식이달라서 ResultSet처리 하지않음
//			int result=stat.executeUpdate();
			stat.executeQuery(); //resultSet 안받음 : 어짜피 값이 없어서 rs에 넣지않음
			
			//rs.getInt(1); : 얘랑 비슷한 방식
			int cnt=stat.getInt(1); //out 파라미터 읽기
			System.out.println(cnt);
			
			//결론 : out 파라미터 값은 resultSet으로 받지 않음

			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	private static void m2() {
		
		Connection conn=null;
		CallableStatement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			
			String sql= "{ call procM2(?, ?, ?, ?) }";
			stat=conn.prepareCall(sql);
			
			stat.setString(1, "홍길동");
			stat.setString(2, "20");
			stat.setString(3, "m");
			stat.setString(4, "서울시 강남구 역삼동");
			
			int result=stat.executeUpdate();
			
			System.out.println(result);
			
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m1() {
		
		Connection conn=null;
		CallableStatement stat=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBUtil.open();
			
			//프로시저 procM1 호출
			String sql="{ call procM1 }";
			stat=conn.prepareCall(sql);
			
			int result=stat.executeUpdate();
			
			System.out.println(result);
			
			
			
			
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
