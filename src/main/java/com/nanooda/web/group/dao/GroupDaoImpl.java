/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru

 */
package com.nanooda.web.group.dao;

import com.nanooda.web.domain.Group;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yion
 *
 */
@Repository("groupDao")
public class GroupDaoImpl implements GroupDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSession sqlSession;

    @Override
	public List<Group> getSelectOne(Group group) throws DataAccessException {
		return sqlSession.selectList("Group.selectOne", group);
	}

}