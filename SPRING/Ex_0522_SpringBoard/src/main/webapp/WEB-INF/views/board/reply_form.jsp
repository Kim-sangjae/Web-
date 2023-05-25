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
		f.submit();
	}
</script>


</head>
<body>

	<form name = "f" method="post" action="reply.do">
		<input type="hidden" name="idx" value="${param.idx }">
		<input type="hidden" name="page" value="${param.page }">
		<table border="1" align="center">
			<tr>
				<th>제목</th>
				<td><input name="subject"></td>
			</tr>
			
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" style="resize:none;" name="content"></textarea></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<img src="resources/img/btn_reg.gif" onclick="send_check()">
				</td>
				<td colspan="2">
					<img src="resources/img/btn_back.gif" onclick="location.href='board_list.do?page=${param.page}'">
				</td>
			</tr>
			
		</table>	
	</form>

</body>
</html>