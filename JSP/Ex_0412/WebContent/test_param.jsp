<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("UTF-8"); %>    
    
    
<%
	//jsp_input.jsp에서 넘겨준 세개의 파라미터를 수신해보자.
	//test_param.jsp?m_name=asdasd&m_age=12&m_tel=123123123 - 이런식으로넘어온다
	
	String name = request.getParameter("m_name");
	int age = Integer.parseInt(request.getParameter("m_age"));
	String tel = request.getParameter("m_tel");
	
	
	
	//파라미터로 넘어오는 모든 값은 문자열이나 바이너리타입(1,0) 이다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
		</tr>
		<tr>
			<td><%= name %></td>
			<td><%= age %></td>
			<td><%= tel %></td>
		</tr>
		
		
	</table>



</body>
</html>