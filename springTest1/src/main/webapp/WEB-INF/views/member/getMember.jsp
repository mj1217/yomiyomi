<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<title>회원 상세</title>
</head>
<body>

${memberVO.member_id}

	<h1>학생 조회</h1>
	아이디 : ${member.member_id}<br>
	비밀번호 : ${member.pwd} <br>
	구분 : ${member.member_cd} <br>
	성명 : ${member.name} <br> 
	영문명 : ${member.eng_name} <br>
	주민등록번호 : ${member.social_number} <br>
	학 
	
	<a href="updateUserForm?id=${user.id}">수정</a>
	<a href="deleteUser?id=${user.id}">삭제</a>
</body>
</html>