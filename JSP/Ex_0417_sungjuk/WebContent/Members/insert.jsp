<%@page import="dao.MemberDAO"%>
<%@page import="vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String email = request.getParameter("email");


MemberVo vo = new MemberVo();
vo.setName(name);
vo.setId(id);
vo.setPw(pw);
vo.setEmail(email);


int res = MemberDAO.getInstance().insert(vo);

if(res>0){
	
	response.sendRedirect("Member.jsp");
	
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