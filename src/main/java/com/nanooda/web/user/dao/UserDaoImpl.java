/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru

 */
package com.nanooda.web.user.dao;

import com.nanooda.web.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hukoru
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
	public List<User> getSelectOne(User user) throws DataAccessException {
		return sqlSessionTemplate.selectList("User.selectOne", user);
	}


    /**
     * 유저 정보 조회
     *
     * @param user
     * @return
     * @throws DataAccessException
     */
    @Override
    public User selectUser(User user) throws DataAccessException {
        return sqlSessionTemplate.selectOne("User.selectUser", user);
    }

    @Override
    public int insertUser(User user) throws DataAccessException {
        return sqlSessionTemplate.insert("User.insertUser", user);
    }

    @Override
    public int updateUser(User user) throws DataAccessException {
        return sqlSessionTemplate.insert("User.updateUser", user);
    }


    @Override
    public int selectUserCnt(User user) throws DataAccessException {
        return (Integer) sqlSessionTemplate.selectOne("User.selectUserCnt", user);
    }

}