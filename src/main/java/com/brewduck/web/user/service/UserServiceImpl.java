/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru
 */
package com.brewduck.web.user.service;

import com.brewduck.web.account.service.AccountService;
import com.brewduck.web.domain.User;
import com.brewduck.web.user.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hukoru
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountService accountService;

    @Override
    public List<User> getSelectOne(User user) throws Throwable {
        return userDao.getSelectOne(user);
    }

    @Override
    public User selectUser(User user) throws RuntimeException {
        return userDao.selectUser(user);
    }

    @Override
    public void checkUser() throws RuntimeException {
        int accountId = accountService.selectAccountId(); //접속 중인 ID
        User user = new User();
        user.setAccountId(accountId);

        int userCnt = this.selectUserCnt(user);

        if(userCnt < 1){         //생성된 프로필이 없으면 생성
            this.insertUser(user);
        }
    }

    @Override
    public int selectUserCnt(User user) throws RuntimeException {
        return userDao.selectUserCnt(user);
    }

    @Override
    public int insertUser(User user) throws RuntimeException {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(User user) throws RuntimeException {
        return userDao.updateUser(user);
    }

}
