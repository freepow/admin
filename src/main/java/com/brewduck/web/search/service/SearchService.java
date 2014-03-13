/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author hukoru
 */
package com.brewduck.web.search.service;

import com.brewduck.web.domain.Search;

import java.util.List;


/**
 * @author yion
 *
 */
public interface SearchService {

	/**
	 * 占쎈떯占�揶쏉옙��占쎌쥙猿뚳옙占쏙옙�곷열, 占쎌꼶占��λ뜄占쏙옙占쏙옙�곷열占쏙옙鈺곌퀬�띰옙�뺣뼄. 
	 * @param joinDomain
	 * @return
	 * @throws Throwable
	 */
	List<Search> getSelectOne(Search search) throws Throwable;
}
