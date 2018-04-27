<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<title>관리자모드-학생정보수정 : 과정명 학생 선택</title>

<script>
	window.onload = function() {}

	var context = '${pageContext.request.contextPath}';

	function getStudent() {
		var params = {
			cl_no : $("#selectStudent").val()
		}
		$.getJSON(context + "/getStudentList", params, function(datas) {
			$("#studentName option:gt(0)").remove();
			for (i = 0; i < datas.length; i++) {
				$("#studentName").append("<option value='" + datas[i].member_id + "'>" + datas[i].name + "</option>");
			}
		})
	}

	function getConsultAjax() {
		var params = {
			s_detail : $("#studentName").val()
		}
		$.getJSON(context + "/getConsultAjax", params, function(datas) {
			$("#table").empty();
			for (i = 0; i < datas.length; i++) {
				$("#table").append("<tr><td>" + datas[i].c_no + "</td>"
					+ "<td><a href=getConsult?c_no=" + datas[i].c_no + ">" + datas[i].title + "</a></td>"
					+ "<td>" + datas[i].s_name + "</td>"
					+ "<td>" + datas[i].cdate + "</td>"
					+ "<td>" + datas[i].c_name + "</td>"
					+ "<td>" + datas[i].c_writer + "</td></tr>");
			}

		})
	}
</script>

</head>
<body>

	<div class="card">
		<div class="card-header">
			<h2>학생 정보</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">과정</label>
				<div class="col-md-9">
					<select id="selectStudent" name="select1" onchange="getStudent()"
						class="form-control">
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
					<select id="studentName" name="select1" onchange="getUpdateAjax()"
						class="form-control">
						<option value="">학생선택</option>
					</select>
				</div>
			</div>
			
			<div class="card-body">
				<button type="button" class="btn btn-danger" onclick="location.href='adminMemberUpdate'" >학생정보수정양식</button>
			</div>

			<tbody id="table">
				<c:forEach items="${consultList}" var="consult">
					<tr name="consultTable">
						<td>${consult.c_no}</td>
						<td><a href="getUpdate?c_no=${update.c_no}">${consult.title}</a></td>
						<td>${consult.s_name}</td>
						<td>${consult.cdate}</td>
						<td>${consult.c_name}</td>
						<td>${consult.c_writer}</td>
					</tr>
				</c:forEach>
			</tbody>

		</div>
	</div>
</body>
</html>