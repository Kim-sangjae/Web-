<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
  PersonVO p1 = new PersonVO();
	

  PersonVO p2 = new PersonVO(); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
[[${p1.name}]]
[[${p2.name}]]

</body>
</html>