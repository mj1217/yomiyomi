<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
	var context='${pageContext.request.contextPath}';
</script>

<script src="${pageContext.request.contextPath}/scripts/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/scripts/ckeditor/config.js"></script>
<script src="${pageContext.request.contextPath}/scripts/ckeditor/ko.js"></script>
<script>
function captureReturnKey(e) {
    if(e.keyCode==13 && e.srcElement.type != 'textarea')
    return false;
}
</script>
</head>

<body>
	<div class="card" style="border: 50px solid white;">
		<form action="updateNotice" method="post" enctype="multipart/form-data" onkeydown="return captureReturnKey(event)">
			<input type="hidden" name="n_no" value="${notice.n_no}" />
			<h2>게시글 수정</h2><br>
			<table class="table table-responsive-sm table-striped">
				<colgroup>
					<col width="33%">
				</colgroup>
				<tbody>
					<!-- 작성자 고정 -->
					<tr>
						<td>
							<div class="form-group row" >
								<label class="col-md-3 col-form-label" for="writer">작성자</label>
								<div class="col-md-9" >
									<input type="text" id="writer" name="writer" value="${notice.writer}" style="background-color:white;"
										class="form-control"  readonly /> 
								</div>
							</div>
						<td/>
					</tr>
					<!-- 제목 -->
					<tr>
						<td>
							<div class="form-group row">
								<label class="col-md-3 col-form-label" for="title">제목</label>
								<div class="col-md-9">
									<input type="text" id="title" name="title"
										class="form-control" value="${notice.title}"/>
								</div>
							</div>
						<td/>
					</tr>
					<!-- 파일업로드 -->
					<tr>
						<td>
							<div class="form-group row" >
								<label class="col-md-3 col-form-label" for="notice_file" >파일업로드</label>
								<div class="col-md-9">수정 전 파일 ${notice.filename}<br>
									<input type="file" id="notice_file" 
										name="notice_file" multiple>
								</div>
							</div>
						<td/>
					</tr>
					<!-- 내용 -->
					<tr>
						<td colspan="2" rowspan="2">
							<div class="form-group row">
								<label class="col-md-1 col-form-label" for="content">내용</label>
								<div class="col-md-9">
									<textarea id="content" name="content" rows="50" cols="10" 
										class="form-control">${notice.content}</textarea>
									<script>
							            CKEDITOR.replace( 'content', {
											filebrowserUploadUrl: '${pageContext.request.contextPath}/ckeditorfileupload/fileUpload.jsp'
														,height : '500px'
										}); 
							        </script>
								</div>
							</div>
						</td>
					</tr><tr></tr>
					<tr>
						<td>
							<div class="form-group">
								<label for="nf-email">필독여부</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="form-check-input" type="checkbox" value=1 id="priority_yn" name="priority_yn"
								<c:if test="${notice.priority_yn == 1}">checked="checked"</c:if>/>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div align="right">
				<input type="submit" value="등록" class="btn btn-info"/>
				<input type="reset" value="취소" class="btn btn-success" onclick="CKEDITOR.instances.content.setData('')"/>
				<input type="button" class="btn btn-secondary"  value="목록" onclick="location.href='./getNoticeList'" />
			</div>
		</form>
	</div>
</body>
</html>