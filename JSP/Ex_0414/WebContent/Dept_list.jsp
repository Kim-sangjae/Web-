<%@page import="vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
 <%
 
 	DeptDAO dao = DeptDAO.getInstance();
 	List<DeptVO> list = dao.selectList(); // 부서조회
 
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
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
		</tr>
		<%for(int i = 0; i<list.size(); i++){
			
			DeptVO vo = list.get(i);
			%>
			<tr>
				<td><%= vo.getDeptno() %></td>
				<td><%= vo.getDname() %></td>
				<td><%= vo.getLoc() %></td>
			</tr>
			
		<%}%>
		
		
	</table>



</body>
</html>