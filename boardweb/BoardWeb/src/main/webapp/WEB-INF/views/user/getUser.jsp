<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
</script>
</head>
<body>
	<h1>회원조회</h1>
	id ${user.id}<br>
	password ${user.password}<br>
	이름 ${user.name}<br>
	등급 ${user.role}<br>
	<a href="updateUserForm?id=${user.id}">수정</a>
	<a href="deleteUser?id=${user.id}">삭제</a>
	<a href="getUserList">목록으로</a>
	
</body>
</html>