package com.nanooda.framework.security;

import com.nanooda.web.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Collection;


/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 3:45
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationUtils {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationUtils.class);

    public static Authentication getAuthentication() {
        if (SecurityContextHolder.getContext() == null) {
            return null;
        }

        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthentication().getAuthorities();
    }

    public static boolean hasRole(LoginAuthorityType authorityType) {
        return getAuthorities().contains(new SimpleGrantedAuthority(authorityType.name()));
    }

    public static Account getUser() {
        return getUser(getAuthentication());
    }

    public static Account getUser(Authentication authentication) {
        if (authentication == null) {
            return Account.GUEST_USER.getGuestUser();
        }

        Object principal = authentication.getPrincipal();
        if (principal == null) {
            throw new NullPointerException("### Principal should not null!");
        }

        if (principal instanceof UserDetailService) {
            UserDetailService userDetails = (UserDetailService) principal;
            Account account = userDetails.getAccount();
            return account;
        } else {
            return Account.GUEST_USER.getGuestUser();
        }
    }

    public static int getCurrentUserId() {
        if (getUser() == null) {
            Account account = Account.GUEST_USER.getGuestUser();
            return account.getId();
        }

        return getUser().getId();
    }

    public static boolean isAuthenticated() {
        if (getAuthentication() == null) {
            return false;
        }

        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
        if (getAuthentication().isAuthenticated()) {
            return !trustResolver.isAnonymous(getAuthentication());
        }
        return false;
    }
}
