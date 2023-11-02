package com.test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Ex04 {

   public static void main(String[] args) {
      
      //Selenium(셀레니움)
      //- 테스트 자동화 도구 > 업무중 일부 셋팅하는 경우 자동화 가능
      
      
      /* 준비물 */
      //1. 셀레니움 라이브러리
      //2. 브라우저를 통제할 수 있는 브라우저 드라이버
      
      //1. C:\class\dev\chromedriver.exe
      //2. lib → jar 복사
      
//      m1();
      m2();
//      m3();
      
      
   }

   private static void m3() {

      //아 크롤링 못하는 애들을 셀레니움을 통해 할 수 있구나...!
      
      String webDriverID = "webdriver.edge.driver";
      String path = "C:\\class\\dev\\msedgedriver.exe";
      
      System.setProperty(webDriverID, path);
      
      
      WebDriver driver = new EdgeDriver();
      
      String url = "http://localhost:8090/memo/list.do";
      
      driver.get(url);
      
      WebElement btn1 = driver.findElement(By.id("btn1"));
      btn1.click();
      
      WebElement result = driver.findElement(By.id("result"));
      System.out.println(result.getText());
      
      
   }

   private static void m2() {

      String webDriverID = "webdriver.edge.driver";
      String path = "C:\\class\\dev\\msedgedriver.exe";
      
      System.setProperty(webDriverID, path);
      
      
      WebDriver driver = new EdgeDriver();
      
      String url = "http://lms1.sist.co.kr/worknet/SLogin.asp";
      
      driver.get(url);
      
      WebElement id = driver.findElement(By.id("strLoginID"));
      WebElement pw = driver.findElement(By.id("strLoginPwd"));
      
      id.sendKeys("김수진");
      pw.sendKeys("6987");
      
      WebElement btn = driver.findElement(By.cssSelector("#content > div > form > table > tbody > tr > td > div > div.login-form > div.login-btn > input"));
      btn.click();
      
      //페이지 전환 > 딜레이 발생
      //기다림의 미학 만들어주기
      // - 예외처리가 반드시 필요한 코드
      try {
         //driver.wait(1000); > 오류 발생 안먹어요 그래서 아래의 코드 사용할거에요
         Thread.sleep(2000);
      } catch (Exception e) {
         System.out.println("at Ex04.m2");
         e.printStackTrace();
      }
      
      
      
      WebElement td = driver.findElement(By.cssSelector("#content > div > div > div > div.panel-body > form > table > thead > tr:nth-child(5) > td:nth-child(2)"));
      
      System.out.println(td.getText());
      //자기 정보를 보여주는 페이지가 뜨고 있는 중에 println이 먼저 실행되어 데이터가 출력되지 않는 것!
      //그래서 중간에서 페이지가 뜰 때까지 기다리게 해주는 기다림의 미학이 필요하다.
      
      
      
      
   }

   private static void m1() {

      String webDriverID = "webdriver.edge.driver";
      String path = "C:\\class\\dev\\msedgedriver.exe";
      
      System.setProperty(webDriverID, path);
      
      /*
         크롬 브라우저 > 아래 방법 안 됨 ㅠㅠ 그래서 엣지로 우회합니다!
         
         ChromeOptions options = new ChromeOptions();
         options.setCapability("ignoreProtectedModeSettings", true);




       */
      
      
      //이건 크롬꺼 > 이거 안 됨
//      
      
      //이제 중요!!
      //브라우저 참조 객체
//      WebDriver driver = new ChromeDriver(options);
      WebDriver driver = new EdgeDriver();
      
      String url = "https://naver.com";
      
      driver.get(url);
      
      //네이버 검색 창
      WebElement query = driver.findElement(By.id("query"));
      query.sendKeys("셀레니움");
      
      WebElement btn = driver.findElement(By.className("btn_search"));
      btn.click();
      
      
      
   }
}