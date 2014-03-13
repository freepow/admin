/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.web.common.service;

import com.brewduck.web.common.dao.CommonDao;
import com.brewduck.web.domain.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommonDao commonDao;


    @Override
    public List<Common> selectGenderList() throws RuntimeException {
        return commonDao.selectGenderList();
    }

    @Override
    public List<Common> selectMonthList() throws RuntimeException {
        return commonDao.selectMonthList();
    }

}
