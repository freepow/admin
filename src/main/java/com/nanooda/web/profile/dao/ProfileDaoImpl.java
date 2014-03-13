/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.nanooda.web.profile.dao;

import com.nanooda.web.domain.Profile;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao {
    private static final Logger logger = LoggerFactory.getLogger(ProfileDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Profile> selectProfileList(Profile profile) throws DataAccessException {
        return sqlSessionTemplate.selectList("Profile.selectProfileList", profile);
    }

    @Override
    public Profile selectProfile(Profile profile) throws DataAccessException {
        return sqlSessionTemplate.selectOne("Profile.selectAccount", profile);
    }

    @Override
    public int insertProfile(Profile profile) throws DataAccessException {
        return sqlSessionTemplate.insert("Profile.insertProfile", profile);
    }

    @Override
    public int selectProfileCnt(Profile profile) throws DataAccessException {
        return (Integer) sqlSessionTemplate.selectOne("Profile.selectProfileCnt", profile);
    }

}