<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과목 목록</title>
<style>
.search {
	width: 100px;
	font-size: 16px;
	color: gray;
	border: 1px solid gray;
	padding-top: 3px;
	padding-bottom: 3px;
}
</style>
<script>

$(function(){
	$("#searchCondition").val("${subjectVO.searchCondition}")
	
})

	function go_list(page) {
		document.getElementsByName("page")[0].value = page;
		document.subjectForm.submit();
	}
	
</script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>과목 목록</h2>
		<div class="card-body" align="right">
			<form action="getSubjectList" style="height: 15.96px;" name="subjectForm">
				<input type="hidden" name="page" value="${paging.page}" /> 
				<select name="searchCondition" id="searchCondition" class="search">
					<option value="">선택</option>
					<c:forEach items="${conditionMap}" var="option">
						<option value="${option.value}">${option.key}</option>
					</c:forEach>
				</select> <input type="text" name="searchKeyword" style="width: 160px;" value="${subjectVO.searchKeyword}"></input>
				<input type="submit" value="검색" class="btn btn-secondary" />
			</form>
		</div>
	</div>
</div>
		<table id="example" class="table table-responsive-sm table-striped"	style="width: 100%">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">과목명</th>
					<th scope="col">시간</th>
					<th scope="col">과정명</th>
					<th scope="col">사용여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${SubjectList }" var="su">
					<tr>
						<td scope="row">${su.su_no}</td>
						<td><a href="getSubject/${su.su_no}">${su.subject}</a></td>
						<td>${su.totalTime}시간</td>
						<td>${su.class_name}</td>
						<td>${su.status_yn}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<my:paging paging="${paging }" jsfunc="go_list" />
			<div class="card-body" align="right">
				<input type="button" class="btn btn-secondary" onclick="location.href='./getSubjectList'" value="목록" />
				<c:if test="${sessionScope.memberVO.member_cd=='M3'}">
					<input type="button" class="btn btn-info" onclick="location.href='insertSubjectForm'" value="등록" />
				</c:if>
			</div>
</body>
</html>