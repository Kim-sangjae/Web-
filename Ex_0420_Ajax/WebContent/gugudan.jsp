<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Ajax : 자바스크립트를 이용한 백그라운드 통신 기술(비동기 통신) 부분새로고침?  -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="js/httpRequest.js"></script>
<script type="text/javascript">

	function send(){
		
		var dan = document.getElementById("dan").value;
		var url = "gugudan_ajax.jsp"; // 목적지
		var param = "dan="+dan; // 파라미터
		sendRequest(url,param,resultFn,"GET"); //sendRequest()메서드 호출
		
	}	
	
	function resultFn(){
		
		// ajax에서 서버로부터 응답을 확인하기 위해 사용하는 XMLHttoRequest 객체의 프로퍼티는 다음과 같다
		// readyStatus
		// status
		// onreadystatechange
		
		// readyState : XMLHttpRequest 객체의 상태를 보여줍니다.
		// UNSET(숫자 : 0) : XMLHttpRequest 객체가 생성됨
		// OPEND(숫자 : 1) : open() 메서드가 성공적으로 실행됨
		// HEADERS_RECEIVED(숫자 : 2) : 모든 요청에 대한 응답이 도착함
		// LODING(숫자 : 3) : 요청한 데이터를 처리중
		// DONE(숫자 : 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨
		
		//status
		//200 : 서버에 문서가 존재함(문제없음)
		//404 : 서버에 문서가 존재하지 않음
		
		console.log(xhr.readyState + " / " + xhr.status)
		
		if(xhr.readyState == 4 && xhr.status == 200){
			//도착한 데이터 읽어오기
			var data = xhr.responseText; // 최종결과값을 갖고 돌아온다
			
			// 중복되는 태그들은 innerHTML이 알아서 제거해준다
			document.getElementById("disp").innerHTML = data;
			
		}
	}

</script>




</head>
<body>
	단 : <input id="dan">
	<input type="button" value="결과보기" onclick="send()"> <br>
	<div id="disp"></div>
</body>
</html>