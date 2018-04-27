<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과목 수정</title>
<script>
    function update(){
        alert("수정하시겠습니까?");
    }
  
</script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>과목 수정</h2>
		</div>
		<div class="card-body">
			<form action="updateSubject" method="post">
			<input type="hidden" name="su_no" value="${su.su_no }">
				<div class="form-group row">
					<label class="col-md-3 col-form-label" for="select1"><strong>과정명</strong></label>
					<div class="col-md-12">
					<c:if test="${!empty ClassList}">
						<select id="select1" name="class_name" class="form-control" disabled="disabled">
							<option value="">수정할 과정명을 선택하세요</option>
							<c:forEach items="${ClassList }" var="cl">
							<option value="${cl.cl_no}" 
								<c:if test="${cl.class_name eq su.class_name}"> selected="selected" </c:if>>
								${cl.class_name }</option>
							</c:forEach>
						</select>
					</c:if>
					</div>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>과목명</strong></label> 
					<input type="text" id="nf-email" name="subject" class="form-control" value="${su.subject }"> 
					<span class="help-block">수정할 과목명을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>시간</strong></label> 
					<input type="text" id="nf-email" name="totalTime" class="form-control" value="${su.totalTime }"> 
					<span class="help-block">수정할 시간을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>사용여부</strong></label>
						<div class="form-check">
							<input type="radio" name="status_yn" id = "radio1" value="Y"  
								<c:if test="${su.status_yn eq 'Y'}"> checked="checked" </c:if>/>YES
							<br>
							<input type="radio" name="status_yn" id = "radio2" value="N" 
								<c:if test="${su.status_yn eq 'N'}"> checked="checked" </c:if>/>NO
					</div>
				</div>
				<div class="card-body" align="right">
				<input type="submit" class="btn btn-warning" value="수정" onclick="javascript:update()"/>&nbsp; 
				<input type="button" class="btn btn-secondary" onclick="location.href='getSubjectList'" value="목록" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>