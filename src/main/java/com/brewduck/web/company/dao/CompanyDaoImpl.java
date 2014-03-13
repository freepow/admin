/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru

 */
package com.brewduck.web.company.dao;

import com.brewduck.web.domain.Company;
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
@Repository("companyDao")
public class CompanyDaoImpl implements CompanyDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSession sqlSession;

	@Override
	public List<Company> getSelectOne(Company company) throws DataAccessException {
		return sqlSession.selectList("Company.selectOne", company);
	}

}