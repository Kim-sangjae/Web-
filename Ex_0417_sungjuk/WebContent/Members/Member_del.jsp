<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	request.setCharacterEncoding("utf-8");

	//sung_del.jsp?no=1
	int no = Integer.parseInt(request.getParameter("no"));
	
	int res = MemberDAO.getInstance().delete(no);
	
	if(res > 0){
		response.sendRedirect("Member.jsp");
	
	}
	
%>



</head>
<body>

</body>
</html>