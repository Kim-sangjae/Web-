<%@page import="vo.SawonVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SawonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
    
 SawonDAO dao = SawonDAO.getInstance();
 List<SawonVO> list = dao.selectList();
    
    
    
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
			<th>사번</th>
			<th>부서번호</th>
			<th>사원이름</th>
			<th>업무</th>
			<th>입사날짜</th>
		</tr>
		<%for(int i = 0; i<list.size(); i++){
			
			SawonVO vo = list.get(i);
			
			%>
			<tr>
				<td><%= vo.getSabun() %></td>
				<td><%= vo.getDeptno() %></td>
				<td><%= vo.getSaname() %></td>
				<td><%= vo.getSajob() %></td>
				<td><%= vo.getSahire() %></td>
			</tr>
			
		<%}%>
		
		
	</table>






</body>
</html>