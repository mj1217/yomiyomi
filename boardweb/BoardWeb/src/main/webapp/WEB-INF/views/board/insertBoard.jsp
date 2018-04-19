<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
</script>
</head>
<body>
<h1>게시글 등록</h1>
<form action ="insertBoard" method="post" enctype="multipart/form-data">

	title : <input type="text" name="title"><br>
	writer : <input type="text" name="writer"><br>
	attatch : <input type="file" name="uploadFile"><br>
	content : <textarea rows="5" cols="40" name="content"></textarea><br>
	<input type="submit" value="등록"/>
	
</form>
</body>
</html>