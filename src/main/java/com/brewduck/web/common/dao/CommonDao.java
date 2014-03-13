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
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CommonDao {


    /**
     * 성별 리스트
     *
     * @return
     * @throws com.brewduck.framework.exception.DBHandleException
     */
	public List<Common> selectGenderList() throws DataAccessException;

    public List<Common> selectMonthList() throws DataAccessException;


}
