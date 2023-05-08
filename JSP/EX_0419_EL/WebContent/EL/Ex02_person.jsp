<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	Person vo = new Person();

	vo.setName("😜😎🤣😒😁");
	vo.setAge(30);
	
	request.setAttribute("vo",vo);
	
	
	
	Person vo2 = new Person();

	vo2.setName("👀👀👀👀👀👀👀👀👀👀");
	vo2.setAge(20);
	
	request.setAttribute("vo2",vo2);
	
	
	List<Person> list = new ArrayList<>();
	list.add(vo);
	list.add(vo2);
	
	
	request.setAttribute("list",list);

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- vo 객체에는 반드시 getter가 있어야 한다 -->
	
	이름 : ${vo.name}<br>
	나이 : ${vo.age}<br>
	
	<hr>
	
	List 에 객체 2개 담아서 쓴다<br>
	
	첫번째 객체 이름 : ${list[0].name} <br>
	첫번째 객체 나이 : ${list[0].age} <br>
	
	
	두번째 객체 이름 : ${list[1].name} <br>
	두번째 객체 나이 : ${list[1].age} <br>
	






</body>
</html>