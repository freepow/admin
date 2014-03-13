/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru

 */
package com.brewduck.web.search.dao;

import com.brewduck.web.domain.Search;
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
@Repository("searchDao")
public class SearchDaoImpl implements SearchDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSession sqlSession;

    @Override
	public List<Search> getSelectOne(Search search) throws DataAccessException {
		return sqlSession.selectList("Search.selectOne", search);
	}

}