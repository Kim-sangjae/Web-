<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
// 자바코드 작성 태그
// 스크립틀릿(Scriptlet) : jsp에서 자바코드를 사용하기 위해 지정하는 영역
// request(요청객체),response(응답객체) 객체는
// jsp 가 web페이지로 전환되는 과정에서 만나는 Servlet클래스가 가진 객체이므로
// jsp에서는 Servlet클래스가 허용하는 범위안에서 객체를 마음대로 가져다 사용할 수 있다.

// JSP(Java Server Page) : 연산능력을 가지고 있는 html
// java 코드도 사용할 수 있고 자바스크립트를 사용하는데도 제한이 없다.


// jsp -> servlet -> web
// servelt : 자바에서 유일하게 웹을 만드는 기술이 담겨있는 클래스
// servelt : request 와 response 가 있다

	String ip = request.getRemoteAddr();

	Random rd = new Random();
	int rand = rd.nextInt(5)+1;

%>    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= ip %>
	<p>&lt;%@내용%&gt; : jsp헤더 - 실행시 인코딩,import등을 위해 반드시 지정해야하는 영역</p>
	<p>&lt;%자바코드%&gt; : 스크립트릿 - jsp에서 자바코드를 작성하기 위해 생성하는 영역</p>
	<p>&lt;%=변수명%&gt; : 스크립트릿의 출력코드(print) </p>
	난수 : <%=rand %>
</body>
</html>