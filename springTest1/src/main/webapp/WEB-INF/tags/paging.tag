<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="paging" type="com.yedam.app.common.Paging" %>
<%@ attribute name="jsfunc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<ul class="pagination justify-content-center">
		<c:if test="${paging.startPage>1}">
			<li class="page-item">
			<a class="page-link" href="javascript:${jsfunc}(${paging.startPage-1})">이전</a>
		</c:if>
		
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i">
			<c:if test="${i != paging.page}">
				<li class="page-item"><a class="page-link" href="javascript:${jsfunc}(${i})">${i}</a></li>
			</c:if>
			<c:if test="${i == paging.page}">
				<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
			</c:if>
		</c:forEach>
		
		<c:if test="${paging.endPage<paging.totalPageCount}">
			<li class="page-item">
			<a class="page-link" href="javascript:${jsfunc}(${paging.endPage+1})">다음</a></li>
		</c:if>
	</ul>
