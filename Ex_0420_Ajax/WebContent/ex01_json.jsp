<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- JSON 표기법 
	서로 다른 프로그램에서 데이터를 교환히기 편하도록 규격화된 표기법-->    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// {'키' : '값'}
	// 값에 넣을수 있는 데이터
	// 숫자 : 정수, 실수, 지수 -> JSON 에서는 8진수나 16진수를 표현하는 법이 없다.
	// 문자열
	// 논리형 : true,false
	// 객체 
	// 배열
	// null
	
	var p = {'name':'홍길동','age':20,'tel':'010-1111-1111'};
	
	document.write("이름: "+ p.name + "<br>");
	document.write("나이: "+ p.age + "<br>");
	document.write("전화: "+ p.tel + "<br>");

	document.write("<hr>");
	
	//JSON 1차원 배열
	var p_arr = [
			{'name':'요요','age':32,'tel':'010-yyyy-yyyy'},
			{'name':'ㅎㅎ','age':27,'tel':'010-ㅎㅎㅎㅎ-ㅎㅎㅎㅎ'}
				]
	
	document.write(p_arr[0].name+ " / " + p_arr[0].age + "<br>");
	document.write(p_arr[1].name+ " / " + p_arr[1].age + "<br>");

	
	//JSON 다차원배열
	var course = {'name':'웹개발',
					'start' : '2023-02-13',
					'end' : '2030-07-07',
					'sub' : ['java','jsp','spring'],
					'student' : [{'name':'홍길동','age':20},{'name':'길길동','age':30}]}
	
	
	document.write("<hr>");
	
	document.write("과목명 : " + course.name +"<br>");
	document.write("시작일 : " + course.start +"<br>");
	document.write("종료일 : " + course.end +"<br>");
	document.write("과목 : " + course.sub[0] +","+ course.sub[1] + "," + course.sub[2] +"<br>");
	document.write("학생 : " + course.student[0].name +"," + course.student[0].age);
</script>
</head>
<body>

</body>
</html>