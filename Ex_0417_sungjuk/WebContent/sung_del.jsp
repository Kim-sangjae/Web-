<%@page import="dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%
	// 데이터 수신할때 인코딩
	// Post 방식으로 넘기면 한글이 깨질때가있다
	request.setCharacterEncoding("utf-8");

	//sung_del.jsp?no=1
	int no = Integer.parseInt(request.getParameter("no"));
	
	int res = ScoreDAO.getInstance().delete(no);
	
	if(res > 0){
		response.sendRedirect("Score_list.jsp");
	
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>