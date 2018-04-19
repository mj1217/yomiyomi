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
<form action ="../updateBoard">
	seq : <input type="text" name="seq" readonly="readonly" value="${board.seq}"><br>
	title : <input type="text" name="title" value="${board.title }"><br>
	writer : "${board.writer}"<br>
	content : <textarea rows="5" cols="40" name="content"> ${board.content }</textarea><br>
	<input type="submit" value="등록"/>
	
</form>
</body>
</html>