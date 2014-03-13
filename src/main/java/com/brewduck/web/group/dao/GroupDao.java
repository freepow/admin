package com.brewduck.web.group.dao;

import com.brewduck.web.domain.Group;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface GroupDao {

    /**
     * 설명
     *
     * @param group
     * @return
     * @throws DataAccessException
     */
	List<Group> getSelectOne(Group group) throws DataAccessException;
}
