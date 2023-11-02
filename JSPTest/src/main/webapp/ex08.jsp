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

	<h1>컨트롤 입력 + 전송</h1>
	
	<form method="POST" action="ex08_ok.jsp">
	<table class="vertical">
		<tr>
			<th>텍스트박스</th>
			<td><input type="text" name="txt1"></td>
		</tr>
		<tr>
			<th>암호박스</th>
			<td><input type="password" name="txt2"></td>
		</tr>
		<tr>
			<th>다중 텍스트</th>
			<td><textarea name="txt3"></textarea></td>
		</tr>
		<tr>
			<th>체크 박스1</th>
			<td><input type="checkbox" name="cb1" value="yes"></td>
		</tr>
		<tr>
			<th>체크 박스2</th>
			<td>
				<h3>취미를 선택하세요</h3>
				<label><input type="checkbox" name="cb2" value="독서">독서</label>
				<label><input type="checkbox" name="cb3" value="운동">운동</label>
				<label><input type="checkbox" name="cb4" value="코딩">코딩</label>
			</td>
		</tr>
		<tr>
			<th>체크 박스2-1</th>
			<td>
				<h3>취미를 선택하세요</h3>
				<label><input type="checkbox" name="cb5" value="독서">독서</label>
				<label><input type="checkbox" name="cb5" value="운동">운동</label>
				<label><input type="checkbox" name="cb5" value="코딩">코딩</label>
			</td>
		</tr>
		<tr>
			<th>라디오 버튼</th>
			<td>
				<h3>성별을 선택하시오</h3>
				<label><input type="radio" name="rb" value="male" checked>남자</label>
				<label><input type="radio" name="rb" value="female">여자</label>
			</td>
		</tr>
		<!-- 10-18-------------------------- -->
		<tr>
			<th>셀렉트 박스</th>
			<td>
				<select name="sel1" multiple>
					<option value="1">사과</option>
					<option value="2">바나나</option>
					<option value="3">포도</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>히든 태그</th>
			<td><input type="hidden" name="txt4" value="hong"></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><input type="date" name="regdate"></td>
		</tr>
		<tr>
			<th>범위</th>
			<td><input type="range" name="min" min="10" max="1000"></td>
		</tr>
		<tr>
			<th>색상</th>
			<td><input type="color" name="color" style="height: 50px;"></td>
		</tr>
		<tr>
			<th></th>
			<td></td>
		</tr>
	</table>
	<div>
		<input type="submit" value="보내기">
		<input type="button" value="클릭" id="btn1"> <!-- 몇번클릭? -->
	</div>
	<input type="hidden" name="count">
		
	</form>
	
	<h1>링크</h1>
	
	<div>
		<!-- 오류뜨는 이유는 다중태그 처리문제 : if문으로 처리함 -->
		<a href="ex08_ok.jsp?id=hong&pw=1234">링크입니다</a>
	</div>
	<input type="button" value="클릭" id="btn2">
	

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
	
		/* 몇번클릭 했는지 서버로 전송하기 */
		let count=0; //서버로 전송하고 싶다
	
		$('#btn1').click(function() {
			count++;
			/* 히든태그로 보내기 */
			$('input[name=count]').val(count);
		});
		
		$('#btn2').click(function() {
			location.href = 'ex08_ok.jsp?id=haha&pw=1111';
		});
		
	</script>
	
</body>
</html>