<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	PersonVo p1 = new PersonVo();

	p1.setName("홍길동");
	p1.setAge(30);
	p1.setTel("010-1234-1234");
	
	
	PersonVo p2 = new PersonVo();

	p2.setName("김자바");
	p2.setAge(39);
	p2.setTel("010-4321-4321");
	
	
	List<PersonVo> list = new ArrayList<>();
	
	list.add(p1);
	list.add(p2);


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
		
		<%for(int i =0; i <list.size(); i ++){%>
			<tr>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getAge() %></td>
				<td><%= list.get(i).getTel() %></td>
			</tr>
		<%} %>
		
			
		
	
	</table>





</body>
</html>