<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<style>
#comments {border : 1px dotted blue;}
</style>
<script src="${pageContext.request.contextPath}/scripts/jquery-3.2.1.min.js"></script>
<script>
	window.onload = function() {
		loadCommentList();  // 목록조회 ajax 요청
	}
	var context='${pageContext.request.contextPath}';
	
	//목록조회 요청
	function loadCommentList() {
		var params ={boardSeq : '${board.seq}'}
		$.getJSON(context+"/getCommentsList",params,function(datas){
			for(i=0; i<datas.length;i++){
				$("#commentList").append(makeCommentView(datas[i]) );
			}
		})
	}
	
	//div 생성 
	function makeCommentView(comment){
		var div = document.createElement("div"); 
		div.setAttribute("id", "c"+comment.seq);
		div.className = 'comment';
		div.comment = comment;  //{id:1,.... }
		
		var str = "<strong>" + comment.name + "</strong>" + comment.content
				  +"<input type=\"button\" value=\"수정\" onclick=\"viewUpdateForm('"+comment.seq+"')\"/>"
				  +"<input type=\"button\" value=\"삭제\" onclick=\"confirmDeletion('"+comment.seq+"')\"/>"
		div.innerHTML = str;
		return div;
	}
	
	//댓글 등록
	function addComment(){
		var param =$("[name='addForm']").serialize();
		$.getJSON("../insertComments", param, function(datas){
			$("#commentList").append(makeCommentView(datas) );
			document.addForm.reset();
		})
	}
	
	//댓글삭제
	function confirmDeletion(seq){
		if(confirm("삭제하시겠습니까?")){
			var param={seq : seq}
			$.getJSON("../deleteComments",param,function(){
				$("#c"+seq).remove();		
			})
		}
	}
	
	function viewUpdateForm(commentId) {
		var commentDiv = document.getElementById('c'+commentId);
		var updateFormDiv = document.getElementById('commentUpdate');
		//현재 수정상태(수정폼이 보이고 있음)이면 수정폼이 보이게 할 필요 없음
		if (updateFormDiv.parentNode != commentDiv) {
			commentDiv.appendChild(updateFormDiv);  //수정폼을 수정할 댓글밑에 보이도록
		}
		//수정할 값을 텍스트필드에 보이게
		var comment = commentDiv.comment;   //댓글 객체 { id:'', content:'', name:'' }
		document.updateForm.seq.value = comment.seq;    
		document.updateForm.name.value = comment.name;
		document.updateForm.content.value = comment.content;
		updateFormDiv.style.display = '';   //수정폼 보이게
	}
	
	//댓글 수정
	function updateComment(){
		var param=$("[name='updateForm']").serialize();
		$.getJSON("../updateComments", param, function(datas){
			
			var newDiv = makeCommentView(datas);
			var oldDiv = $("#c"+datas.seq);
			
			document.updateForm.reset();	//폼 필드 클리어
			$("#comments").append($("#commentUpdate")); //수정폼 div를 이동
			$("#commentUpdate").hide(); //수정 폼div 바디로 이동
			$(newDiv).replaceAll(oldDiv); //수정된 div 교체
		})
	}
	
	
	
	

</script>

</head>
<body>

${boardVO.title}
<hr>

	<h1>게시글조회</h1>
	번호 ${board.seq}<br>
	작성자 ${board.writer}<br>
	작성일자 ${board.regDate}<br>
	작성제목 ${board.title}<br>
	작성내용 ${board.content}<br>
	<a href="../updateBoardForm/${board.seq}">수정</a>
	<a href="../deleteBoard/${board.seq}">삭제</a>
	<a href="getBoardList">목록으로</a>


	<div id="comments" >
		<div id="commentList"></div>

		<!-- 댓글등록시작 -->
		<div id="commentAdd">
			<form action="" name="addForm">
				<input type="hidden" name="boardSeq" value="${board.seq}">
				이름: <input type="text" name="name" size="10"><br/> 
				내용: <textarea name="content" cols="20" rows="2"></textarea><br />
				 <input type="button" value="등록" onclick="addComment()" />
			</form>
		</div>
		<!-- 댓글등록끝 -->

		<!-- 댓글수정폼시작 -->
		<div id="commentUpdate" style="display: none">
			<form action="" name="updateForm">
				<input type="hidden" name="boardSeq" value="${board.seq}"> 
				<input type="hidden" name="seq" value="" /> 
				이름: <input type="text"name="name" size="10"><br /> 
				내용: <textarea name="content" cols="20" rows="2"></textarea><br /> 
				<input type="button" value="등록" onclick="updateComment()" />
				<input type="button" value="취소" onclick="cancelUpdate()" />
			</form>
		</div>
		<!-- 댓글수정폼끝 -->

	</div>



</body>
</html>