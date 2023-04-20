<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

int no = Integer.parseInt(request.getParameter("no"));
String name = request.getParameter("name");
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int mat = Integer.parseInt(request.getParameter("mat"));


%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function update(f){
	//유효성 검사 했다고 가정하고
	f.action = "sung_modi.jsp";
	f.submit();
	
}

</script>


</head>
<body>


	<form>
		<input type="hidden" name="no" value="<%=no%>">
		<table border="1">
			<caption>학생정보 수정</caption>
			<tr>
				<th>이름</th>
				<td><input name="name" value="<%= name%>"></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input name="kor" value="<%= kor%>"></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input name="eng" value="<%= eng%>"></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input name="mat" value="<%= mat%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="update(this.form)">
					<input type="button" value="취소" onclick="location.href='Score_list.jsp'">
				</td>
			</tr>
			
		</table>
	</form>


</body>
</html>