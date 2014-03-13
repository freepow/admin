/**
 * @FileName  : DiscoverDaoImpl.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru

 */
package com.brewduck.web.discover.dao;

import com.brewduck.web.domain.Discover;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("discoverDao")
public class DiscoverDaoImpl implements DiscoverDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSession sqlSession;

	@Override
	public List<Discover> getSelectOne(Discover discover) throws DataAccessException {
		return sqlSession.selectList("Discover.selectOne", discover);
	}

}