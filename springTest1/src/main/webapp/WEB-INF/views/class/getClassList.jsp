<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정 목록</title>
<script>
	function go_list(page) {
		document.getElementsByName("page")[0].value = page;
		document.classForm.submit();
	}
</script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>과정 목록</h2>
		</div>
		<div class="card-body">
			<form action="getClassList" name="classForm" style="margin-bottom:340px;">
				<input type="hidden" name="page" value="${paging.page}" /> <br>
				<table id="example" class="table table-responsive-sm table-striped" style="width: 100%">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">과정구분</th>
							<th scope="col">과정명</th>
							<th scope="col">강의실</th>
							<th scope="col">총수업시간</th>
							<th scope="col">총수업일수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${classList }" var="cl">
							<tr>
								<td scope="row">${cl.cl_no}</td>
								<td>${cl.class_nm}</td>
								<td><a href="getClass/${cl.cl_no }">${cl.class_name}</a></td>
								<td>${cl.address}강의실</td>
								<td>${cl.totalTime}시간</td>
								<td>${cl.totaldays}일</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			<my:paging paging="${paging }" jsfunc="go_list" />
			<div class="card-body" align="right">
			<c:if test="${sessionScope.memberVO.member_cd == 'M3'}">
				<input type="button" class="btn btn-info" onclick="location.href='insertClass'" value="등록" />
			</c:if>
			</div>
		</div>
	</div>
</body>
</html>