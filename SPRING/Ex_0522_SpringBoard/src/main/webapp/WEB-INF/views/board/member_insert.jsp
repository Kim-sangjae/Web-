<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/httpRequest.js"></script>
<script type="text/javascript">

	var b_idCheck = false;

	// 중복체크 메서드
	function check_id(){
		var id = document.getElementById("id").value.trim();
		
		if(id == ""){
			alert("아이디를 입력하세요");
			return;
		}
		
		var url = "check_id.do";
		var param = "id=" + encodeURIComponent(id);
		
		sendRequest(url,param,resultFn,"POST");
	}
	
	
	function resultFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var data = xhr.responseText;
			var json = (new Function('return'+data))();
			var id = document.getElementById("id");
			
			if(json[0].res == 'no'){
				alert('이미 존재하는 아이디 입니다.');
				id.value ="";
				return;
				
			}  else if(json[0].res == 'yes') {
				alert('가입가능한 아이디 입니다.');
				b_idCheck=true;
			}
		}
				
	}
	
	
	function che(){
		b_idCheck=false;
	}
	
	
	
	
	
	
	
	function send(f){
		// 입력내용 체크
		
		var id = f.id.value.trim();
		var pw = f.pw.value.trim();
		
		if(id == ''){
			alert('아이디를 입력해주세요')
			return;
		}
		if(pw == ''){
			alert('비밀번호를 입력해주세요')
			return;
		}
		
		 if(!b_idCheck){
			 alert('아이디 중복체크를 해주세요')
			 return;
		 }
		
		
		
		f.method="POST";
		f.action="member_insert.do";
		f.submit();
	}
	
	
	
	
	
	
</script>



</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>:::회원가입:::</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input name="id" id="id" placeholder="아이디" onchange="che()">
					<input type="button" value="중복체크" onclick="check_id()">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" placeholder="비밀번호">
				</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>
					<input name="name"placeholder="이름">
				</td>
			</tr>
			
			
			<tr>
				<th>이메일</th>
				<td>
					<input name="email" placeholder="example@naver.com">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="가입" onclick="send(this.form)">
					<input type="button" value="취소" onclick="location.href='board_list.do'">
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>