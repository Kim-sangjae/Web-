<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


	function send(f){
		var name = f.m_name.value.trim();
		var age = f.m_age.value.trim();
		var tel = f.m_tel.value.trim();
		
		//유효성체크
		//이름
		if(name == ''){
			alert("이름을 입력하세요");
			return;
		}
		
		//숫자판단 정규식
		//나이
		var pattern = /^[0-9]{1,3}$/;
		if(!pattern.test(age)){
			alert("나이는 정수로 입력하세요");
			f.age.focus();
			return;
		}
		
		
		//번호
		if(tel == ''){
			alert("전화번호를 입력하세요");
			return;
		}
		
		f.action = "test_param.jsp"; // 경로
		f.method = "POST"; // 전송방법
		
		f.submit();
		
	}//send()

</script>


</head>
<body>
	<form>
		이름: <input name="m_name"><br>
		나이: <input name="m_age"><br>
		전화번호: <input name="m_tel"><br>
		
		<input type="button" value="파라미터 전송" onclick="send(this.form)">
		
	</form>

</body>
</html>