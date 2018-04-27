<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>

<script>

	function formevent(){
		
		$("#loadingimg").show();
		document.sub2.submit();
		
	}

</script>


</head>
<body>
<%-- <form action="./insertTimeTableView">
<select name="sub_no" id="sub_no">
	<c:forEach items="${classList}" var="list">
		<option value="${list.cl_no}">${list.class_name}</option>
	</c:forEach>

</select>
<input type="submit" value="시간표등록"/>
</form> --%>
 <div class="card-header">
          <strong><h2>출석부 생성</h2></strong>
          
        </div>

<form action="./insertTimeTableView" method="post" enctype="multipart/form-data" id="sub2" name="sub2">


<div class="card-body">  
             <select name="sub_no" id="sub_no">
					<c:forEach items="${classList}" var="list">
					<option value="${list.cl_no}">${list.class_name}</option>
					</c:forEach>
			</select>
			<input type="file" class="btn btn-info" name="attach_file" /><br> 
           </div>

		<div class="card-footer">
          <button type="button" class="btn btn-sm btn-primary" onclick="formevent()"><i class="fa fa-dot-circle-o"></i>출석부생성</button>
        </div>
		<img src="resources/img/loading.gif" style="display:none; margin-left:550px" id="loadingimg" name="loadingimg">

		
</form>




<!-- <form action="insertExcel" method="post" enctype="multipart/form-data">
				<div class="col-md-3" align="center">
					<input type="file" class="btn btn-info" name="attach_file" />
				</div>
				<div class="col-md-1" align="center">
					<input type="submit" class="btn btn-warning" value="등록"/>
				</div>
				</form> -->





</body>
</html>