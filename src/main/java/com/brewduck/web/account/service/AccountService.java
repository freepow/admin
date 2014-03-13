/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.web.account.service;

import com.brewduck.web.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     *  회원정보 조회
     *
     * @param account
     * @return
     * @throws RuntimeException
     */
    public Account selectAccount(Account account) throws RuntimeException;

    /**
     * 회원정보 목록 조회
     *
     * @param account
     * @return
     * @throws RuntimeException
     */
    public List<Account> selectAccountList(Account account) throws RuntimeException;

    /**
     * 회원 가입
     *
     * @param account
     * @return
     * @throws RuntimeException
     */
    public int insertAccount(Account account) throws RuntimeException;

    /**
     * 계정 ID 조회
     *
     * @return
     * @throws RuntimeException
     */
    public int selectAccountId() throws RuntimeException;

    /**
     * 회원 정보 수정
     *
     * @param account
     * @return
     */
    public int updateAccount(Account account) throws RuntimeException;

}
