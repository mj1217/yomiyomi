<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

	var context='${pageContext.request.contextPath}';
	
	function getStudent(){
		var params = {cl_no : $("#selectStudent").val() }
		$.getJSON(context+"/getStudentList",params, function(datas){
			$("#studentName option:gt(0)").remove();
			for(i=0; i<datas.length;i++){
				$("#studentName").append("<option value='"+datas[i].member_id+"'>"+datas[i].name+"</option>");
			}
		})
	}
	
	function getConsultAjax(){
		var params = {s_detail : $("#studentName").val() }
		$.getJSON(context+"/getConsultAjax",params, function(datas){
			$("#table").empty();
			for(i=0; i<datas.length;i++){
				$("#table").append("<tr><td>"+ datas[i].c_no + "</td>"
									+"<td><a href='getConsult?c_no=datas[i].c_no}'>"+datas[i].title+"</a></td>"
									+"<td>" +datas[i].s_name+"</td>"
									+"<td>" +datas[i].cdate+"</td>"
									+"<td>" +datas[i].c_name+"</td>"
									+"<td>" +datas[i].writer+"</td></tr>");
			}
			
		
		})
	
	}
</script>
<script src="${pageContext.request.contextPath}/scripts/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/scripts/ckeditor/ko.js"></script>
</head>
<body>

	<div class="card">
		<div class="card-header">
			<h2>상담일지</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			<form action="insertConsult" method="post">
				<input type="hidden" name="writer" value="${sessionScope.memberVO.member_id}"/>
				<div class="form-group row">
					<label class="col-md-3 col-form-label" for="select1">과정</label>
					<div class="col-md-9">
						<select id="selectStudent" name="cl_no"  onchange="getStudent()" class="form-control">
							<option value="0">과정선택</option>
							<c:forEach items="${classList}" var="cl">
							<option value="${cl.cl_no}">${cl.class_name}</option>
							</c:forEach>					
						</select>
					</div>
				</div>
			<hr> 
				
				<div class="form-group row">
					<label class="col-md-3 col-form-label" for="select1">학생이름</label>
					<div class="col-md-9">
						<select id="studentName" name="s_detail"  onchange="getConsultAjax()" class="form-control">
							<option value="">학생선택</option>
						</select>
					</div>
				</div>
			<hr>
				
				<div class="form-group row">
	              <label class="col-md-3 col-form-label" for="text-input">제목</label>
	              <div class="col-md-9">
	                <input type="text" id="text-input" name="title" class="form-control" placeholder="Text">
	              </div>
	             </div>
	        <hr>     
				<div class="form-group row">
	              <label class="col-md-3 col-form-label" for="textarea-input">내용</label>
	              <div class="col-md-9">
	                <textarea id="textarea-input" name="content" rows="9" class="form-control" placeholder="Content.."></textarea>
	             		<script>
				            CKEDITOR.replace( 'content', {
								filebrowserUploadUrl: './ckeditorfileupload/fileUpload.jsp',height : '500px'
							}); 
						 </script>
	              </div>
	            </div>
	        <hr>    
				<div class="card-body" align="right">
					<input type="submit" class="btn btn-info " value="등록"/>
					<input type="reset" value="취소" class="btn btn-success" onclick="CKEDITOR.instances.content.setData('')"/>
				</div>
		</form>
	</div>
	</div>
</body>
</html>