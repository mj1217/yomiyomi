<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>


<!DOCTYPE html>
<html>
<head><title>Insert title here</title>


<script>
	
var context='${pageContext.request.contextPath}';

function getAttList(cl_no){
	
	var params = "cl_no="+cl_no;
	
	location.href=context+"/getAttList?"+params;
	
}


</script>



</head>
<body>

<div class="card" style="margin-bottom:500px;">
		<div class="card-header">
			<h2>과목별 출석부 조회</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			

		
			<table class="table table-responsive-sm table-striped">
				<thead>
					<tr >
						<th>과정명</th>
						<th>총 수료시간</th>
						<th>총 일수</th>
						<th>강의장</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="table">
					<c:forEach items="${classAttList}" var="ca">
						<tr>
							<td>${ca.class_name}</td>
							<td>${ca.totalTime}시간</td>
							<td>${ca.totaldays}일</td>
							<td>${ca.address}</td>
							<td><button type="button" class="btn btn-sm btn-primary" onclick="getAttList('${ca.cl_no}')"><i class="fa fa-dot-circle-o"></i>출석부보기</button></td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>


</body>
</html>