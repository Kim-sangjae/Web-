<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	/*
	EL식 : jsp에서 사용하는 표현식을 조금 더 간결하게 사용하기위한 표현식
	사용법 : ${key}
	
	범위 설정 (Scope)

	1) page Scope : 저장된 데이터를 현재 페이지에서만 공유하고 사용한다. (private 같은 느낌)
	
	2) request Scope : 지역개념으로 페이지가 닫히면 종료(가장 많이 사용)
		- 같은 request가면 두개의 페이지가 같은 요청을 공유할 수 있다
		- 따라서 request는 객체를 하나 또는 두개의 페이지 내에서 공유할 수 있다.
		
	3) session Scope : 전역의 개념
		- 톰캣이 실행될 때 자동으로 만들어지는 영역
		- session영역은 하나의 웹 브라우저당 1개의 session객체가 생성
		- 같은 웹 브라우저 내에서는 요청되는 페이지들은 같은 객체를 공유하게 된다.
		
	4) application Scope : 최소한 내가 만든 프로젝트 내의 모든 jsp에서 값을 공유하는게 가능
		- application 객체는 하나의 웹 어플리케이션당 1개의 객체가 생성된다.
		- 즉 , 같은 웹 어플리케이션에 요청되는 페이지들은 같은 객체를 공유한다

	*/

	String msg = "안녕";
	
	pageContext.setAttribute("key", "pageContext영역");
	
	request.setAttribute("key",msg);
	
	session.setAttribute("key", "세션에 저장됨");


	/*
	
	key가  같다면 좀더 세밀한(작은) 범위의 것이 호출된다
	
	1. pageContext
	2. request
	3. session
	4. application
	
	*/
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	EL표현식(파라미터) : ${param.name} <br>
	스크립트릿으로 출력하기 : <%=msg %> <br>
	EL 표현식(request Scope 데이터) : ${requestScope.key} <br>
	EL 표현식(생략) : ${key} <br>








</body>
</html>