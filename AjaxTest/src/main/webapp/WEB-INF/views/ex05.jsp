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
	
	<h1>Ajax 데이터 보내는 방법</h1>
	
	<form id="form" >
	<!-- <form id="form" method="POST" action="/ajax/ex05data.do"> -->
	<table>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" value="홍길동"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age"  value="22"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" id="gender1" value="m">남자
				<input type="radio" name="gender" id="gender2" value="f"  checked>여자
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address"  value="용인시"></td>
		</tr>
		<tr>
			<th>전화</th>
			<td><input type="text" name="tel" id="tel" value="010-2222-3333"></td>
		</tr>
	</table>
	
	<div>
		<input type="button" value="확인" id="btn">
	</div>
	
	
	</form>





	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
		$('#btn').click(function(){
			
			//1. 단일 데이터 전송
			/* $.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: 'key='+$('#name').val(),
				success: function(result) {
					//데이터 수신
					
				},
				error: function(a,b,c){
					console.log(a,b,c);
				}
			}); */
			
			//-----------------------------
			
			//기본적으로 데이터 전송하는 방법
			
			//라디오 버튼의 경우
			//남자 선택인지 여자 선택인지 jQuery에서는
			//$('input[name=gender]:checked');
			//alert($('input[name=gender]:checked').val());
			
			/* $.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: 'name='+$('#name').val() 
					+ '&age=' + $('#age').val()
					+ '&gender=' + $('input[name=gender]:checked').val()
					+ '&address=' + $('#address').val()
					+ '&tel=' + $('#tel').val()
					,
				error: function(a,b,c){
					console.log(a,b,c);
				}
			}); */
			
			//-----------------------------
			
			/* $.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: { 
					name: $('#name').val(),
					age: $('#age').val(),
					gender: $('input[name=gender]:checked').val(),
					address: $('#address').val(),
					tel: $('#tel').val()
					}
					,
				error: function(a,b,c){
					console.log(a,b,c);
				}
			}); */
			
			//-----------------------------
			
			//폼태그가 있어야 쓸수있는 방법 : serialize 가 form안에있는 값을 모두 가져옴
			console.log($("#form").serialize());
			//name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=22&gender=f&address=%EC%9A%A9%EC%9D%B8%EC%8B%9C&tel=010-2222-3333
			
			//조건
			//1. <form> 태그 사용
			//2. <input name="key"> > 태그마다 name을 반드시 명시 : name은 key값
			
			$.ajax({
				type: 'POST',
				url: '/ajax/ex05data.do',
				data: $("#form").serialize()
					,
				error: function(a,b,c){
					console.log(a,b,c);
				}
			});
			
		});
	
	</script>
	
</body>
</html>







