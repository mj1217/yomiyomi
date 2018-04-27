<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>

<style>
#add{
	margin-left : 590px;
}

</style>

<script>

	$(function(){
		
		
	});

	function addstu(){
		var divclone = $("#copy").clone();
		
		divclone.appendTo("#copybody");
		$('[name=name]:last').val('');
		$('[name=social_number]:last').val('');
	}
</script>
</head>
<body>
	
        <div class="card-header">
          <strong>학생 등록</strong>
          
        </div>
        <form action="memberTestView" method="post" class="form-horizontal" >
        
          <div class="card-body">
                 <!--  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    	과정명선택
                  </button>
                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </div> -->
                  <select id="subject" name="subject">
                  	<option value="" selected="selected">과정선택</option>
                  <c:forEach items="${classList}" var="classs">
                  <option value="${classs.cl_no}">${classs.class_name}</option>
             
                  </c:forEach>
                  </select>
                  
                  <select id="subjectType" name="subjectType">
                  	<option value="" selected="selected">과정구분</option>
                  <c:forEach items="${CodeList}" var="codelist">
                  <option value="${codelist.code_no}">${codelist.code_name}</option>
             
                  </c:forEach>
                  </select>
                  
                  <button type="button" class="btn btn-sm btn-primary" id="add" onclick="addstu()"><i class="fa fa-dot-circle-o"></i>학생추가</button>
                
               <hr>
       <div id="copybody">  
           <div id="copy">
            <div class="form-group row"> 
              <label class="col-md-3 col-form-label" for="hf-email">이름</label>
              <div class="col-md-9">
                <input type="text" id="name" name="name" class="form-control" placeholder="이름">
                
              </div>
            </div>
            <div class="form-group row">
              <label class="col-md-3 col-form-label" for="hf-password">생년월일</label>
              <div class="col-md-9">
                <input type="text" id="social_number" name="social_number" class="form-control" placeholder="ex)920903">
                
              </div>
            </div>
          </div>
         </div>
       
        </div>
          <div class="card-footer">
          <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-dot-circle-o"></i>학생등록</button>
          <button type="reset" class="btn btn-sm btn-danger"><i class="fa fa-ban"></i>다시입력</button>
        </div>
       </form>


</body>
</html>
