<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
</script>
</head>
<body>
<h1>로그인</h1>
<form action ="login" >
	id : <input type="text" name="id" value="${user.id}"><br>
	password : <input type="text" name="password"><br>
	
<input type="submit" value="로그인"/>
	
</form>
</body>
</html>