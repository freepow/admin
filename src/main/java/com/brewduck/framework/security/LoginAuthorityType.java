package com.brewduck.framework.security;

/**
 * Created with IntelliJ IDEA.
 * User: JAEGER
 * Date: 13. 8. 19
 * Time: 오전 10:31
 * To change this template use File | Settings | File Templates.
 */
public enum LoginAuthorityType {
    ROLE_SIGNIN("로그인 사용자"),
    ROLE_USER("로그인 인증 사용자"),
    ROLE_MANAGER("매니저"),
    ROLE_ADMIN("관리자");

    private String description;

    LoginAuthorityType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
