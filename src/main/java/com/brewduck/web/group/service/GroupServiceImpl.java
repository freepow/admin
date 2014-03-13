/**
 * @FileName  : AuthenticationNotException.java
 * @Project   : talenta
 * @Date      : 2013. 6. 26
 * @author    : hukoru
 */
package com.brewduck.web.group.service;

import com.brewduck.web.domain.Group;
import com.brewduck.web.group.dao.GroupDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author hukoru
 *
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GroupDao groupDao;
	
	@Override
	public List<Group> getSelectOne(Group group) throws Throwable {
		return groupDao.getSelectOne(group);
	}
	
}
