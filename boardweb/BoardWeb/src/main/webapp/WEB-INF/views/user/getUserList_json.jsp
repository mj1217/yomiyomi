<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script src="./scripts/jquery-3.3.1.min.js"></script>
<script src="./scripts/json.min.js"></script>
<script>
	$(function(){
		userList(); //목록조회
		userSelect(); //단건조회해서 프리폼?에 넣기
		userUpdate(); //수정처리
		userInsert();
	});
	//등록요청
	function userInsert(){
		$("#btnInsert").on('click', function(){
			$.ajax({
					url:"users",
					type:'post',
					contentType:'application/json;charset=utf-8',
					dataType:'json',
					data:JSON.stringify($("#form1").serializeObject()),
					success: function(response) {
			    		if(response.result == true) {userList();}
			 	 	  }
			      });
		});
	}
	
	//수정요청
	function userUpdate(){
		
		$("#btnUpdate").click(function(){
			var param = JSON.stringify($("#form1").serializeObject());
			$.ajax({
					url  : "./users",
					type : 'put',
					dataType : "json",
					data : param,
					contentType: 'application/json;charset=utf-8',
					success : function(){ userList(); }
					
				   });
		});
	}
	

	//단건조회요청
	function userSelect(){
		$("table").on("click","#btnSelect", function(){
			var id = $(this).closest('tr').find("#hidden_id").val();
			$.ajax({
					url  : "./users/" +id,
					type : 'get',
					dataType : "json",
					success : userSelectResult
			});
		});
	}
	
	//단건조회콜백
	function userSelectResult(datas){
		$("[name=id]").val(datas.data.id);
		$("[name=name]").val(datas.data.name);
		$("[name=role]").val(datas.data.role);
		$("[name=gender]").val([datas.data.gender]);
		
		
	}
	
	//사용자 목록 조회 요청
	function userList(){
		$.ajax({
				url  : "./users",
				type : 'get',
				dataType : "json",
				success : userListResult //콜백함수
			  });
	}
	
	//목록 조회 콜백
	function userListResult(datas){
		$("tbody").empty();
		$.each(datas.data, function(idx,item){
			$('<tr>')
			.append($('<td>').html(item.id))
			.append($('<td>').html(item.name))
			.append($('<td>').html(item.gender))
			.append($('<td>').html(item.role))
			.append($('<td>').html('<button id=\'btnSelect\'>조회</button>'))
			.append($('<td>').html('<button id=\'btnDelete\'>삭제</button>'))
			.append($('<input type=\'hidden\' id=\'hidden_id\'>').val(item.id))
			.appendTo('tbody');
		});//each
	}
	
</script>
</head>
<body>
<div class="container">
	<form id="form1"  class="form-horizontal">
		<h2>사용자 등록 및 수정</h2>
		<div class="form-group">		
			<label >아이디:</label>
			<input type="text"  class="form-control" name="id" >
		</div>	
		<div class="form-group">
			<label>이름:</label>
			<input type="text"  class="form-control"  name="name" >
		</div>	
		<div class="form-group">
			<label >성별:</label>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="남">남</label>
			</div>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="여">여</label>
			</div>	
		</div>	    
		<div class="form-group">   
			<label>롤:</label>
				<select class="form-control" name="role">
					   		<option value="Admin">관리자</option>
					   		<option value="User" selected>사용자</option>
				</select>
		</div>  
		<div class="btn-group">      
				<input type="button"  class="btn btn-primary" value="등록"  id="btnInsert" /> 
				<input type="button"  class="btn btn-primary" value="수정"  id="btnUpdate" />
				<input type="button"  class="btn btn-primary" value="초기화" id="btnInit" />
		</div>
	</form>
</div>		
<hr/>		
<div class="container">	
	<h2>사용자 목록</h2>
	<table class="table text-center">
		<thead>
		<tr>
			<th class="text-center">아이디</th>
			<th class="text-center">이름</th>
			<th class="text-center">성별</th>
			<th class="text-center">롤</th>
			<th class="text-center"> </th>
			<th class="text-center"> </th>
		</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>	


</body>
</html>