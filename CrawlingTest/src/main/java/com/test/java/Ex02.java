package com.test.java;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex02 {

	public static void main(String[] args) {
		
		try {
			
			String url="https://movie.daum.net/ranking/boxoffice/weekly";
			
			Document doc=Jsoup.connect(url).get();
			
//			System.out.println(doc.html());
			
			Elements list=doc.select(".item_poster");
			
			System.out.println(list.size());
			
			for(Element movie : list) {
				
				Element title=movie.selectFirst(".link_txt");
				System.out.println(title.text());
				
				Element date=movie.selectFirst(".txt_num");
				System.out.println(date.text());
				
				Element count=movie.selectFirst(".screen_out");
				System.out.println(count.nextSibling());

				//이미지 src 속성값
				Element poster=movie.selectFirst(".img_thumb");
				if(poster != null) {
					System.out.println(poster.attr("src"));
					getImage(poster.attr("src"), title.text());
					
//					Thread.sleep(2000); //너무 빠른것 같아 속도 느리게 2초
				}
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	//이미지 다운로드 저장 메소든
	private static void getImage(String imgUrl, String name) {
		
		URL url = null;
		InputStream in=null;
		OutputStream out=null;
		
		try {
			
			url=new URL(imgUrl);
			in=url.openStream(); //이미지 읽기
			out=new FileOutputStream("C:\\class\\code\\server\\CrawlingTest\\poster\\"+ name +".png"); //파일 저장하기(쓰기)
			
			while(true) {
				int data=in.read();
				if(data == 1) break;
				out.write(data);
				
			}
			
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}








