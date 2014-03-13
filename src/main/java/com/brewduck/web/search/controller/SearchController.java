package com.brewduck.web.search.controller;

import com.brewduck.web.domain.Search;
import com.brewduck.web.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The Class SearchController.
 */
@Controller
public class SearchController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;
	
	/**
	 * Gets the all.
	 * 
	 * @param map 
	 * @return the all
	 * @throws Throwable 
	 */
	@RequestMapping(value = "/search/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map,
			final HttpServletRequest request) throws Throwable {
		List<Search> searchs = this.searchService.getSelectOne(new Search());
		
		map.put("searchs", searchs);
	}
}
