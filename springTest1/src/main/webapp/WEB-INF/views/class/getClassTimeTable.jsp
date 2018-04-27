<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정별 시간표</title>

</head>
<body>
	<div class="card" style="border: 30px solid white;">
		<div class="card-header">
			<h2>과정별 시간표</h2>
			<hr class="my-4">
				<p><%=request.getParameter("class_name") %></p>
			<div class="card-body" align="right">
				<input type="button" class="btn btn-secondary" onclick="location.href='./getClassList'" value="목록" />
				<form action="getClassTimeTable"></form>
			</div>
		</div>
		<div>
			<table class="table table-responsive-sm table-striped" style="width: 100%">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">날짜</th>
						<th scope="col">훈련시간</th>
						<th scope="col">과목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${timeTable }" var="tt">
						<tr>
							<td>${tt.t_id}</td>
							<td>${tt.s_date}</td>
							<td>${tt.classtime_cd}</td>
							<td>${tt.subject}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>