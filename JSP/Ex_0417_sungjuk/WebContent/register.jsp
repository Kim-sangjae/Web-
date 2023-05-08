<%@page import="vo.ScoreVO"%>
<%@page import="dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));

	ScoreVO vo = new ScoreVO();
	vo.setName(name);
	vo.setKor(kor);
	vo.setEng(eng);
	vo.setMat(mat);
	
	
	int res = ScoreDAO.getInstance().insert(vo); // 1 (res)
	
	if(res> 0){
		//자바영역에 location.href 는 못씀!
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