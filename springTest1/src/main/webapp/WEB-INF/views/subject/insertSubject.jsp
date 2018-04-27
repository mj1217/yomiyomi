<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과목 등록</title>
<script>
    function insert(){
        alert("등록하시겠습니까?");
    }
    
$(function(){
		
		
	});

	function addsub(){
		var divclone = $("#copy").clone();
		divclone.appendTo("#copybody");
	}
</script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>과목 등록</h2>
		</div>
		<form action="insertSubject" method="post" class="form-horizontal">
		<div class="card-body" id="copybody">
			<div class="form-group row">
					<label class="col-md-3 col-form-label" for="select1"><strong>과정명</strong></label>
					<div class="col-md-12">
						<select id="select1" name="cl_no" class="form-control">
							<option value="" selected="selected">과정 선택</option>
							<c:forEach items="${ClassList }" var="cl">
							<option value="${cl.cl_no}">${cl.class_name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			
			<button type="button" class="btn btn-info" id="add" onclick="addsub()">
				과목 추가</button>
            <hr>
            
             <div id="copy">
				<div class="form-group">
					<label for="nf-email"><strong>과목명</strong></label> 
					<input type="text" id="nf-email" name="subject" class="form-control" value="과목명" onfocus="this.value=''"> 
					<span class="help-block">과목명을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>시간</strong></label> 
					<input type="text" id="nf-email" name="totalTime" class="form-control" value="예)10" onfocus="this.value=''"> 
					<span class="help-block">시간을 입력하세요</span>
				</div>
					<hr>
			</div>
		</div>
	</div>
			<div class="card-body" align="right">
				<input type="submit" class="btn btn-info" value="등록" onclick="javascript:insert()"/>&nbsp;
				<input type="reset" class="btn btn btn-danger" value="다시입력">
				<input type="button" class="btn btn-secondary" onclick="location.href='getSubjectList'" value="목록" />
			</div>
		</form>		
</body>
</html>