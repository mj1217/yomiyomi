<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<script>
$(function(){
	$("#searchCondition").val("${noticeVO.searchCondition}")
	
})

	function go_list(page) {
		document.getElementsByName("page")[0].value = page;
		document.noticeForm.submit();
	}
</script>
<style>
.search{
    width: 100px;
    font-size: 16px;
    color: gray;
    border: 1px solid gray;
    padding-top: 3px;
    padding-bottom: 3px;
} 

#pp{
 color: red;
}
</style>
</head>
<body>
	<div class="card" style="border:50px solid white;">
		<div class="card-header">
			<h2>공지사항</h2>
				<div  class="card-body" align="right">
					<form action="getNoticeList" name="noticeForm"  style="height:15.96px;">
							<input type="hidden" name="page" value="${paging.page}" />
							<select name="searchCondition" class="search">
								<option value="">선택</option> 
								<c:forEach items="${conditionMap}" var="option">
									<option value="${option.value}">${option.key}</option>		
								</c:forEach>
							</select>
							<input type="text" name="searchKeyword" style="width:160px;" value="${noticeVO.searchCondition}"></input>
							<input type="submit" value="Search" class="btn btn-secondary" />
					</form>
				</div>
		</div>
		<div> <!-- class="card" class="table table-responsive-sm table-striped" -->
			<table class="table table-responsive-sm table-striped">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:set var="vno" value="${paging.totalRecord-(paging.page-1)*10}"></c:set>
					<c:forEach items="${noticeList}" var="notice" varStatus="s">
						<tr>
							<td>${vno-s.index}</td>				
							<td><c:if test="${notice.priority_yn == 1}"><a id="pp">[필독]</a></c:if>
							<a href="getNotice?n_no=${notice.n_no}" style="color:;">
							${notice.title}</a></td>
							<td>${notice.writer}</td>
							<td><fmt:formatDate pattern = "yyyy-MM-dd"  value="${notice.ndate}" /></td>
							<td>${notice.viewcount}</td>
						</tr>
					</c:forEach>
			</table>
			<div class="card-body" align="right">
			<div align="left">
				 	<my:paging paging="${paging}" jsfunc="go_list"/>
				</div>
				<c:if test="${sessionScope.memberVO.member_cd=='M3'}">
				<input type="button" class="btn btn-info"  value="글쓰기" onclick="location.href='./insertNotice'" />
				<input type="button" class="btn btn-secondary"  value="목록" onclick="location.href='./getNoticeList'" />
				</c:if>
			</div>
		</div>
	</div>
</body>

	