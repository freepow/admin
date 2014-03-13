<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>
    $(document).ready(function () {
        $('#login').click(function(){
            $.post("authenticate",
                {
                    j_username:$('#j_username').val(),
                    j_password:$('#j_password').val()
                },
            function(data,status){
                parent.move();
            });


            return false;
            //$.prettyPhoto.close();
        });
    });
</script>
<!-- signin content -->
<!-- qna content -->
<div id="member_signin" class="popup_wrap member_signin_wrap">
    <h1>로그인</h1>
    <div class="popup_content-wrap">
        <form method="post" action="authenticate">
            <div>
                <label for="email">이메일</label>
                <input class="inputText" type="text" name="j_username" id="j_username">
            </div>
            <div class="clear"></div>
            <div>
                <label for="password">비밀번호</label>
                <input class="inputText" type="text" name="j_password" id="j_password">
            </div>
            <div class="clear"></div>
            <div>
                <input class="chkbox" type="checkbox" id="" value="" /> 로그인상태 유지
            </div>
            <div class="clear padding20"></div>
            <div id="login" class="member_btn ag_center">
                <button class="green-button">로그인</button>
            </div>
        </form>
        <div class="clear padding20"></div>

    </div>
    <div class="clear padding10"></div>
    <div class="member_btn ag_center">
        <span> 또는</span>
    </div>
    <div class="clear padding10"></div>
    <div class="popup_content-wrap">
        <div class="member_btn ag_center">
            <a href="#" class="facebook-button">페이스북으로 로그인</a>
        </div>
        <div class="clear padding20"></div>
    </div>

    <div class="clear padding10"></div>
    <div class="member_btn ag_center fs14">
        <a href="#">회원가입</a> <span> | </span> <a href="member_password.html">비밀번호찾기</a>
    </div>
</div>
<!-- /qna content -->