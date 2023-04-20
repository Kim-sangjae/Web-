<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Style>
table{
padding:5px;
border-color: black;
background-color:red;
border-spacing: 7px;
border-radius:20px;

}
tr{

background-color:black;
color:white;
font-weight:bold;


}
td{
padding:5px;
border-radius:20px;

}

td:hover{
 cursor:pointer;
 border: solid 1px white;
 background-color:gray;
 transform: rotate(1080deg);
 transition-duration:1s;
}

</Style>

</head>
<body>
<table border="1">
	
	<% for(int i = 1; i<=9; i ++){%>
		<tr>
		<%for(int j = 2; j<=9; j++){ %>
		
			<%-- <td><%=j%> x <%=i %> = <%=i*j %></td> --%>
			<td><%String str = String.format("%d x %d = %d",j,i,j*i);%><%=str %></td>
			
			
			
		<%}%>
		</tr>
	<%}%>
	
	

</table>

</body>
</html>