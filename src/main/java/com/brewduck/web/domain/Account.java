package com.brewduck.web.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 계정 정보
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final GuestUser GUEST_USER = new GuestUser();


    public Account() {
    }

    public Account(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Account(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }


    // UserId
    private int id;

    @NotEmpty(message = "이메일은 필수 입력입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @Size(min = 6, max = 255, message = "이메일은 6자에서 250자까지 입력 가능합니다.")
    private String email;

    @NotEmpty(message = "성명은 필수 입력입니다.")
    @Size(min = 2, max = 100, message = "성명는 2자에서 100자까지 입력하세요.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수 입력입니다.")
    @Size(min = 6, max = 200, message = "비밀번호는 6자에서 200자까지 입력하세요.")
    private String password;

    @NotEmpty(message = "동의하셔야 회원가입이 가능합니다.")
    private String commentEmailAgree;

    @NotEmpty(message = "동의하셔야 회원가입이 가능합니다.")
    private String emailAgree;

    @NotEmpty(message = "동의하셔야 회원가입이 가능합니다.")
    private String policyAgree;


    // 권한
    private String authority;

    // 계정 활성화 (ENABLE / DISABLE)
    private String activation;

    private String checkPassword;

    public String getCommentEmailAgree() {
        return commentEmailAgree;
    }

    public void setCommentEmailAgree(String commentEmailAgree) {
        this.commentEmailAgree = commentEmailAgree;
    }

    public String getEmailAgree() {
        return emailAgree;
    }

    public void setEmailAgree(String emailAgree) {
        this.emailAgree = emailAgree;
    }

    public String getPolicyAgree() {
        return policyAgree;
    }

    public void setPolicyAgree(String policyAgree) {
        this.policyAgree = policyAgree;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getActivation() {
        return activation;
    }
    public void setActivation(String activation) {
        this.activation = activation;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public boolean isGuest() {
        return false;
    }

    public static class GuestUser extends Account {
        private GuestUser guestUser;

        GuestUser() {
            guestUser = new GuestUser(0, "GUEST","GUEST");
        }

        GuestUser(Integer id, String email, String name) {
            super(id, email, name);
        }

        @Override
        public boolean isGuest() {
            return true;
        }

        public GuestUser getGuestUser() {
            return guestUser;
        }
    }

}
