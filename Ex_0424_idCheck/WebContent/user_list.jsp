<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
<style type="text/css">
table{
border-spacing:10px;
box-shadow:10px 5px 5px green;
border-radius: 10px;
}	

td{
text-align:center;
border-style:none;

}	

th{
background-color:gray;
color:white;
font-size:20px;
font-weight:bold;
box-shadow: 1px 1px 3px 1px gray;
border-radius: 5px;
padding:5px;
}

input{
border-radius:10px;
padding:5px;
}

input:hover{
background-color:gray;
transition:0.3s;
cursor:pointer;
transform:rotate(360deg);
}
		
		
</style>
		
		
		
	</head>
<body>

<div align="center">
	<table border="1">
		<tr>
			<td colspan="5" align="center">
			<input type="button" value="회원가입" onclick="location.href='user_insert_form.jsp'">
		</tr>
		
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>비고</th>
		</tr>
		
		<c:forEach var ="vo" items="${list}">
		<tr>
		 	<td>${vo.idx}</td>
		 	<td>${vo.name}</td>
		 	<td>${vo.id}</td>
		 	<td>${vo.pwd}</td>
		 	<td>
		 		<input type="button" value="삭제" onclick="del()">
		 	</td>
		 </tr>
	 	</c:forEach>
	 	
	</table>

</div>
</body>
</html>