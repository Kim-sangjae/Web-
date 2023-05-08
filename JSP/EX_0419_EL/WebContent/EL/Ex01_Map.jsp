<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%

	Map<String, Integer> map = new HashMap<>();
	
	map.put("key1",100);
	map.put("key2",200);
	map.put("key3",300);
	map.put("key4",400);
	
	
	request.setAttribute("myMap",map);

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

map에 저장된 데이터 가져오기 <br>

${myMap.get("key1")} <br>
${myMap['key2']} <br>
${myMap["key3"]} <br>

${myMap.key4} <br>



</body>
</html>