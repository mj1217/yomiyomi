<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="card">
		<div class="card-header">
			<h2>건의사항</h2>
		</div>
	<div class="card-body" style="border-bottom: :0px">
		<form action="insertSugt" method="post">
		<input type="hidden" name="member_id" value="${sessionScope.memberVO.member_id}"/>
		<div class="form-group row">
	  		<label class="col-md-3 col-form-label" for="input-normal">제목</label>
	   		      <div class="col-md-9">
	        	        <input type="text" id="input-normal" name="title" class="form-control" placeholder="title.." value="${sugt.title}">
	              </div>
	   </div>
	
		<div class="form-group row">
			<label class="col-md-3 col-form-label" for="textarea-input">내용</label>
			<div class="col-md-9">
				<textarea id="textarea-input" name="content" rows="9" class="form-control" placeholder="Content..">${sugt.content}</textarea>
			</div>
		</div>
	
		<div class="card-body" align="right" >
	 
	        <a href="insertSugt" > <button type="submit" class="btn btn-info" >등록</button></a>
	        <a href="getSugtList" class ="btn btn-secondary">목록</a>
	        <button type="reset" class="btn btn-success" >취소</button>
	 	 </div>
	 	 </form>
	  </div>
	</div>