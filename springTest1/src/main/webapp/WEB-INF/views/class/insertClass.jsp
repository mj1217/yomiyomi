<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정 등록</title>
<script>

	// 등록 버튼 누를 시
    function insert(){
        alert("등록하시겠습니까?");
    }
    
	// 라디오버튼 숨기기
    function div_show(v,id){
    	if(v == "C2"){
    		document.getElementById(id).style.display = ""; //보여줌
    	} else {
    		document.getElementById(id).style.display = "none"; //숨김
    	}
    }
    
</script>

</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>과정 등록</h2>
		</div>
		<div class="card-body">
			<form action="insertClass" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="nf-email"><strong>과정명</strong></label>
					<input type="text" id="nf-email" name="class_name" class="form-control" value="과정명" onfocus="this.value=''"> 
					<span class="help-block">과정명을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>강의실</strong></label>
					<input type="text" id="nf-email" name="address" class="form-control" value="예)3" onfocus="this.value=''"> 
					<span class="help-block">강의실을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>총 수업시간</strong></label> 
					<input type="text" id="nf-email" name="totalTime" class="form-control" value="예)52" onfocus="this.value=''"> 
					<span class="help-block">총	수업시간을 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>총 수업일수</strong></label> 
					<input type="text" id="nf-email" name="totaldays" class="form-control" value="예)123" onfocus="this.value=''"> 
					<span class="help-block">총	수업일수를 입력하세요</span>
				</div>
				<div class="form-group">
					<label for="nf-email"><strong>과정 구분</strong></label>
						<div class="form-check">
							<input class="form-check-input" type="radio" value="C1" id="radio1" name="class_cd" onclick="div_show(this.value,'divshow');"> 
							<label class="form-check-label" for="radio1"> 과정평가반</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" value="C2" id="radio2" name="class_cd" onclick="div_show(this.value,'divshow');"> 
							<label class="form-check-label" for="radio2"> 단위기간평가반</label>
					</div>
				</div>
				<div class="form-group" id="divshow" style="display:none">
					<label class="nf-email" for="file-input"><strong>시간표 업로드</strong></label>
					<div class="col-md-10">
						<input type="file" id="attach_file" name="attach_file">
					</div>
				</div>
				<div class="card-body" align="right">
				<input type="submit" class="btn btn-info" value="등록" onclick="javascript:insert()"/>&nbsp; 
				<input type="button" class="btn btn-secondary" onclick="location.href='getClassList'" value="목록" />
				</div>
			</form>
		</div>
	</div>

</body>
</html>