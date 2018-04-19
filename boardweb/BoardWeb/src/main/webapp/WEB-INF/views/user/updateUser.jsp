<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
</script>
</head>
<body>
<h1>회원수정</h1>
<form action ="updateUser">
	id : <input type="text" name="id" value="${user.id }" readonly="readonly"><br>
	password : <input type="text" name="password" value="${user.password }"><br>
	name : <input type="text" name="name" value="${user.name }"><br>
	role : <input type="text" name="role" value="${user.role }"><br>
	 
	<input type="submit" value="등록"/>
	
</form>
</body>
</html>