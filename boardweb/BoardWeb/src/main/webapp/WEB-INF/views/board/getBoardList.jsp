<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
 
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<script>
function go_list(page){
	document.getElementsByName("page")[0].value=page;
	document.forms[0].submit();
	//location.href="getBoardList?page="+page;
}



</script>
</head>
<body>
<a href="<%=request.getAttribute("javax.servlet.forward.request_uri")%>?lang=ko"> 한글</a>
<a href="<%=request.getAttribute("javax.servlet.forward.request_uri") %>?lang=en"> 영어</a>

<h1><spring:message code="message.board.list.mainTitle"/></h1>
<a href="insertBoard">등록 페이지로 이동</a><br>

<a href="boardView.do">엑셀다운로드</a>

<!--  검색시작 -->
<form action="getBoardList" >
	<input type="hidden" name="page" value="1"/>
	<select name="searchCondition">
		<option value="">선택</option>
		
		<c:forEach items="${conditionMap}" var="option">
			<%-- <option value="${option.value}" 
				<c:if test="${option.value == boardVO.searchCondition}"> selected='selected' 
				</c:if> >  --%>
				<c:set var="sel" value=""/>
				<c:if test='${option.value==boardVO.searchCondition}'>
					<c:set var="sel" value="selected='selected'"/>
				</c:if>
			<option value="${option.value}" ${sel}> ${option.key}</option>		
		</c:forEach>
	</select>
	<input type="text" name="searchKeyword" value="${boardVO.searchKeyword}"/>
	<input type="submit" value="<spring:message code='message.board.list.search.condition.btn'/>"/>
</form><br>

<form action="deleteBoardList">
<input type="submit" value="<spring:message code='message.board.list.selDelet'/>" /><br>
<c:forEach items="${boardList }" var="board">
	<input type="checkbox" value="${board.seq}" name="seq"/>
	<a href="getBoard/${board.seq}">${board.seq}</a>
	
	 ${board.title} ${board.writer} ${board.regDate} ${board.content} ${board.uploadFileName}<br>
</c:forEach>
</form>
<my:paging paging="${paging}" jsfunc="go_list">
</my:paging>
</body>
</html>