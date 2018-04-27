<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정 상세</title>
<script>
$(document).ready(function(){ 
	$('#del').click(function() { 
		var result = confirm('정말로 삭제하시겠습니까?');
			if(result) { 
				location.replace('../deleteClass?cl_no=${cl.cl_no }'); 
			} else { 
		} 
	});
});

</script>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h2>과정 상세</h2>
				</div>
				<div class="card-body">
				<form action="classname" method="get">
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>과정명</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${cl.class_name}</p>
						</div>
					</div>
					</form>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>강의실</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${cl.address}강의실</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>총 수업시간</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${cl.totalTime}시간</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>총 수업일수</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${cl.totaldays}일</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>과정 구분</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${cl.class_nm}</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>시간표</strong></label>
						<div class="col-md-9">
							<c:if test="${!empty cl.timeTable}">
								<p class="form-control-static">
								${cl.timeTable }
								<button type="button" class="btn btn-link" 
									onclick="location.href='../FileDown?attachField=${cl.timeTable }'">다운로드</button></p>
							</c:if>
							<c:if test="${empty cl.timeTable}">
								<c:if test="${cl.class_cd == 'C1'}">
								<button type="button"  class="btn btn-link" 
									onclick="location.href='${pageContext.request.contextPath}/getClassTimeTable?cl_no=${cl.cl_no}&class_name=${cl.class_name}'">
									과정별 시간표 바로가기</button>
								</c:if>
								<c:if test="${cl.class_cd == 'C2'}">
								<p class="form-control-static">첨부된 파일 없음</p>
								</c:if>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-body" align="right">
	<c:if test="${sessionScope.memberVO.member_cd=='M3'}">
		<input type="button" class="btn btn-warning" onclick="location.href='../updateClassForm?cl_no=${cl.cl_no}'" value="수정" />&nbsp;
		<input type="button" class="btn btn-danger" id="del" value="삭제" />&nbsp;
	</c:if>
		<input type="button" class="btn btn-secondary" onclick="location.href='../getClassList'" value="목록" />
	</div>
</body>
</html>