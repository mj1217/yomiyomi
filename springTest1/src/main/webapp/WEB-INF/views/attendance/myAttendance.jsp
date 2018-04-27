<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<script>
</script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>단위출석률</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
		<table class="table table-bordered table-striped">
			<thead>
					<tr>
					<th rowspan="2" align="center">성명</th>
					<th rowspan="2" align="center">현재수업일수</th>
					<th rowspan="2" align="center">현재출석일수</th>
					<th rowspan="2" align="center">남은출석일수</th>
					<th rowspan="2" align="center">남은결석일수</th>
					<th rowspan="2" align="center">현재출석율</th>
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
				
				
						<tr>
					
						<td width="100px" align="center">${sessionScope.memberVO.name}</td><!-- 성명 -->
						<td>${attendDays.late}</td>									<!-- 현재수업일수 -->
						<td>${attendDays.late-unit.absence}</td>					<!-- 현재출석일수 -->
						<td>${classs.totalTime-attendDays.late}</td>				<!-- 남은출석일수 -->
					
						<td>${absence.absenceDays-scores.score} </td>							<!-- 남은결석일수 -->
						
						<td><fmt:formatNumber value="${(attendDays.late-unit.absence)*100/classs.totalTime}" pattern=".00"/>%</td>	<!-- 현재출석율 -->
					
				<c:forEach items="${unit2}" var="unit">
						
							<td>${unit.late}</td>
							<td>${unit.leave}</td>
							<td>${unit.goout}</td>
							<td>${unit.absence}</td>
						
				
				</c:forEach>
			</tr>
			</tbody>		
					
			
			</table>
		</div>
	</div>
</body>
</html>

	<c:if test="${sessionScope.memberVO.class_cd =='C1'}">
	<iframe src= "./getAttListMy"  style="width: 100%; height:800px; border:1px;"></iframe>
	</c:if>
	<%-- <%@include file="../att/getAttListMy.jsp"%> --%>