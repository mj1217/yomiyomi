<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="sidebar-nav">
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/getSchedulers">
		<i class="icon-speedometers"></i> 홈</a>
		</li>

		<li class="nav-title">예담</li>
		<li class="nav-item"><a href="${pageContext.request.contextPath}/getNoticeList"
			class="nav-link"><i class="icon-drops"></i>공지사항</a></li>
			
	<c:if test="${sessionScope.memberVO.member_cd !='M3'}">
		<li class="nav-item nav-dropdown">
				<a class="nav-link nav-dropdown-toggle" href="#">
					<i class="icon-cursors"></i>예담 수업</a>
					
				<ul class="nav-dropdown-items">
					<li class="nav-item" >
						<a class="nav-link"  href="${pageContext.request.contextPath}/getClassList">
						<i class="icon-cursors" id="sub"></i>과정</a></li>
					<li class="nav-item" >
						<a class="nav-link" href="${pageContext.request.contextPath}/getSubjectList">
						<i class="icon-cursors" id="sub"></i>과목</a></li>
				</ul>
		</li>
	</c:if>
		<!------------ 회원 ------------>
		<c:if test="${sessionScope.memberVO.member_cd=='M1'}">
			<li class="nav-title">${sessionScope.memberVO.name}회원님</li>
			<li class="nav-item nav-dropdown"><a
				class="nav-link nav-dropdown-toggle" href="#"><i
					class="icon-puzzles"></i>마이페이지</a>
			
				<ul class="nav-dropdown-items">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/memberUpdateForm"><i
							class="icon-puzzles" id="sub"></i>회원정보수정</a></li>
							
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getTimeTableList"><i
							class="icon-puzzles" id="sub"></i>나의 시간표</a></li>
							
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getUnit">
						<i class="icon-puzzles" id="sub"></i>나의 출석률</a></li>
						
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getSugtList"><i
							class="icon-calculators" id="sub"></i>건의하기 <span
							class="badge badge-primary">NEW</span></a></li>
				</ul>
			</li>
		</c:if>	
		<!------------ 관리자 ------------>
		<c:if test="${sessionScope.memberVO.member_cd=='M2' or sessionScope.memberVO.member_cd=='M3'}">
			<li class="nav-title">${sessionScope.memberVO.name}관리자님</li>

			<li class="nav-item nav-dropdown"><a
				class="nav-link nav-dropdown-toggle" href="#"><i
					class="icon-cursors"></i>과정</a>
				<ul class="nav-dropdown-items">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getClassList"><i
							class="icon-cursors" id="sub"></i>과정관리</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getSubjectList"><i
							class="icon-cursors" id="sub"></i>과목관리</a></li>
					<%-- <li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/insertTimeTableForm"><i
							class="icon-cursors" id="sub"></i>시간표등록</a></li> --%>
				</ul>
 
 			<li class="nav-item nav-dropdown"><a
				class="nav-link nav-dropdown-toggle" href="#"><i
					class="icon-stars" ></i>학생관리</a>
				<ul class="nav-dropdown-items">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/insertMemberForm"
						><i class="icon-cursors" id="sub"></i>학생등록</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/viewMember" ><i
							class="icon-cursors" id="sub"></i>학생조회</a></li>
					
				</ul></li>
 
			<li class="nav-item nav-dropdown"><a
				class="nav-link nav-dropdown-toggle" href="#"><i
					class="icon-cursors"></i>출결</a>
				<ul class="nav-dropdown-items">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/insertAttendanceForm"> <i class="icon-cursors" id="sub"></i>단위출석부생성
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/insertTimeTableForm"> <i class="icon-cursors" id="sub"></i>과목출석부생성
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getUnitList"> <i class="icon-cursors" id="sub"></i>단위출석현황
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/getClassAtt"> <i
							class="icon-cursors" id="sub"></i>과목출석현황
					</a></li>
				</ul>
			</li>
			
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/getConsultList"><i
					class="icon-calculators"></i>상담일지</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/getSugtList"><i
					class="icon-calculators"></i>건의사항</a>
			</li>
		</c:if>
	

</nav>
<button class="sidebar-minimizer brand-minimizer" type="button"></button>
<style>
#sub {
	margin-left: 25px;
}
</style>


<script>




$.navigation = $('nav > ul.nav');
// Add class .active to current link
$.navigation.find('a').each(function(){

  var cUrl = String(window.location).split('?')[0];

  if (cUrl.substr(cUrl.length - 1) == '#') {
    cUrl = cUrl.slice(0,-1);
  }

  if ($($(this))[0].href==cUrl) {
    $(this).addClass('active');

    $(this).parents('ul').add(this).each(function(){
      $(this).parent().addClass('open');
    });
  }
});

// Dropdown Menu
$.navigation.on('click', 'a', function(e){

  if ($.ajaxLoad) {
    e.preventDefault();
  }

  if ($(this).hasClass('nav-dropdown-toggle')) {
    $(this).parent().toggleClass('open');
    resizeBroadcast();
  }

});
</script>