package com.nanooda.framework.security;

import com.nanooda.framework.exception.AuthenticationNotException;
import com.nanooda.framework.exception.PasswordMismatchException;
import com.nanooda.framework.exception.UserNotFoundException;
import com.nanooda.web.account.service.AccountService;
import com.nanooda.web.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Jaeger
 * Date: 13. 9. 14.
 * Time: 오후 4:41
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "authenticationService")
public class UserIdPasswordAuthenticationService implements AuthenticationService {
    private static Logger logger = LoggerFactory.getLogger(UserIdPasswordAuthenticationService.class);

    @Autowired
    AccountService accountService;

    @Override
    public void login(String email, String password) throws Throwable, UserNotFoundException, AuthenticationNotException, PasswordMismatchException {
        if (StringUtils.isEmpty(email)) {
            throw new UserNotFoundException("### 이메일 정보가 존재하지 않습니다.");
        }

        Account account = new Account(email, password);
        Account result = accountService.selectAccount(account);

        if (result == null) {
            throw new UserNotFoundException("### 회원 정보가 존재하지 않습니다.");
        }

        // [TODO]
        // 향후에는 패스워드 암호화 필요
        // 이메일 인증 회원인지 체크 필요
        //     throw new AuthenticationNotException("### 이메일 인증이 필요합니다.");
        if ( ! result.getPassword().equals(password)) {
            throw new PasswordMismatchException("### 비밀번호가 틀렸습니다.");
        }
    }

}
