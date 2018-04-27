<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
    
    
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>

<style>

	#sbtn{
		margin-left:-70px;
	}
	
	

</style>

<script>



	var context='${pageContext.request.contextPath}';

	
	function updateMember(member_id){
		var params = "member_id="+member_id;
		location.href=context+"/adminUpdateForm?"+params;
	}
	
	
	
function getMemberCS(member_id){
	
	var params = "m_memberid="+member_id;
	
	location.href=context+"/getConsultListSelect?"+params;
	
}
	

function getMemberAddList(){
	var params = {m_detail : $("#className").val() }
	
	if($("#className").val()=='all'){
		$.getJSON(context+"/getMemberAjaxAll", function(datas){
			$("#table").empty();
			for(i=0; i<datas.length;i++){
				$("#table").append("<tr><td>"+ datas[i].name + "</td>"
									+"<td>"+datas[i].class_name+"</td>"
									+"<td>" +datas[i].address+"</td>"
									+"<td>" +datas[i].status_cd+"</td>"
									+"<td><button type='button' class='btn btn-sm btn-primary' value='"+datas[i].member_id+"' onclick=\"updateMember('"+datas[i].member_id+"')\"><i class='fa fa-dot-circle-o'></i>정보수정</button></td>"
									+"<td><button type='button' class='btn btn-sm btn-primary' value='"+datas[i].member_id+"' id='sbtn'><i class='fa fa-dot-circle-o'></i>상담내용</button></td>");
			}
			
		})
	}else{
		$.getJSON(context+"/getMemberAjax",params, function(datas){
			$("#table").empty();
			for(i=0; i<datas.length;i++){
				$("#table").append("<tr><td>"+ datas[i].name + "</td>"
									+"<td>"+datas[i].class_name+"</td>"
									+"<td>" +datas[i].address+"</td>"
									+"<td>" +datas[i].status_cd+"</td>"
									+"<td><button type='button' class='btn btn-sm btn-primary' value='"+datas[i].member_id+"' onclick=\"updateMember('"+datas[i].member_id+"')\"><i class='fa fa-dot-circle-o'></i>정보수정</button></td>"
									+"<td><button type='button' class='btn btn-sm btn-primary' value='"+datas[i].member_id+"' id='sbtn' onclick='getMemberCS()'><i class='fa fa-dot-circle-o'></i>상담내용</button></td>");
			}
			
		})
	}
}

$(document).ready(function(){
	$("#btnPdf").click(function(){
		if($("[name='select1']").val() == "" || $("[name='select1']").val() == "all"){
			alert("과정을 선택하세요");
		} else{
			location.href='report.do?class_name=' + $("[name='select1']").val();	
		}
		
		
	})
})




</script>

</head>
<body>


<div class="card">
		<div class="card-header">
			<h2>학생조회</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			


			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">과정명</label>
				<div class="col-md-9">
					<select id="className" name="select1"  onchange="getMemberAddList()" class="form-control">
						<option value="">과정선택</option>
						<option value="all">모든과정</option>
						<c:forEach items="${classList}" var="cl">
						<option value="${cl.class_name}">${cl.class_name}</option>
						</c:forEach>	
						
					</select>
				</div>
			</div>
		
		
	
		
			<table class="table table-responsive-sm table-striped">
				<thead>
					<tr >
						<th>이름</th>
						<th>과정명</th>
						<th>강의장</th>
						<th>수료여부</th>
						<th><button type="button" class="btn btn-danger" id=btnPdf>
							pdf출력</button></th>
						<th></th>
					</tr>
				</thead>
				<tbody id="table">
					<c:forEach items="${memberAddList}" var="mem">
						<tr name="consultTable">
							<td>${mem.name}</td>
							<td>${mem.class_name}</td>
							<td>${mem.address}</td>
							<td>${mem.status_cd}</td>
							<td><button type="button" class="btn btn-sm btn-primary" value="${mem.member_id}" onclick="updateMember('${mem.member_id}')"><i class="fa fa-dot-circle-o"></i>정보수정</button></td>
							<td><button type="button" class="btn btn-sm btn-primary" value="${mem.member_id}" id="sbtn" onclick="getMemberCS('${mem.member_id}')"><i class="fa fa-dot-circle-o"></i>상담내용</button></td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>





</body>
</html>