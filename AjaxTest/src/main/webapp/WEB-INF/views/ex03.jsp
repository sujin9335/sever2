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
	

	<div>
		<input type="text" id="txt2">
		<input type="button" value="버튼2" id="btn2">
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
		$('#btn1').click(function() {
			
			//이거랑 같은 방식
			/* const hong = {
					name: 홍길동,
					age: 20,
					hello:function(){
						
					}
			}; */
			
			//태그에 종속되지않은 독립적인 기능이라 이렇게 씀
			$.ajax({
				
				//Ajax
				//- 비동기 자바스크립트 통신
				
				
				//ajax.open('GET', 'do') > 페이지 요청 정보 
				type: 'GET',
				url: '/ajax/ex03data.do',
				
				//기본값 true(비동기), false(동기)
				//async: false, //특별한 일 아니면 동기 방식으로 쓸일이 없음 
				
				
				//ex03data.do?name=홍길동 : 이거랑 같아 보임
				data: 'name=수진',
				
				//onreadystatechange + readyState(4) + status(200) 
				//	: 이거를 한번에 success로 표현 
				success: function(result) {
					//result == ajax.responseText
					$('#txt1').val(result);
				},
				
				//에러 발생 시 호출(이벤트) : 필수는 아니지만 개발할때 넣어두기
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
			
		});
	
	</script>
	
</body>
</html>