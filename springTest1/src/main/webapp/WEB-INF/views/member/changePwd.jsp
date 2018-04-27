<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<title>changePwd 폼</title>

<script>
	function check_func() {
		//var member_id = document.getElementById("member_id").value;
		var pwd = document.getElementById("pwd").value;
		var pwd2 = document.getElementById("pwd2").value;
		var checkPwd2 = document.getElementById("checkPwd2").value;
		
		//현재 비밀번호 입력안했을 경우
		if (pwd == ""){
			alert("현재 비밀번호를 다시 입력하세요.");
			return false;
		//신규 비밀번호 입력안했을 경우
		}
		if (pwd2 == "") {
			alert("변경할 비밀번호를 다시 입력하세요.");
			return false;
		}
		//신규비밀번호와 신규비밀번호확인이 일치하지않을경우 / 성공
		if (pwd2 != checkPwd2) {
			alert("새로운 비밀번호가 일치하지 않습니다.");
			return false;
		} else{
			alert("비밀번호가 변경되었습니다.");
		}
		return true;
	}
</script>
</head>
<body class="app flex-row align-items-center">
	<%-- <h1>비밀번호 변경</h1>
	<br />
	<input type="hidden" id="member_id" name="member_id"
		value="${sessionScope.memberVO.member_id}">
	<br />
	<br /> 현재 비밀번호 :
	<input id="pwd" name="pwd">
	<br />
	<br /> 변경할 비밀번호 :
	<input id="pwd2" name="pwd2">
	<br />
	<br /> 변경할 비밀번호 확인 :
	<input id="checkPwd2" name="checkPwd2">
	<br />
	<br />
	<input type="submit" value="변경" />
	<br /> --%>

	<form action="changePwd" method="post" id="frm" name="frm"
		onsubmit="return check_func()">
		<input type="hidden" value="${sessionScope.memberVO.member_id }" name="member_id">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card-group">
						<div class="card p-4">
							<div class="card-body">
								<h1>비밀번호 변경</h1>
								<p class="text-muted">6자리 이상의 숫자와 문자를 입력하세요.</p>
								<div class="input-group mb-4">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="icon-user"></i></span>
									</div>
									<input type="password" id="pwd" class="form-control"
										placeholder="현재비밀번호" name="pwd">
								</div>
								<div class="input-group mb-4">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="icon-lock"></i></span>
									</div>
									<input type="password" id="pwd2" class="form-control"
										placeholder="새비밀번호" name="pwd2">
								</div>
								<div class="input-group mb-5">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="icon-lock"></i></span>
									</div>
									<input type="password" id="checkPwd2" class="form-control"
										placeholder="새비밀번호확인" name="Pwd2">
								</div>

								<div class="row">
									<div class="col-6">
										<input type="submit" id="changeBtn" 
											class="btn btn-primary px-4" value="변경"/>
										
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>	
	
	<!-- Bootstrap and necessary plugins -->
  <script src="../../node_modules/jquery/dist/jquery.min.js"></script>
  <script src="../../node_modules/popper.js/dist/umd/popper.min.js"></script>
  <script src="../../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
  
</body>
</html>