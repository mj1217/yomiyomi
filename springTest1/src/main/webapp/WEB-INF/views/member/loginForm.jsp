<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
$(document).ready(function(){
    $("#btnLogin").click(function(){
        // 태크.val() : 태그에 입력된 값
        // 태크.val("값") : 태그의 값을 변경 
        var member_id = $("#member_id").val();
        var pwd = $("#pwd").val();
        
        if(member_id == ""){
            alert("아이디를 입력하세요.");
            $("#member_id").focus(); // 입력포커스 이동
            return false; // 함수 종료
        }
        if(pwd == ""){
            alert("비밀번호를 입력하세요.");
            $("#pwd").focus();
            return false;
        }
        
        // 제출
        document.form1.submit();
    });
});
</script>

<form action="login" name="form1" method="post" style="margin-bottom:450px;">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card-group">
          <div class="card p-4">
            <div class="card-body">
              <h1>Login</h1>
              <p class="text-muted">Sign In to your account</p>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="icon-user"></i></span>
                </div>
                <input type="text" id="member_id" class="form-control" placeholder="Username" name="member_id" >
              </div>
              <div class="input-group mb-4">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="icon-lock"></i></span>
                </div>
                <input type="password" id="pwd" class="form-control" placeholder="Password" name="pwd"  onkeypress="if(event.keyCode==13){$('#btnLogin').click();}"/>
              </div>
              <div class="row">
                <div class="col-6">
                  <button type="button" id="btnLogin" name="btnLogin" class="btn btn-primary px-4" value="login"> Login </button>
                </div>
                <!-- <input type="submit" value="login"> -->
                <div class="col-6 text-right">
                  <button type="button" id="find_pwd" name="find_pwd" class="btn btn-link px-0" value="Forgot password?" onclick="location.href='find_pwd'" >
                  Forgot password?
                  </button> 
                </div>
              </div>
            </div>
          </div>
         
        </div>
      </div>
    </div>
  </div>
</form>

    