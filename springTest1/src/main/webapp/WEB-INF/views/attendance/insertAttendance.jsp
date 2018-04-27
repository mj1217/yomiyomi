<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
	
	var context='${pageContext.request.contextPath}';
	
	$(function() {
		  $("#sdatepicker0").datepicker({
			  dateFormat: "yymmdd"
		  });
			  
		  $("#edatepicker0").datepicker({
			 	dateFormat:"yymmdd"
			  });
		 });

	
	var i = 0; //id 인덱스
	var x=0;
	
	function addCard(){
		var unitcard = $("#unitcard"+i);		//복사할 div 고르기
		var unitcard2 = unitcard.clone(); 		//div 복사 
	 
		x= i+1;
		unitcard2.attr('id',"unitcard"+x);
		
		unitcard2.appendTo("#unitcardparent"); //div 추가		
		
		unitcard2.find("#unit"+i).attr('id','unit'+x);
		unitcard2.find("#unit"+x).val(x+1);
		unitcard2.find("#sdatepicker"+i).attr('id',"sdatepicker"+x);
		unitcard2.find("#edatepicker"+i).attr('id',"edatepicker"+x); 
		unitcard2.find("#unitdays"+i).attr('id',"unitdays"+x); 
		
		$("#sdatepicker"+x).removeClass('hasDatepicker').datepicker({dateFormat:"yymmdd"});
		$("#edatepicker"+x).removeClass('hasDatepicker').datepicker({dateFormat:"yymmdd"});

		$('[name=sdate]:last').val('');
	    $('[name=edate]:last').val('');
	    $('[name=unitdays]:last').val('');
		i++;
	}
	
	function removeCard(){
		var last = $("#unitcard"+x);
		last.remove();	
	};
	
	
	function check(){
		
		var item3 = "";
		var total =0;
		var totalS ="";
		for(var x=0; x<=i; x++){
			item3 += $("#unit"+x).val()+"단위기간 "+$("#sdatepicker"+x).val()+" ~ "+$("#edatepicker"+x).val()+"\n";
			total = total + parseInt($("#unitdays"+x).val());
		}
		totalS = "총 수업일수 :"+total;
		var check = confirm("과정명 : "+ $("#selectStudent option:selected").text()+"\n"+item3+totalS);
		
		if(check){
			document.insert.submit();
		}else
			return false;
	
		
		
	};
	
	
</script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>

</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>출석부생성</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			<form action="insertUnit" method="post" id="insert" name="insert" style="margin-bottom:220px;">
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">과정</label>
				<div class="col-md-9">
					<select id="selectStudent" name="class_no"  class="form-control">
						<option value="0" selected="selected">과정선택</option>
						<c:forEach items="${classList}" var="cl">
						<option  id="op${cl.cl_no}" value="${cl.cl_no}" >${cl.class_name}</option>
						</c:forEach>					
					</select>
				</div>
			</div>
			
		<hr></hr>
		
			<div class="card" id="unitcardparent">
				<div class="card-body" align="right" >
       		   		<input type="button" class="btn btn-info" onclick="addCard()" value="추가"/>
        		 	<input type="button" class="btn btn-danger" onclick="removeCard()" value="삭제"/>
 				</div>

				<!-- -------------------------------------------추가부분------------------------------------------------- -->
				<div class="card-body" id="unitcard0" style="border: 1px solid lightgray:border-bottom:0px">
					<hr></hr>	
					<div class="form-group row">
						<label class="col-md-3 col-form-label" for="select1">단위번호</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="unit" value="1" id="unit0" >
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-3 col-form-label" for="select1">단위시작일</label>
						<div class='col-sm-3'>
								<div class='input-group date' >
									<input readonly="readonly" type='text' class="form-control" name="sdate"  id="sdatepicker0" /> 
									<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
						</div>
					
						<label class="col-md-3 col-form-label" for="select1">단위마지막일</label>
						<div class='col-sm-3'>
								<div class='input-group date' id='datetimepicker1'>
									<input readonly="readonly" type='text' class="form-control" name="edate" id="edatepicker0" /> 
									<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-md-3 col-form-label" for="select1">수업일수</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="unitdays0" name="unitdays" placeholder="수업일수..">
						</div>
					</div>
				
				</div>
				<!-- -------------------------------------------------------------------------------------------- -->
				
			</div>
			
			<div class="card-body" align="right" >
			<input type="button" class="btn btn-info" value="등록"  onclick="check()"/>
          	<input type="reset" class="btn btn-danger" value="취소"/>
 	 		</div>






		</form>
		</div>
</div>
			
			
</body>
</html>



