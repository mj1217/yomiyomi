<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<script>
function go_list(page) {
	document.getElementsByName("page")[0].value = page;
	document.Form.submit();
}

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
									+"<td><a href=getConsult?c_no="+datas[i].c_no+">"+datas[i].title+"</a></td>"
									+"<td>" +datas[i].s_name+"</td>"
									+"<td>" +datas[i].cdate+"</td>"
									+"<td>" +datas[i].c_name+"</td>"
									+"<td>" +datas[i].c_writer+"</td></tr>");
			}
			
		})
	}
	
</script>
</head>
<body>
	<form action="getConsultList" name="Form">
	<input type="hidden" name="page" value="${paging.page}" />
	</form>
	<div class="card">
		<div class="card-header">
			<h2>상담일지</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">과정</label>
				<div class="col-md-9">
					<select id="selectStudent" name="select1"  onchange="getStudent()" class="form-control">
						<option value="0">과정선택</option>
						<c:forEach items="${classList}" var="cl">
						<option value="${cl.cl_no}">${cl.class_name}</option>
						</c:forEach>					
					</select>
				</div>
			</div>


			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">학생이름</label>
				<div class="col-md-9">
					<select id="studentName" name="select1"  onchange="getConsultAjax()" class="form-control">
						<option value="">학생선택</option>
					</select>
				</div>
			</div>
		
		
		<div class="card-body" align="right">
			<a href="getConsultList" class="btn btn-secondary"> 목록</a>
			<a href="insertConsultForm" class="btn btn-info">글쓰기</a>
		</div>
		
			<table class="table table-responsive-sm table-striped">
				<thead>
					<tr >
						<th>글번호</th>
						<th>제목</th>
						<th>학생이름</th>
						<th>작성일자</th>
						<th>과정번호</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody id="table">
					<c:forEach items="${consultList}" var="consult">
						<tr name="consultTable">
							<td>${consult.c_no}</td>
							<td><a href="getConsult?c_no=${consult.c_no}">${consult.title}</a></td>
							<td>${consult.s_name}</td>
							<td>${consult.cdate}</td>
							<td>${consult.c_name}</td>
							<td>${consult.c_writer}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
					  	<my:paging paging="${paging}" jsfunc="go_list" />
		</div>
	</div>
</body>
