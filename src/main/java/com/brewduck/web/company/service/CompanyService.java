/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author hukoru
 */
package com.brewduck.web.company.service;

import com.brewduck.web.domain.Company;

import java.util.List;


/**
 * @author yion
 *
 */
public interface CompanyService {

	/**
	 * �닿� 媛�엯 �좎껌���댁뿭, �섎� 珥덈����댁뿭��議고쉶�쒕떎. 
	 * @param joinDomain
	 * @return
	 * @throws Throwable
	 */
	List<Company> getSelectOne(Company company) throws Throwable;
}
