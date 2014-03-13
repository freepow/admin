/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru
 */
package com.nanooda.web.discover.service;

import com.nanooda.web.discover.dao.DiscoverDao;
import com.nanooda.web.domain.Discover;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author hukoru
 *
 */
@Service("discoverService")
public class DiscoverServiceImpl implements DiscoverService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoverDao discoverDao;
	
	@Override
	public List<Discover> getSelectOne(Discover discover) throws Throwable {
		return discoverDao.getSelectOne(discover);
	}
	
}
