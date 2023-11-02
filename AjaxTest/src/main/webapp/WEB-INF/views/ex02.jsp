<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">

</head>
<body>



	<div>
		<input type="text" id="txt1">
		<input type="button" value="버튼1" id="btn1">
	</div>
	
	<!-- 출력하는 데이터 띄우는 div -->
	<div id="msg" class="message"></div>

	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
		$('#btn1').click(function(){
			
			//페이지(데이터) 요청
			//1. 브라우저를 통해서 요청
			//	- 서버측 > HTML 페이지를 반환
			
			 //2. ajax를 통해서 요청
         	//	- 서버측 > 필요한 데이터만 반환
			
			
			//Ajax
			//1. 순수 자바스크립트로 쓸수있음
			//2. jQuery > 개량 API로도 구현 가능
            //(같은 상황이라면 2번 사용 > Why? 코드 양 차이 때문)
         	//지금은 순수 자바스크립트 ver
			
			
			//Ajax 요청 + 응답 > Ajax 객체
			const ajax = new XMLHttpRequest(); //서버와 데이터를 송수신 : 객체
			
			
			//readyState
			//- ajax 객체의 상태(= 현재 서버와의 통신 상태)
			//1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
			//2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
			//3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
			//4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
			//5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
			
			ajax.onreadystatechange = function() {
				
				//$('#msg').html(ajax.responseText);
				
				//응답준비완료 상태 4 && 정상상태 200
				if(ajax.readyState == 4 && ajax.status == 200){
					$('#msg').append('<div>readyState: ' + ajax.readyState + "</div>");
					
					//상태 코드
					//- 서버가 요청에 응답할 때의 상태 : HTTP 응답코드
					//- 200 OK > 모든 상태 정상 : 정상이라 볼일이 없음 
					//- 404 not Found : 주소틀림
					//- 405 Method Not Allowed : POST GET 방식 잘못
					//- 408 Reqest timeout : 오래걸려서 나옴
					//- 500 Internal Server Error : 서버쪽 오타같은 동작에러
					$('#msg').append('<div>status: ' + ajax.status + "</div>");

					//***** ajax가 서버로부터 응답 받은 데이터를 접근하려면 반드시 readyState가 4일때만 접근해야한다
					//	(접근해서 출력할수도 있고 에러가 나지 않지만 4가 됐을때 접근해야 안정적이다)
					$('#msg').append('<div>responseText: ' + ajax.responseText + "</div>");
					$('#msg').append('<hr>');
					$('#txt1').val(ajax.responseText);
					
				}
				
			};
			
			//<form method="GET" action="주소"> : 이거랑 방식이 같음(서버와 데이터 통신) 
			//ajax.open('GET', '/ajax/ex02.txt'); //서버 연결(X) > 설정
			ajax.open('GET', '/ajax/ex02data.do');
			ajax.send(); //서버와 연결해라 > connect
			
			
		});
	
	
	</script>
	
</body>
</html>