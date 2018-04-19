<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>getUserList</title>
<script>
</script>
</head>
<body>
<h1>user 목록</h1>
<a href="./insertUserForm">등록 페이지로 이동</a><br>
<c:forEach items="${userList}" var="user">
	<a href="getUser?id=${user.id}">${user.id}</a> ${user.password} ${user.name} ${user.role} <br>
</c:forEach>

</body>
</html>