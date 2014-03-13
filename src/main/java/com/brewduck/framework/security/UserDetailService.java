package com.brewduck.framework.security;

import com.brewduck.web.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


/**
 * Created with IntelliJ IDEA.
 * User: JAEGER
 * Date: 13. 8. 19
 * Time: 오전 9:37
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailService extends User {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);
    private Account account;

    public UserDetailService(String username,
                             String password,
                             boolean enabled,
                             boolean accountNonExpired,
                             boolean credentialsNonExpired,
                             boolean accountNonLocked,
                             Collection<? extends GrantedAuthority> authorities,
                             Account account) {
        super(username,
              password,
              enabled,
              accountNonExpired,
              credentialsNonExpired,
              accountNonLocked,
              authorities);

        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }
}
