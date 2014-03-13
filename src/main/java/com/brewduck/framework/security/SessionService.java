package com.brewduck.framework.security;

import com.brewduck.web.domain.Account;

/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 5:37
 * To change this template use File | Settings | File Templates.
 */
public class SessionService {

    /**
     * 로그인 유무를 확인한다.
     *
     * @return
     */
    public boolean isAuthenticated() {
        return AuthenticationUtils.isAuthenticated();
    }

    /**
     * null을 리턴하지 않는다. 비로그인의 경우 비로그인 객체를 리턴한다.
     *
     * @return
     */
    public Account getLoginUser() {
        return AuthenticationUtils.getUser();
    }

    /**
     * 로그인 사용자가 특정 ROLE을 가지고 있는가?
     *
     * @param authorityType
     * @return
     */
    public boolean hasRole(LoginAuthorityType authorityType) {
        return AuthenticationUtils.hasRole(authorityType);
    }
}
