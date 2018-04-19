<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
</script>
</head>
<body>
	<h1>게시글조회</h1>
	번호 ${board.seq}<br>
	작성자 ${board.writer}<br>
	작성일자 ${board.regDate}<br>
	작성제목 ${board.title}<br>
	작성내용 ${board.content}<br>
	<a href="updateBoardForm?seq=${board.seq}">수정</a>
	<a href="deleteBoard?seq=${board.seq}">삭제</a>
	<a href="getBoardList">목록으로</a>
	
</body>
</html>