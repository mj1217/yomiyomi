<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
function go_list(page){
	document.getElementsByName("page")[0].value=page;
	document.forms[0].submit();
	//location.href="getBoardList?page="+page;
}
</script>
</head>
<body>
<h1>게시판 목록</h1>
<!--  검색시작 -->
<form action="getEmpList">
	<input type="hidden" name="page" value="1"/>
	<select name="searchCondition">
		<option value="">선택</option>
		<c:forEach items="${conditionMap}" var="option">
			<c:set var="sel" value=""/>
				<c:if test='${option.value==employeeVO.searchCondition}'>
					<c:set var="sel" value="selected='selected'"/>
				</c:if>
			<option value="${option.value}" ${sel}> ${option.key}</option>		
		</c:forEach>
	</select>
	<input type="text" name="searchKeyword"/>
	<input type="submit" value="검색"/>
</form><br>

<c:forEach items="${empList }" var="emp">
	
 ${emp.employee_id} ${emp.first_name } ${emp.last_name} ${emp.salary}<br>
</c:forEach>


<my:paging paging="${paging}" jsfunc="go_list">
</my:paging>

</body>
</html>