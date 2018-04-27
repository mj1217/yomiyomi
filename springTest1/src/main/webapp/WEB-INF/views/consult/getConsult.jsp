<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
window.onload = function(){  //바디가 실행 되기 전에는 contents가 무엇인지 모르기 때문에 window.onload 써줌.
	CKEDITOR.replace("content", {
	    filebrowserUploadUrl:' ${pageContext.request.contextPath}/scripts/ckeditor/fileUpload.jsp',
	    customConfig:'${pageContext.request.contextPath}/scripts/ckeditor/config.js'
	});
}

</script>
<script src="${pageContext.request.contextPath}/scripts/ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h2>상담일지</h2>
		</div>
		<div class="card-body" style="border-bottom: :0px">
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">과정</label>
				<div class="col-md-9">
					${consult.c_name}
				</div>
			</div>
			<hr>
			
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">학생이름</label>
				<div class="col-md-9">
					${consult.s_name}
				</div>
			</div>
			<hr>
			
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">작성날짜</label>
				<div class="col-md-9">
					${consult.cdate}
				</div>
			</div>
			<hr>
			
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">작성자</label>
				<div class="col-md-9">
					${consult.c_writer}
				</div>
			</div>
			<hr>
			
			<div class="form-group row">
				<label class="col-md-3 col-form-label" for="select1">제목</label>
				<div class="col-md-9">
					${consult.title}
				</div>
			</div>
			<hr>

			
			<div class="form-group row">
	             <label class="col-md-3 col-form-label" for="textarea-input">내용</label>
	             <div class="col-md-9" style="border: 1px solid white; height:400px;">
	              ${consult.content}
	             </div>
	         
	             
	        </div>
	        
	        <div class="card-body" align="right" >
		          <a href="getConsultList" class="btn btn-secondary"> 목록</a>
		        <c:if test="${sessionScope.memberVO.member_id == consult.writer}">
		          <a href="updateConsultForm?c_no=${consult.c_no}" class="btn btn-warning">수정</a>
		          <a href="deleteConsult?c_no=${consult.c_no}" class="btn btn-danger">삭제</a>
		         </c:if>
 			 </div>
	        
		</div>
	</div>
</body>
