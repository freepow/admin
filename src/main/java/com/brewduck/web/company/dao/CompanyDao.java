/**
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @작성자      : @author hukoru

 * @변경이력    :
 * @프로그램 설명 :
 */
package com.brewduck.web.company.dao;

import com.brewduck.web.domain.Company;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CompanyDao {

    /**
     * 설명
     *
     * @param company
     * @return
     * @throws DataAccessException
     */
    public List<Company> getSelectOne(Company company) throws DataAccessException;

}
