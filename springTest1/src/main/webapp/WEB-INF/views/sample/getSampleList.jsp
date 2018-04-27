<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>


<c:forEach items="${sampleList}" var="sample">

<%-- 날짜 : ${sample.day}<br>
카드번호 : ${sample.card}<br>
이름 : ${sample.name}<br>
과정명 : ${sample.classs}<br>
시작 시간 : ${sample.start}<br>
종료 시간 : ${sample.end}<br>
입실 시간 : ${sample.in}<br>
퇴실 시간 : ${sample.out}<br>
=============================<br> --%>

날짜 : ${sample.s_date}<br>
과목: ${sample.subject}<br>
총시간 : ${sample.totaltime}<br>
시간표코드 : ${sample.classtime_cd}<br>
=============================<br>

</c:forEach>



</body>
</html>