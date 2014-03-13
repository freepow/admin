package com.nanooda.framework.security;

import com.nanooda.framework.exception.AuthenticationNotException;
import com.nanooda.framework.exception.PasswordMismatchException;
import com.nanooda.framework.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 4:58
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationProviderImpl implements AuthenticationProvider, InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationProviderImpl.class);

    private AuthenticationService authenticationService;
    private UserDetailsService userDetailsService;

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.authenticationService, "AuthenticationService is Mandatory.");
        Assert.notNull(this.userDetailsService, "UserDetailsService is Mandatory.");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        try {
            this.login(email, password);
        } catch (AuthenticationNotException e) {
            logger.error("### AuthenticationNotException Occurred.", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private void login(String email, String password) throws AuthenticationNotException {
        logger.warn("### login email : {}", email);
        logger.warn("### login password : {}", password);

        try {
            authenticationService.login(email, password);
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(e.getMessage(), e);
        } catch (PasswordMismatchException e) {
            throw new BadCredentialsException(e.getMessage(), e);
        } catch(AuthenticationNotException e) {
            throw new AuthenticationNotException(e.getMessage(), e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
