package com.nanooda.web.user.dao;

import com.nanooda.web.domain.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserDao {

	public List<User> getSelectOne(User user) throws DataAccessException;

    public User selectUser(User user) throws DataAccessException;

    /**
     * 유저 기초데이터 생성
     *
     * @param user
     * @throws com.nanooda.framework.exception.DBHandleException
     */
    public int insertUser(User user) throws DataAccessException;

    /**
     * 프로필 유저 기초정보 업데이트
     *
     * @param user
     * @throws com.nanooda.framework.exception.DBHandleException
     */
    public int updateUser(User user) throws DataAccessException;

    /**
     * 유저 데이터 조회
     *
     * @param user
     * @throws com.nanooda.framework.exception.DBHandleException
     */
    public int selectUserCnt(User user) throws DataAccessException;
}
