<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="updateSugt">    
<input type="hidden" name="s_no" value="${sugt.s_no}"/>
<div class="form-group row">

	<label class="col-md-3 col-form-label" for="input-normal">제목</label>
	<div class="col-md-9">
		<input type="text" id="input-normal" name="title"
			class="form-control" placeholder="Normal" value="${sugt.title}">
	</div>
</div>

<div class="form-group row">
	<label class="col-md-3 col-form-label" for="textarea-input">내용</label>
	<div class="col-md-9">
		<textarea id="textarea-input" name="content" rows="9"
			class="form-control" placeholder="Content..">${sugt.content}</textarea>
	</div>
</div>

<div align="right">작성일:${sugt.s_date} 조회수 : ${sugt.cnt}</div>


<div class="card-body" align="right">
	<input type="submit" class="btn btn-info" value="등록">
	<a href="getSugtList"><button type="button" class="btn btn-danger">취소</button></a>
</div>
</form>