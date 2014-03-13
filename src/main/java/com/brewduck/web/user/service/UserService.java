/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author hukoru
 */
package com.brewduck.web.user.service;

import com.brewduck.web.domain.User;

import java.util.List;


/**
 * @author hukoru
 *
 */
public interface UserService {


	List<User> getSelectOne(User user) throws Throwable;

    public User selectUser(User user) throws RuntimeException;

    public void checkUser() throws RuntimeException;

    public int insertUser(User user) throws RuntimeException;

    public int updateUser(User user) throws RuntimeException;

    public int selectUserCnt(User user) throws RuntimeException;
}
