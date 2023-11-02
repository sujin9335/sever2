package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.toy.DBUtil;

public class Dummy {

	public static void main(String[] args) {
		
		try {
			
			Connection conn=null;
			PreparedStatement stat=null;
			
			conn=DBUtil.open();
			
			
			String sql="insert into tblBoard (seq, subject, content, regdate, readcount, id) values (seqBoard.nextVal, ?, '내용', default, default, 'hong')";
			
			String temp="중국 칭다오 맥주가 ‘방뇨 사건’을 일으킨 노동자가 공안 당국에 구금됐다고 알리며 작업장의 관리 감독을 강화하겠다고 밝혔다\r\n"
					+ "2일 로이터 통신에 따르면 칭다오 맥주는 지난 1일 성명을 통해 해당 사건은 우리의 원료 운송 관리에 허점이 있음을 드러냈다고 인정했다.\r\n"
					+ "칭다오 맥주는 모든 원료 운송 차량은 직원들이 원료와 접촉할 수 없도록 봉인될 것이라며 내부 관리를 종합적으로 강화했고 조치가 취해졌다고 말했다.\r\n"
					+ "이어 인력 아웃소싱 관리를 강화할 것이며 인공지능(AI) 동작 인지 시스템을 활용해 공장 모니터링을 강화하겠다”고 덧붙였다.\r\n"
					+ "앞서 지난달 19일 중국 사회관계망서비스(SNS)에는 산둥성 핑두시 칭다오 3공장에서 헬멧을 쓰고 작업복을 입은 한 남성이 맥주 원료인 맥아 보관 장소에 들어가 소변을 보는 것으로 보이는 영상이 공개됐다.\r\n"
					+ "영상에는 그가 사방이 노출된 어깨 높이의 담을 넘어 원료가 쌓여 있는 곳으로 들어간 뒤 주위를 살피며 소변을 보는 모습이 담겼다.\r\n"
					+ "해당 영상이 공개되자 관련자에 대한 엄중 처벌 요구가 이어졌다.\r\n"
					+ "칭다오 맥주는 해당 영상 속 노동자가 정직원이 아닌 외주업체 인력이며 방뇨 장소도 공장 내부가 아닌 맥아 운송차량의 적재함 같은 야외라고 해명했다.\r\n"
					+ "그러나 이 영상으로 칭다오 맥주의 주가가 급락하면서 지난달 23~24일 이틀간 이 회사의 시가총액은 3000억원가량 줄어들었다.";
			
			String[] templist=temp.split(" ");
			
			Random rnd=new Random();
			
			
			stat=conn.prepareStatement(sql);
			
			for(int i=0; i<250; i++) {
				String subject="";
				
				for(int j=0; j<5; j++) {
					subject += templist[rnd.nextInt(templist.length)]+ " ";
				}
			
				stat.setString(1, subject);
				stat.execute();
				System.out.println(i);
				
			}

			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
		
		
	}
	
}
