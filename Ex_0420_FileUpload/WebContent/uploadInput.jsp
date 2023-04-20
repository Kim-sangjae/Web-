<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function send(f){
	var title = f.title.value.trim();
	var photo = f.photo.value.trim();

if(title ==''){
	alert("제목을 입력하세요");
	return
}
if(photo == ''){
	alert("파일을 선택하세요");
	return
}
	//jsp에서는  java클래스를 호출할 수 없다.
	//대신 Sevlet에 요청할 수 있다
	
	f.action = "Upload.do";
	f.submit();
	
}


</script>
</head>
<body>
	<!-- 파일 업로드시 주의사항
		1) form태그의 전송방식은 반드시 post
		2) enctype="multipart/form-data 필수!
		3) enctype : form 태그의 파일 데이터를 전송할때 사용하는 인코딩 기법-->
	<form method="post" enctype="multipart/form-data">
		제목 : <input name="title"><br>
		첨부 : <input type="file" name="photo"><br>
		<!-- 웹에서 사용자의 로컬 파일을 입력받기 위해서 input태그의 타입의 속성으 file로 지정하는 방법을 사용한다 -->
		<input type="button" value="업로드" onclick="send(this.form)">
	
	
	</form>
</body>
</html>