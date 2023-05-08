<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send_check(){
		var f = document.f;
		// 유효성 검사
		
		f.submit();
	}
</script>

</head>
<body>
	<form name="f"
		method="get"
		action="reply.do">
		<input type="hidden" name="idx" value="${param.idx}">
		<input type="hidden" name="page" value="${param.page}">
		<table border="1">
			<caption>:::답 글 쓰 기:::</caption>
			<tr>
				<th>제목</th>
				<td><input name="subject" style="width:97.8%;"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="name" style="width:97.8%;"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="50" style="resize:none;"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input name="pwd" type="password" style="width:97.8%;">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<img src="img/btn_reg.gif" onclick="send_check();">
				<img src="img/btn_back.gif" onclick="location.href='board_list.do'">	
			</tr>
		</table>
	</form>

</body>
</html>