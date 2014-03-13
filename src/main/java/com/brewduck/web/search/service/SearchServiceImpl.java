/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru
 */
package com.brewduck.web.search.service;

import com.brewduck.web.search.dao.SearchDao;
import com.brewduck.web.domain.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author hukoru
 *
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public List<Search> getSelectOne(Search search) throws Throwable {
		return searchDao.getSelectOne(search);
	}
	
}
