<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

//아이디 중복체크 여부
var b_idCheck = false;






function send(f){
	
	if(!b_idCheck){
		alert("아이디중복체크를 하세요");
		return;
	}
	
	
	
	
	var name = f.name.value.trim();
	var id = f.id.value.trim();
	var pwd = f.pwd.value;
	

	if(id == ''){
		alert("아이디를입력해주세요");
		return;
	}
	
	if(name == ''){
		alert("이름을입력해주세요");
		return;
	}
	if(pwd == ''){
		alert("비밀번호를입력해주세요");
		return;
	}
	
	f.submit();
	
}


// id 중복체크를 위한 메서드

function check_id(){
	
	var id = document.getElementById("id").value.trim();
	
	if(id == ''){
		alert("아이디를 입력하세요");
		return;
	}
	
	// id 를 Ajax를 통해서 서버로 전송
	var url = "check_id.do";
	
	// id에 @와 같은 특수문자가 들어가있는 경우를 대비하여 인코딩하여 보낸다.
	var param = "id="+encodeURIComponent(id);
	
	sendRequest(url,param,resultFn,"post");
	
}


function resultFn(){
	if(xhr.readyState == 4 && xhr.status == 200){
		
	}
}







</script>





</head>
<body>


<div align="center">
	<div>:::회원가입:::</div>
	<form action="insert.do" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="중복체크" onclick="check_id()">
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pwd">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="가입" onclick="send(this.form)">
			<input type="button" value="취소" onclick="location.href='UserLIst.do'">
		</td>
	</tr>
	
	
</table>

</form>
</div>

</body>
</html>