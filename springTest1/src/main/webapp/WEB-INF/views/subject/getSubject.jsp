<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과목 상세</title>
<script>
$(document).ready(function(){ 
	$('#del').click(function() { 
		var result = confirm('정말로 삭제하시겠습니까?');
			if(result) { 
				location.replace('../deleteSubject?su_no=${su.su_no }'); 
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
					<h2>과목 상세</h2>
				</div>
				<div class="card-body">
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>과목명</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${su.subject}</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>과정명</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${su.class_name }</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>시간</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${su.totalTime}시간</p>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-md-3 col-form-label"><strong>사용 여부</strong></label>
						<div class="col-md-9">
							<p class="form-control-static">${su.status_yn }</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-body" align="right">
	<c:if test="${sessionScope.memberVO.member_cd=='M3'}">
		<input type="button" class="btn btn-warning" onclick="location.href='../updateSubjectForm?su_no=${su.su_no}'" value="수정" />&nbsp;
		<input type="button" class="btn btn-danger"  id="del" value="삭제" />&nbsp;
	</c:if>
		<input type="button" class="btn btn-secondary" onclick="location.href='../getSubjectList'" value="목록" />
	</div>
</body>
</html>