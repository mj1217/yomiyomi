<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정 등록</title>
<script>
    function update(){
        alert("수정하시겠습니까?");
    }
    
    $(function(){
    	div_show("${cl.class_cd}","divshow");
    	
    })
    
    function div_show(s,ss){
    	if(s == "C2"){
    		document.getElementById(ss).style.display = "";
    	} else {
    		document.getElementById(ss).style.display = "none";
    	}
    }

</script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>과정 수정</h2>
		</div>
		<div class="card-body">
			<form action="updateClass" method="post" enctype="multipart/form-data">
				<input type="hidden" name="cl_no" value="${cl.cl_no}">
				<div class="form-group">
					<label for="nf-email"><strong>과정명</strong></label> 
					<input type="text" id="nf-email" name="class_name" class="form-control"	value="${cl.class_name }"> 
					<span class="help-block">수정할 과정명을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>강의실</strong></label>
					 <input	type="text" id="nf-email" name="address" class="form-control" value="${cl.address }"> 
					 <span class="help-block">수정할 강의실을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>총 수업시간</strong></label> 
					<input type="text" id="nf-email" name="totalTime" class="form-control" value="${cl.totalTime }"> 
						<span class="help-block">수정할	총 수업시간을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>총 수업일수</strong></label> 
					<input type="text" id="nf-email" name="totaldays" class="form-control" value="${cl.totalTime }"> 
						<span class="help-block">수정할	총 수업일수를 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>과정 구분</strong></label>
					<div class="form-check">
						<input type="radio" name="class_cd" id="radio1" value="C1" onclick="div_show(this.value,'divshow');"
							<c:if test="${cl.class_nm eq '과정평가반'}"> checked="checked" </c:if> />과정평가반
						<br> <input type="radio" name="class_cd" id="radio2" value="C2" onclick="div_show(this.value,'divshow');"
							<c:if test="${cl.class_nm eq '단위기간평가반'}"> checked="checked" </c:if> />단위기간평가반
					</div>
				</div>
				<div class="form-group" id="divshow" style="display:none" > 
					<label class="nf-email" for="file-input"><strong>시간표 수정</strong></label>
					<div class="col-md-10">
						<c:if test="${not empty cl.timeTable}">
							<label for="nf-email"><strong>기존 파일 : ${cl.timeTable }</strong></label><br>
						</c:if>
						<c:if test="${empty timeTable}">
							<input type="file" id="file-input" name="attach_file">
						</c:if>
					</div>
				</div>
				<div class="card-body" align="right">
					<input type="submit" class="btn btn-warning" value="수정" onclick="javascript:update()" />&nbsp; 
					<input type="button" class="btn btn-secondary" onclick="location.href='getClassList'" value="목록" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>