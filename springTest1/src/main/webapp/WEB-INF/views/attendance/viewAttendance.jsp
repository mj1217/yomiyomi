<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<script>

var context='${pageContext.request.contextPath}';

function getUnit(){
	location.href="./getUnitList?class_no="+$("#selectStudent").val()
			
}

function formevent(){
	
	$("#loadingimg").show();
	document.sub2.submit();
	
}

</script>
</head>

<body>
	<div class="card" style="margin-bottom:500px;">
		<div class="card-header">
			<h2>출석부현황</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			
			<div class="form-group row">
				<label class="col-md-2 col-form-label" for="select1">과정</label>
				<div class="col-md-6">
				<form action="getUnit" method="post">
					<select id="selectStudent" name="class_no"  class="form-control" onchange="getUnit()">
						<option value="0">과정선택</option>
						<c:forEach items="${classList}" var="cl">
						<option value="${cl.cl_no}">${cl.class_name}</option>
						</c:forEach>					
					</select>
				</form>
				</div>
				<form action="insertExcel" method="post" enctype="multipart/form-data" id="sub2" name="sub2">
				<%-- <input type="hidden" name="class_no" value="${cl.cl_no}"/> --%>
				<div class="col-md-3" align="center">
					<input type="file" class="btn btn-info" name="attach_file" />
				</div>
				<div class="col-md-1" align="center">
					<input type="button" class="btn btn-warning" value="등록" onclick="formevent()"/>
					
				</div>
				</form>
		
			</div>
			<hr>
			<c:set value="" var="oldname"/>
			<c:set value="0" var="day"/>
			
			<table class="table table-bordered table-striped">
			<thead>
					<tr>
					<th rowspan="2" align="center">성명</th>
					<th rowspan="2" align="center">현재수업일수</th>
					<th rowspan="2" align="center">현재출석일수</th>
					<th rowspan="2" align="center">남은출석일수</th>
					<th rowspan="2" align="center">현재출석율</th>
					<th rowspan="2" align="center">남은결석일수</th>
					
					<!-- <th rowspan="2" align="center">지각/조퇴/결석</th> -->
					<c:forEach items="${SDATE}" var="unit">
					<th colspan="4">${unit.sdate}~${unit.edate} </th>
					</c:forEach> 
					</tr>
					<tr>
					<c:forEach items="${SDATE}" var="unit">
					<th>지각</th>
					<th>조퇴</th>								
					<th>외출</th>
					<th>결석</th>	
					</c:forEach>
					</tr>

			</thead>

			<tbody>
				 
	
				<c:forEach items="${unitList}" var="unit" varStatus="status">
					<c:set var="ind" value="${status.index/fn:length(SDATE)}"/>
					<fmt:parseNumber var="ind2" value="${ind}" integerOnly="true"/>
					<c:if test="${ oldname =='' || unit.student_name != oldname}">
						<tr>
						<td width="100px" align="center">${unit.student_name}</td>  <!-- 성명 -->
						<td>${attendDays.late}</td>									<!-- 현재수업일수 -->
						<td>${attendDays.late-unit.absence}</td>					<!-- 현재출석일수 -->
						<td>${classs.totalTime-attendDays.late}</td>				<!-- 남은출석일수 -->		
						<td><fmt:formatNumber value="${(attendDays.late-unit.absence)*100/classs.totalTime}" pattern=".00"/>%</td>	<!-- 현재출석율 -->
					
						
						<td>${absence.absenceDays-scores[ind2].score}</td>
						</c:if>
	
						<td>${unit.late}</td>
						<td>${unit.leave}</td>
						<td>${unit.goout}</td>
						<td>${unit.absence}</td>
					
				
					<c:set value="${unit.student_name}" var="oldname"/>
				</c:forEach> 
			</tr>
			</tbody>		
					
			
			</table>
			<img src="resources/img/loading.gif" style="display:none; margin-left:550px" id="loadingimg" name="loadingimg">
				
		</div>
	</div>
</body>
</html>