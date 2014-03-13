/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.nanooda.web.common.service;

import com.nanooda.web.domain.Common;

import java.util.List;

public interface CommonService {

    /**
     * 성별 리스트
     *
     * @return
     * @throws RuntimeException
     */
    public List<Common> selectGenderList() throws RuntimeException;

    public List<Common> selectMonthList() throws RuntimeException;

}
