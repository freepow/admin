package com.nanooda.framework.security;

import com.nanooda.framework.exception.LoginBusinessException;
import com.nanooda.web.account.service.AccountService;
import com.nanooda.web.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: JAEGER
 * Date: 13. 8. 19
 * Time: 오전 9:37
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, DataAccessException {


        logger.warn("@@@@@@@@@@@@@@@@@@@@@@@@@");

        Account accountByEmail = new Account();
        accountByEmail.setEmail(email);

        Account account;

        try {
            account = accountService.selectAccount(accountByEmail);
        } catch (Throwable e) {
            throw new LoginBusinessException("이메일 정보로 회원 정보 가져오는 도중 오류 발생", e);
        }

        if (account != null) {
            // 추후 언제 로그인 했는지 기록 예정

            return new User(account.getEmail(),
                            account.getPassword(),
                            true,
                            true,
                            true,
                            true,
                            this.createAuthorities(account)
                        );
        }

        return null;
    }

    /**
     * 조회한 사용자 데이터를 활용해 권한을 정의한다.
     *
     * @param loginUser
     * @return
     */
    public Collection<GrantedAuthority> createAuthorities(Account loginUser) {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        // 로그인한 경우에 ROLE_SIGNIN 권한 기본적으로 부여
        authorities.add(new SimpleGrantedAuthority(LoginAuthorityType.ROLE_SIGNIN.name()));

        // 로그인 인증 사용자 권한 부여
        if ( LoginAuthorityType.ROLE_USER.name().equals(loginUser.getAuthority()) ) {
            authorities.add(new SimpleGrantedAuthority(LoginAuthorityType.ROLE_USER.name()));
        }

        // 매니저 권한 부여
        if ( LoginAuthorityType.ROLE_MANAGER.name().equals(loginUser.getAuthority()) ) {
            authorities.add(new SimpleGrantedAuthority(LoginAuthorityType.ROLE_MANAGER.name()));
        }

        // 관리자 권한 부여
        if ( LoginAuthorityType.ROLE_ADMIN.name().equals(loginUser.getAuthority()) ) {
            authorities.add(new SimpleGrantedAuthority(LoginAuthorityType.ROLE_ADMIN.name()));
        }

        return authorities;
    }
}
