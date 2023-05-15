<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.imagee{
	content: "";
  background-image: url(resources/비버2.png);
  position: absolute;
  width: 150px;
  height: 150px;
  top: 50%;
  right: 45%;
  background-size: cover;
  animation-name: updown;
  animation-duration: 1.2s;
  animation-iteration-count: infinite;
  transition: 1s;

        }
        
.imagee:hover{


transform:rotate(90deg);
  
}
        
        
 
 @keyframes updown{
      0%{

     }
     50%{
         transform: translateY(20px);
     }
     100%{

     }
  }       


</style>
</head>
<body>
	<h1 align="center" style="color:gray;">고객 테이블</h1>
	<div class="imagee"></div>
	<table border = "1" align="center" style="text-align:center;">
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
			<th>고객주소</th>
			<th>주민번호</th>
		</tr>
		<c:forEach var="g" items="${list}">
		<tr>
			<td>${g.gobun }</td>
			<td>${g.goname }</td> 
			<td>${g.goaddr }</td> 
			<td>${g.gojumin }</td>
			
		</tr>
		</c:forEach>
	</table>
</body>
</html>