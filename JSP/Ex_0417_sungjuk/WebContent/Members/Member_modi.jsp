<%@page import="dao.MemberDAO"%>
<%@page import="vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("utf-8");

int no = Integer.parseInt(request.getParameter("idx"));
String name = request.getParameter("name");

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String email = request.getParameter("email");

MemberVo vo = new MemberVo();

vo.setIdx(no);
vo.setName(name);
vo.setId(id);
vo.setPw(pw);
vo.setEmail(email);




int res = MemberDAO.getInstance().update(vo);

if(res>0) {
	response.sendRedirect("Member.jsp");
}


%>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>