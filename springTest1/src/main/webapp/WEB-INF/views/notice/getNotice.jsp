<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>getNotice.jsp</title>
<script>
$(document).ready(function(){ 
	$('#del').click(function() { 
		var result = confirm('정말로 삭제하시겠습니까?');
			if(result) { 
				location.replace('./deleteNotice?n_no=${notice.n_no }'); 
			}
			else { 
				
			} 
	});
});

</script>
</head>
<body>
	<div class="card" style="border: 50px solid white;">
			<h2>공지사항</h2><br>
			<table class="table table-responsive-sm table-striped" >
				<colgroup>
					<col width="33%">
				</colgroup>
				<tbody style="border: 1px solid #A4A4A4;">
					<!-- 작성자 고정 -->
					<tr>
						<td>
							<div class="form-group row">
								<label class="col-md-3 col-form-label" style="padding-top:2px">작성자</label>
								<div class="col-md-9">
									<p class="form-control-static" style="margin-top:1px">${notice.writer}</p>
								</div>
							</div>
						<td/>
					</tr>
					<tr>
						<td>
							<div class="form-group row">
								<label class="col-md-3 col-form-label" for="writer" style="padding-top:2px">작성일</label>
								<div class="col-md-9">
									<p class="form-control-static" style="margin-top:1px"><fmt:formatDate pattern = "yyyy-MM-dd / HH:mm" value="${notice.ndate}" /></p>
								</div>
							</div>
						<td/>
					</tr>
					<!-- 제목 -->
					<tr>
						<td>
							<div class="form-group row">
								<label class="col-md-3 col-form-label" for="title" style="padding-top:2px">제목</label>
								<div class="col-md-9">
									<p class="form-control-static" style="margin-top:1px">${notice.title}</p>
								</div>
							</div>
						<td/>
					</tr>
				
					<!-- 내용 -->
					<tr>
						<td colspan="2" >
							<div class="form-group row" >
								
								<div class="col-md-9"style="border: 1px solid white; height:600px;">
								${notice.content}
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" >
							<div class="form-group row">
							<label class="col-md-3 col-form-label" for="filename" style="padding-top:2px">첨부파일</label>
								<div class="col-md-10">
									<c:if test="${not empty notice.filename}">
										<p class="form-control-static">
										${notice.filename}
										<button type="button" class="btn btn-link btn-lg" 
											onclick="location.href='./FileDown?attachField=${notice.filename}'">다운로드</button></p>
									</c:if>
									<c:if test="${empty notice.filename}">
										<p class="form-control-static" style="margin-bottom:3px;">첨부된 파일 없음</p>
									</c:if>
								</div>
							</div>
						</td>
					</tr>
					</tbody>
			</table>
			<div align="right">
			<c:if test="${sessionScope.memberVO.member_cd=='M3'}">
				<input type="button" class="btn btn-warning" value="수정" onclick="location.href='./updateNoticeForm?n_no=${notice.n_no}'"/>
				<input type="button" class="btn btn-danger"  value="삭제" id="del" />
				<input type="button" class="btn btn-secondary"  value="목록" onclick="location.href='./getNoticeList'" />
			</c:if>
			</div>
	</div>
</body>
</html>