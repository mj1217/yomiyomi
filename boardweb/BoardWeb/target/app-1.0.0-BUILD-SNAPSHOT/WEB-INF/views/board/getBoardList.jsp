<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
</script>
</head>
<body>
<h1>게시판 목록</h1>
<a href="./insertBoardForm">등록 페이지로 이동</a><br>
<c:forEach items="${boardList }" var="board">
	<a href="getBoard?seq=${board.seq}">${board.seq}</a> ${board.title} ${board.writer} ${board.regDate} ${board.content}<br>
</c:forEach>


</body>
</html>