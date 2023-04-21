<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% 
	//db에서 과일목록을 가져왔다고 가정
	String[]fruit = {"사과","배","딸기","포도","복숭아","바나나","키위"};



%>   
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<% for(int i = 0; i < fruit.length; i++){%>
			<li><%=fruit[i] %></li>
		<%} %>
	</ul>

</body>
</html>