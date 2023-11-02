package com.test.memo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.memo.DBUtil;
import com.test.memo.dto.MemoDTO;

public class MemoDAO {

	//미리 DB접속 필드에 깔아놓기
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	//생성자로 DBUtil 연결하기
	public MemoDAO() {
		this.conn=DBUtil.open();
	}
	
	public int add(MemoDTO dto) {

		//DTO > insert
		
		try {
			
			String sql="insert into tblMemo (seq, name, pw, memo, regdate)\r\n"
					+ "    values (seqMemo.nextVal, ?, ?, ?, default)";
			
			//?매개변수 지정해줘야 되기 때문에
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getMemo());
			
			//성공하면 1 , 실패시 0 출력
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public ArrayList<MemoDTO> list() {
		//리스트에 모든 데이터 저장
		ArrayList<MemoDTO> list=new ArrayList<MemoDTO>();
		
		try {
			
			String sql="select * from tblMemo order by seq desc";
			
			//매개변수 없기때문에 stat사용
			stat=conn.createStatement();
			
			rs=stat.executeQuery(sql);
			
			//rs == 메모 목록
			
			//rs > list
			while(rs.next()) {
				//레코드 1줄 > MemoDTO 1개 
				MemoDTO dto=new MemoDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public MemoDTO get(String seq) {
		MemoDTO dto=new MemoDTO();
		
		try {
			
			String sql="select * from tblMemo where seq = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs=pstat.executeQuery();
			
			
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPw(rs.getString("pw"));
				dto.setMemo(rs.getString("memo"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}

	public int edit(MemoDTO dto) {
		
		try {
			
			String sql="update tblMemo set name = ?, memo = ? where seq = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getMemo());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public boolean check(MemoDTO dto) {
		
		try {
			
			//비번과 seq로 검색해서 있으면 count = 1 없으면 0
			String sql="select count(*) as cnt from tblMemo where seq=? and pw =?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeq());
			pstat.setString(2, dto.getPw());
			
			rs=pstat.executeQuery();
			
			//결과 출력 처리
			if(rs.next()) {
				return rs.getInt("cnt") == 1 ? true : false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	public int del(String seq) {

		try {
			
			String sql="delete from tblMemo where seq = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

}
