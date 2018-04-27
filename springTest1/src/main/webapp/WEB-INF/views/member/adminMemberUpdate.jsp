<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>관리자 모드 - 회원정보수정</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<script>
	$(function() {
		$('input:radio[value="${ members_VO.class_cd }"]').attr('checked', 'checked'); //과정구분
		$('input:radio[value="${ memberVO.open_route_cd }"]').attr('checked', 'checked'); //참여경로
		$("#datepicker").datepicker({
			showButtonPanel : true
		});
	});
</script>

</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h1>${sessionScope.memberVO.name} 님의 훈련 수강 신청서</h1>
				</div>

				<div class="card-body">
					<form action="memberUpdate" method="get">

						<input type="hidden" id=member_id name=member_id
							value="${sessionScope.memberVO.member_id}"> <input
							type="hidden" id=member_cd name=member_cd
							value="${sessionScope.memberVO.member_cd}">

						<div class="form-group">
							<label for="nf-email"><strong> 과정구분 </strong></label>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="C1" id="c1"
									name="mypage_c"> <label class="form-check-label"
									for="c1"> 과정평가반 </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="C2" id="c2"
									name="mypage_c"> <label class="form-check-label"
									for="c2"> 단위기간평가반</label>
							</div>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>모집구분</strong></label>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="R1" id="r1"
									name="mypage_r"> <label class="form-check-label"
									for="r1"> 내일배움카드</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="R2" id="r2"
									name="mypage_r"> <label class="form-check-label"
									for="r2"> 취업성공패키지</label>
							</div>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>과정명</strong></label> <input
								type="text" id="class_name" name="class_name"
								class="form-control" value="${sessionScope.memberVO.class_name}"
								readonly>
						</div>



						<div class="form-group">
							<label for="nf-email"><strong>영문명</strong></label> <input
								type="text" id="eng_name" name="eng_name" class="form-control"
								value="${sessionScope.memberVO.eng_name}"> 여권상의 영문명과 동일한
							영문명

						</div>

						<div class="form-group">
							<label for="nf-email"><strong>최종학력</strong></label> <input
								type="text" id="school_spec_cd" name="school_spec_cd"
								class="form-control"
								value="${sessionScope.memberVO.school_spec_cd}"> <span
								class="help-block">예)대졸/전문졸/고졸</span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>전공</strong></label> <input
								type="text" id="major" name="major" class="form-control"
								value="${sessionScope.memberVO.major}"> <span
								class="help-block"></span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>주민등록번호</strong></label> <input
								type="text" id="social_number" name="social_number"
								class="form-control"
								value="${sessionScope.memberVO.social_number}"> <span
								class="help-block">예)910808-2785623</span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>이메일</strong></label> <input
								type="text" id="email" name="email" class="form-control"
								value="${sessionScope.memberVO.email}"> <span
								class="help-block">예)abcde@gmail.com</span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>주소</strong></label> <input
								type="text" id="address" name="address" class="form-control"
								value="${sessionScope.memberVO.address}"> <span
								class="help-block"></span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>연락처</strong></label> <input
								type="text" id="phone" name="phone" class="form-control"
								placeholder="자택전화" value="${sessionScope.memberVO.phone}">
							<span class="help-block"></span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>휴대폰</strong></label> <input
								type="text" id="h_phone" name="h_phone" class="form-control"
								placeholder="휴대폰" value="${sessionScope.memberVO.h_phone}">
							<span class="help-block"></span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>훈련참여경로(택1)</strong></label>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="O1"
									id="open_route_cd01" name="open_route_cd"> <label
									class="form-check-label" for="open_route_cd01"> 인터넷검색</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="O2"
									id="open_route_cd02" name="open_route_cd"> <label
									class="form-check-label" for="open_route_cd02"> 현수막</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="O3"
									id="open_route_cd03" name="open_route_cd"> <label
									class="form-check-label" for="open_route_cd03"> 고용지원센터</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="O4"
									id="open_route_cd04" name="open_route_cd"> <label
									class="form-check-label" for="open_route_cd04"> 지인권유</label>
							</div>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>훈련참여경로 기타</strong></label> <input
								type="text" id="open_route_etc" name="open_route_etc"
								class="form-control" placeholder="이밖의 훈련참여경로가 있으시다면 적으세요"
								onfocus="this.value=''"> <span class="help-block"></span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>실업급여 수급 여부</strong></label>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="U1" id="u1"
									name="unemployee_pay_yn"> <label
									class="form-check-label" for="u1"> 수급 </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="U2" id="u2"
									name="unemployee_pay_yn"> <label
									class="form-check-label" for="u2"> 미수급</label>
							</div>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>이직 전 직장명</strong></label> <input
								type="text" id="previous_job" name="previous_job"
								class="form-control" placeholder="최종 근무지명을 적으세요"
								onfocus="this.value=''"> <span class="help-block"></span>
						</div>

						<div class="form-group">
							<label for="nf-email"><strong>이직 일자</strong></label> <input
								type="date" id="job_change_date" name="job_change_date"
								class="form-control" placeholder="최종 퇴사일을 적으세요"
								value="${sessionScope.memberVO.job_change_date}"> <span
								class="help-block"></span>
						</div>


						<div class="form-group">
							<label for="nf-email"><strong>보훈대상자</strong></label>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="B1" id="b1"
									name="bohun_yn"> <label class="form-check-label"
									for="b1"> 보훈 해당(보훈대상자 월 4만원 지급, 3개월에 한번씩) </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" value="B2" id="b2"
									name="bohun_yn"> <label class="form-check-label"
									for="b2"> 해당없음 </label>
							</div>
							<br>
							<br>
							<br>
							<br>

							<p>
								위 본인은 귀 교육원 및 노동부 관련규정을 준수하고, 훈련생으로서 본분을 다할 것을 서약하며 상기와 같이
								신청합니다.<br>
								<br>
								<br> 날짜를 선택하세요-> <input type="text" id="datepicker"><br>
								<br>
								<br> 신청인  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(서명 또는 인)
							</p>
							<br>
							<br>

							<div class="card-body">
								<input type="submit" class="btn btn-info" value="수정" /><br><br>
							</div>

							<div class="card-body">
								<button type="button" class="btn btn-secondary" onclick="location.href='find_pwd'">비밀번호 찾기</button>
								<button type="button" class="btn btn-success" onclick="location.href='changePwdForm'">비밀번호 변경</button>
								<button type="button" class="btn btn-info" onclick="location.href=''" value="출석률 보기">출석률 보기</button>
								<button type="button" class="btn btn-warning" onclick="location.href=''" value="시간표 보기">시간표 보기</button>
								<button type="button" class="btn btn-danger" onclick="location.href=''" value="휴가 신청">휴가 신청</button>
								<button type="button" class="btn btn-danger" onclick="location.href='adminMemberUpdateForm'" value="PDF 출력">PDF 출력</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>