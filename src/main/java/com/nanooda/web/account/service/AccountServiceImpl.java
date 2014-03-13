/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.nanooda.web.account.service;

import com.nanooda.framework.crypto.SimpleCrypto;
import com.nanooda.framework.mail.MailService;
import com.nanooda.web.account.dao.AccountDao;
import com.nanooda.web.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountDao accountDao;


    @Override
    public Account selectAccount(Account account) throws RuntimeException {
        return accountDao.selectAccount(account);
    }

    @Override
    public List<Account> selectAccountList(Account account) throws RuntimeException {
        return accountDao.selectAccountList(account);
    }

    @Override
    public int selectAccountId() throws RuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 로그인 안하고 호출하면 계정 ID는 0으로 세팅
        if (authentication == null) {
            return 0;
        }

        Account accountByEmail = new Account();
        accountByEmail.setEmail( authentication.getName() );

        Account account = this.selectAccount(accountByEmail);
        return account.getId();
    }

    /**
     * 회원 가입
     *
     * @param account
     * @return
     * @throws RuntimeException
     */
    @Transactional
    @Override
    public int insertAccount(Account account) throws RuntimeException {
        int insertCount = 0;
        int duplicateEmail = -99;

        String authKey = null;
        boolean result = false;

        Account currentAccount = accountDao.selectAccount(account);

        // 이메일 조회시 회원 정보 없으면 가입 처리
        if (currentAccount == null) {
            // 회원 가입 후 UserId 리턴
            insertCount = accountDao.insertAccount(account);
            logger.debug("가입 UserId : " + account.getId());

            // 가입 완료 후 이메일 전송
            if (insertCount > 0) {
                try {
                    authKey = SimpleCrypto.encrypt(
                                    SimpleCrypto.seed,
                                    String.valueOf(account.getId())
                                );
                    logger.debug("가입 인증키 : " + authKey);
                } catch (Exception e) {
                    throw new RuntimeException("이메일 인증키 암호화하는 도중에 오류가 발생하였습니다.", e);
                }

                if (authKey != null) {
                    MailService mailService = new MailService();
                    result = mailService.sendMail(
                                    account.getEmail(),
                                    "[나누다 뮤직] 회원가입을 진심으로 축하드립니다",
                                    "<a href='http://localhost:8080/account/activation/" + authKey + "' target='_blank'>이메일 인증</a>"
                                );

                    // 이메일 전송이 실패되면 회원 가입 롤백
                    if ( ! result ) {
                        throw new RuntimeException("이메일 발송 실패하였습니다.");
                    }
                }
            }
        }
        // 동일한 이메일이 존재하는지 체크
        else if (currentAccount.getEmail().equalsIgnoreCase(account.getEmail())) {
            return duplicateEmail;
        }
        else {
            logger.debug("회원 가입 처리");
        }

        return insertCount;
    }

    /**
     * 회원 정보 수정
     *
     * @param account
     * @return
     */
    @Override
    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

}
