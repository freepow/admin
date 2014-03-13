/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru
 */
package com.nanooda.web.company.service;

import com.nanooda.web.company.dao.CompanyDao;
import com.nanooda.web.domain.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author hukoru
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public List<Company> getSelectOne(Company company) throws Throwable {
		return companyDao.getSelectOne(company);
	}
	
}
