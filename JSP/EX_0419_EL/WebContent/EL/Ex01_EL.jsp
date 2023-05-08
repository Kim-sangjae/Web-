<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	EL산술연산자 <br>
	\${1+1} <br>
	\${1+1} = ${1+1} <br>
	\${1-1} = ${1-1} <br>
	\${1*1} = ${1*1} <br>
	\${10/3} = ${10/3} || div = ${10 div 3}<br>
	\${10%3} = ${10%3} || mod = ${10 mod 3}<br>
	
	
	<hr>😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎😎<hr>
	
	\${3>2} = ${3>2} || \${3 gt 2} = ${3 gt 2} <br>
	\${3<2} = ${3<2} || \${3 lt 2} = ${3 lt 2} <br>
	\${3>=2} = ${3>=2} || \${3 ge 2} = ${3 ge 2} <br>
	\${3<=2} = ${3<=2} || \${3 le 2} = ${3 le 2} <br>
	\${3==2} = ${3==2} || \${3 eq 2} = ${3 eq 2} <br>
	\${3!=2} = ${3!=2} || \${3 ne 2} = ${3 ne 2} <br>
	
	
	<hr>😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜<hr>
	
	EL삼항 연산자
	파라미터 값 : ${param.msg == null ? '비어있다' : '안비어있다'} <br>
	파라미터 값 : ${param.msg eq null ? '비어있다' : '안비어있다'} <br>
	파라미터 값 : ${empty param.msg ? '비어있다' : '안비어있다'} <br>
	
	
	<hr>😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜😜<hr>
	
	EL 논리연산자<br>
	파라미터값: ${empty param.abc || param.abc eq 10}<br>
	파라미터값: ${empty param.abc && param.abc eq 10}<br>
	
	
	
	 
</body>
</html>