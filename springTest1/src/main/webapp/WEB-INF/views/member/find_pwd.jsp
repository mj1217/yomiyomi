<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<title>비밀번호 찾기</title>

<script>
$(document).ready(function(){
    $("#findBtn").click(function(){
        // 태크.val() : 태그에 입력된 값
        // 태크.val("값") : 태그의 값을 변경 
        var member_id = $("#member_id").val();
        var email = $("#email").val();
        
        if(member_id == ""){
            alert("아이디를 입력하세요.");
            $("#member_id").focus(); // 입력포커스 이동
            return false; // 함수 종료
        }
        if(email == ""){
            alert("임시 비밀번호를 발급받을 이메일을 입력하세요.");
            $("#email").focus();
            return false;
        }
       
        // 제출
        document.form1.submit();
    });
});
</script>

</head>
<body>
<form action="mailSend" name="form1">
	<!-- <div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호 찾기</h3>
			</div>
			<div>
				<p>
					<label>아이디</label>
					<input class="w3-input" type="text" id="member_id" name="member_id" required>
				</p>
				<p>
					<label>Email</label>
					<input class="w3-input" type="text" id="email" name="email" required>
				</p>
				<p class="w3-center">
					<button type="button" id=findBtn class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">find</button>
					<button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">Cancel</button>
				</p>
			</div>
		</div>
	</div> -->
	<div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card-group">
          <div class="card p-4">
            <div class="card-body">
              <h1>비밀번호 찾기</h1>
              <p class="text-muted">임시 비밀번호는 가입시 작성하신 이메일로 발송됩니다.</p>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="icon-user"></i></span>
                </div>
                <input type="text" id="member_id" class="form-control" placeholder="아이디" name="member_id" >
              </div>
              <div class="input-group mb-4">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="icon-lock"></i></span>
                </div>
                <input type="text" id="email" class="form-control" placeholder="email" name="email">
              </div>
              <div class="row">
                <div class="col-6">
                  <input type="submit" id="findBtn" class="btn btn-primary px-4" value="발송"> </button>
                </div>
                <div class="col-6 text-right">
                  <button type="button" id="cancleBtn" class="btn btn-primary px-4" value="Forgot password?" onclick="location.href='/app'">취소</button>  
                </div>
              </div>
            </div>
          </div>
         
        </div>
      </div>
    </div>
  </div>
</form>
</body>
</html>