<%@page import="vo.ScoreVO"%>
<%@page import="dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
int no = Integer.parseInt(request.getParameter("no"));
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int mat = Integer.parseInt(request.getParameter("mat"));

ScoreVO vo = new ScoreVO();

vo.setNo(no);
vo.setName(name);
vo.setKor(kor);
vo.setEng(eng);
vo.setMat(mat);





int res = ScoreDAO.getInstance().update(vo);

if(res>0) {
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