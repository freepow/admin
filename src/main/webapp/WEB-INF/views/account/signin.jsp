<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Content -->
<div class="bg_color">
    <div class="clear padding30"></div>
    <section class="container clearfix">

        <!-- Page Title -->
        <header class="container page_info clearfix">
            <h1>회원가입</h1>
        </header>
        <!-- /Page Title -->
        <div class="clear padding20"></div>
        <div class="container">
            <div class="border1_wrap clearfix">

                <div class="member_register_wrap">

                    <form:form action="/account/join" id="join" method="post" modelAttribute="account" class="member_register_form">
                        <div>
                            <label for="name">이름</label>
                            <form:input class="inputText" path="name" type="text"   />
                            <form:errors path='name' />
                        </div>
                        <div class="clear"></div>
                        <div>
                            <label for="email">이메일</label>
                            <form:input class="inputText" path="email" type="text"  />
                            <form:errors path='email' />
                        </div>
                        <div class="clear"></div>
                        <div>
                            <label for="password">비밀번호</label>
                            <form:input class="inputText" path="password" type="password" />
                        </div>
                        <div class="clear"></div>
                        <div>
                            <label for="checkPassword">비밀번호 확인</label>
                            <form:input class="inputText" path="checkPassword" type="password" />
                            <form:errors path="password" />
                        </div>
                        <div class="clear"></div>
                        <div>
                            <form:checkbox path="emailAgree" value="Y" class="chkbox"  />  메일수신 동의
                            <form:errors path='emailAgree' />
                        </div>
                        <div class="clear"></div>
                        <div>
                            <form:checkbox path="commentEmailAgree" value="Y" class="chkbox" />  댓글 알림 메일수신동의
                            <form:errors path='commentEmailAgree' />
                        </div>
                        <div class="clear"></div>
                        <div>
                            <form:checkbox path="policyAgree" value="Y" class="chkbox" />
                            <a href="policies_terms.html" target="_blank">이용약관</a>과 <a href="/company/policies_privacy" target="_blank">개인정보취급방침</a> 동의
                            <form:errors path='policyAgree' />
                        </div>
                        <div class="clear"></div>
                        <div class="clear padding20"></div>
                        <div class="member_btn ag_center">
                            <button type="submit" class="green-button">회원가입</button>
                        </div>
                    </form:form>
                </div>

                <div class="member_register_wrap_right">
                    <div class="member_btn ag_center">
                        <a href="#" class="facebook-button">페이스북으로 회원가입</a>
                    </div>
                </div>

            </div>
            <div class="clear"></div>
        </div>

    </section>
    <div class="clear padding80"></div>
</div>
<!-- /Content -->