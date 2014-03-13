package com.nanooda.web.discover.dao;

import com.nanooda.web.domain.Discover;
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
