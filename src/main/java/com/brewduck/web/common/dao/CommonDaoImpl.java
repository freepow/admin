/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.web.common.dao;

import com.brewduck.web.domain.Common;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("commonDao")
public class CommonDaoImpl implements CommonDao {
    private static final Logger logger = LoggerFactory.getLogger(CommonDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    /**
     * 성별
     *
     * @return
     * @throws org.springframework.dao.DataAccessException
     */
    @Override
    public List<Common> selectGenderList() throws DataAccessException {
        return sqlSessionTemplate.selectList("Common.selectGenderList");
    }

    @Override
    public List<Common> selectMonthList() throws DataAccessException {
        return sqlSessionTemplate.selectList("Common.selectMonthList");
    }


}