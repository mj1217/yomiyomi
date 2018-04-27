<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 시간표</title>
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
    
</head>
<body>
	<c:if test="${courseType[0].CLASS_CD == 'C1'}">
		<div class="card" style="border: 50px solid white; margin-bottom:450px;">
			<div class="card-header">
				<h2>나의 시간표</h2>
				<hr class="my-4">
				<p>${courseType[0].CLASS_NAME } &nbsp; | &nbsp; ${courseType[0].TOTALTIME }시간</p>
				<div class="card-body" align="right">
					<form action="getTimeTableList"></form>
				</div>
			</div>
			<div>
				<table class="table table-responsive-sm table-striped" style="width: 100%">
					<thead>
						<tr>
							<th>번호</th>
							<th>날짜</th>
							<th>훈련시간</th>
							<th>과목</th>
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
		</c:if>

	<c:if test="${courseType[0].CLASS_CD != 'C1'}">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<h2>나의 시간표</h2>
					</div>
					<div class="card-body">
						<div class="form-group">
							<div class="col-md-9">
								단위기간평가반 시간표는 과정 상세 페이지에서 볼 수 있습니다.
								<button type="button" class="btn btn-link btn-lg" 
									onclick="location.href='./getClassList'">바로가기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</c:if>
	
</body>
</html>