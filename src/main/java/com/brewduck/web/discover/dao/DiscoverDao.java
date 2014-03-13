package com.brewduck.web.discover.dao;

import com.brewduck.web.domain.Discover;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface DiscoverDao {

    /**
     * 설명
     *
     * @param discover
     * @return
     * @throws DataAccessException
     */
	List<Discover> getSelectOne(Discover discover) throws DataAccessException;
}
