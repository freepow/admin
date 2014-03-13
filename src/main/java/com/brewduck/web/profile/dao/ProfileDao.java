/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.web.profile.dao;

import com.brewduck.web.domain.Profile;
import org.springframework.dao.DataAccessException;

import java.util.List;


public interface ProfileDao {

    /**
     * 프로필 정보 조회
     *
     * @param profile
     * @return
     * @throws DataAccessException
     */
    public Profile selectProfile(Profile profile) throws DataAccessException;

    /**
     * 프로필 정보 목록 조회
     *
     * @param profile
     * @return
     * @throws me.talentea.framework.exception.DBHandleException
     */
    public List<Profile> selectProfileList(Profile profile) throws DataAccessException;

    /**
     * 프로필 기초데이터 생성
     *
     * @param profile
     * @throws me.talentea.framework.exception.DBHandleException
     */
    public int insertProfile(Profile profile) throws DataAccessException;

    /**
     * 프로필 데이터 조회
     *
     * @param profile
     * @throws me.talentea.framework.exception.DBHandleException
     */
    public int selectProfileCnt(Profile profile) throws DataAccessException;
}
