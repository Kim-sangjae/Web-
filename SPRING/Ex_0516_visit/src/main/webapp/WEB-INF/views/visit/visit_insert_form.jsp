<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function send(f){
		var name = f.name.value;
		var content = f.content.value;
		var pwd = f.pwd.value;
		
		if(name == ''){
			alert("이름을 입력해주세요")
			return;
		}
		
		if(content == ''){
			alert("내용을 입력해주세요")
			return;
		}
		
		if(pwd == ''){
			alert("비밀번호를 입력해주세요")
			return;
		}
		
		f.method ="post";
		f.action = "insert.do";
		f.submit();
		
	}
</script>
</head>
<body>

	<form enctype="multipart/form-data">
		<table border="1" align="center" style="width:500px;">
			<caption>:::방명록 작성하기:::</caption>
			<tr>
				<th style="width:100px;">작성자</th>
				<td>
					<input name="name" style="width:98%;">
				</td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>												<!-- wrap속성 : on 을하면 끝에서 엔터값이 자동적용 -->
					<textarea row="10" cols="40" name="content" style="resize:none; width:98%;" wrap="on"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>이미지업로드</th>
				<td>
					<input type="file" name="photo">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd" style="width:98%;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="등록하기" onclick="send(this.form)">
					<input type="button" value="목록" onclick="location.href='visit_list.do'">
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>