<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<title>getMemberList.jsp</title>
</head>
<body>
	<h1>학생 목록</h1>
	
	<c:forEach items = "${memberList}" var="member">
		${member.member_id} 
		<a href="getMember?member_id=${member.member_id}">${member.name}</a>
		${user.password} <br>
	</c:forEach>
	
</body>
</html>