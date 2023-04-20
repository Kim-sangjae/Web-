<%@page import="java.util.Date"%>
<%@page import="vo.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 출력형식에 대한 라이브러리 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%

List<String> array = new ArrayList<>();

array.add("서울");
array.add("대전");
array.add("대구");

request.setAttribute("array", array);

int n = 10;

request.setAttribute("n",n);




Person p1 = new Person();
p1.setName("홍길동");
p1.setAge(30);

Person p2 = new Person();
p2.setName("동길홍");
p2.setAge(33);


List<Person> list = new ArrayList<>();
list.add(p1);
list.add(p2);

request.setAttribute("list",list);


int money = 10000000;
request.setAttribute("money",money);

Date today = new Date();
request.setAttribute("today",today);



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSTL(Jsp Standard Tag Libary)
	c(Core) : if, choose, forEach와 같은 제어문을 사용할 수 있도록 해주는 라이브러리 -->
	
	<h2>조건문 c:if</h2>
	<c:if test="${n eq 10 }"> 참 </c:if>
	
	<hr>😊😊😊😊😊😊😊😊😊😊<hr>
	
	
	
	<h2>반복문 c:forEach</h2>
	
	<!-- for(int i = 1; i <= 5; i++{
	System.out.pringln("안녕" + i);
	} -->
	
	
	<!-- 반복문  var = 변수 , begin = 시작값 , end = 끝값 , step = 증가값 -->
	<c:forEach var="i" begin="1" end="5" step="1">
	${i}👀👀 ${i}<br></c:forEach>

	<br>
	
	<!-- for(String s : array){
	System.out.println(s);
	} -->

	<c:forEach var = "s" items="${array}">${s}<br></c:forEach>
	
	
	<hr>😊😊😊😊😊😊😊😊😊😊<hr>
	
	
	<h2>switch c:choose c:when</h2>
	<c:choose>
		<c:when test="${param.msg eq 10}">msg는 10이다.</c:when>	
		<c:when test="${param.msg eq 11}">msg는 11이다.</c:when>	
		<c:when test="${param.msg eq 12}">msg는 12이다.</c:when>
		<c:otherwise>모두 아니다</c:otherwise>	
	</c:choose>
	
	
	<hr>😊😊😊😊😊😊😊😊😊😊<hr>
	
	<c:forEach var="u" items="${list}">
		${u.name} :
		${u.age}
	</c:forEach>
	
	
	<hr>😊😊😊😊😊😊😊😊😊😊<hr>
	
	<h2>fmt라이브러리</h2>
	<fmt:formatNumber value="${money}"/><!-- 숫자를 단위별로 , 를 찍어줌 -->
	<br>
	<fmt:formatDate value="${today}"/>
	<br>
	<fmt:formatDate value="${today}" pattern=" yyyy년년 / MM월월 / dd일일 "/>
	

</body>
</html>