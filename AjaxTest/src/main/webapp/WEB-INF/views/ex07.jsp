<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<style>
	/* req에 저장된 list 가져와서 좌표 지정 */
	<c:forEach items="${list}" var="dto">
	#${dto.catid} {
		left: ${dto.x}px;
		top: ${dto.y}px;
	}
	</c:forEach>

</style>


</head>
<body>

	<h1>고양이 + Ajax</h1>

	<img src="/ajax/images/catty01.png" id="cat1" class="cat">
	<img src="/ajax/images/catty02.png" id="cat2" class="cat">
	<img src="/ajax/images/catty03.png" id="cat3" class="cat">
	<img src="/ajax/images/catty04.png" id="cat4" class="cat">
	<img src="/ajax/images/catty05.png" id="cat5" class="cat">

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js" ></script>
	<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>
	<script>
		
		//직접구현 vs 참조
		// -> 직접 구현 파
	
	
		//드래그 해주는 기능 jquery Ui 에서 제공 : draggable()
		$('.cat').draggable({
			//axis: 'x' //x축으로만 움직임
			//grid: [ 128, 128 ]
			stop: function(event, ui) {
				//alert(ui.position.left);
				//alert(ui.position.top);
				
				$.ajax({
					type: 'POST',
					url: '/ajax/ex07data.do',
					data: {
						//현재 x y 좌표
						x: ui.position.left,
						y: ui.position.top,
						catid: this.id
					},
					error: function(a,b,c) {
						console.log(a,b,c)
					}
				});
				
			}
			
		});
	
	
	
	</script>
	
</body>
</html>